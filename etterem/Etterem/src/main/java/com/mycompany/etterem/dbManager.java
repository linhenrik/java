/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.etterem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linhenrik
 */
public class dbManager {
    private final Connection connection;

    public dbManager() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:Etterem.db");
        System.out.println("sikeres connect");
    }
    
    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }
    
    public List<RendelesQuery> getAll() throws SQLException {
        List<RendelesQuery> rendelesek = new ArrayList<>();
        String sql = "SELECT r.id, r.datum, r.ugyfel_nev, e.nev AS etel_nev, r.mennyiseg FROM rendelesek r INNER JOIN etelek e ON r.etel_id = e.id";
        try (Statement stmt = getStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
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
    
    public String getExpensive() throws SQLException{
        String sql = "SELECT nev FROM etelek WHERE ar = (SELECT MAX(ar) FROM etelek)";
        try (Statement stmt = getStatement(); ResultSet rs = stmt.executeQuery(sql)){
            StringBuilder result = new StringBuilder();
            while(rs.next()){
                if(result.length() > 0){
                    result.append(", ");
                }
                result.append(rs.getString("nev"));
            }
            return result.toString();
        }
    }
    
    public void addNewMenu(String nev, int ar) throws SQLException{
        String sql = "INSERT INTO etelek (nev, ar) VALUES (?, ?)";
        try(PreparedStatement ptsmt = connection.prepareStatement(sql)){
            ptsmt.setString(1, nev);
            ptsmt.setInt(2, ar);
            ptsmt.executeUpdate();
            System.out.println("hozzáadva");
        }
    }
    
    public void setNewPrice(int id, int ar) throws SQLException{
        String sql = "UPDATE etelek SET ar = ? WHERE id = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.setInt(2, ar);
            pstmt.executeUpdate();
            System.out.println("hozzáadva");
        }
    }
}
