/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.etterem;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author szoky
 */



public class DbManager {
    private final Connection connection;

    // Adatbázis kapcsolat létrehozása
    public DbManager(String dbFile) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        System.out.println("Csatlakozás az adatbázishoz sikeres.");
    }

    // Kapcsolat bezárása
    public void close() throws SQLException {
        if (connection != null) connection.close();
        System.out.println("Kapcsolat lezárva.");
    }

    // Segédfüggvény a Statement létrehozásához
    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }

    // Összes rendelés listázása (RendelesQuery)
    public List<RendelesQuery> getAll() throws SQLException {
        List<RendelesQuery> rendelesek = new ArrayList<>();
        String sql = "SELECT r.id, r.datum, r.ugyfel_nev, e.nev AS etel_nev, r.mennyiseg " +
                     "FROM rendelesek r INNER JOIN etelek e ON r.etel_id = e.id";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                LocalDateTime datum = LocalDateTime.parse(rs.getString("datum"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                rendelesek.add(new RendelesQuery(
                        rs.getInt("id"),
                        datum,
                        rs.getString("ugyfel_nev"),
                        rs.getString("etel_nev"),
                        rs.getInt("mennyiseg")
                ));
            }
        }
        return rendelesek;
    }

    // Legdrágább étel neve (getExpensive)
    public String getExpensive() throws SQLException {
        String sql = "SELECT nev FROM etelek WHERE ar = (SELECT MAX(ar) FROM etelek)";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            StringBuilder result = new StringBuilder();
            while (rs.next()) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(rs.getString("nev"));
            }
            return result.toString();
        }
    }

    // Új étel hozzáadása (addNewMenu)
    public void addNewMenu(String nev, int ar) throws SQLException {
        String sql = "INSERT INTO etelek (nev, ar) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nev);
            pstmt.setInt(2, ar);
            pstmt.executeUpdate();
            System.out.println("Új étel hozzáadva.");
        }
    }

    // Étel árának módosítása (setNewPrice)
    public boolean setNewPrice(int etelId, int ujAr) throws SQLException {
        String sql = "UPDATE etelek SET ar = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, ujAr);
            pstmt.setInt(2, etelId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }
}

