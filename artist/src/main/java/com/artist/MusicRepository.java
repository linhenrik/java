/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artist;

import java.sql.Connection; // <- az importokat nem kell kézzel beírni, kódírás közben importálható
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linhenrik
 */
public class MusicRepository {
    private String databaseUrl = "jdbc:sqlite:Music.db";

    public MusicRepository(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }
    
    private Connection connect() throws SQLException { // <- sql kapcsolat inicalizálása
        return DriverManager.getConnection(databaseUrl);
    }
    
    public List<TrackQuery> getAll() throws SQLException {
        List<TrackQuery> result = new ArrayList<>();
        String sql = "SELECT t.TrackId, t.Name, t.AlbumId, t.MediaTypeId, t.GenreId, " +
                     "t.Composer, t.Milliseconds, t.Bytes, t.UnitPrice, a.Name AS ArtistName " +
                     "FROM Tracks t " +
                     "INNER JOIN Artists a ON t.ArtistId = a.ArtistId";
        
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                TrackQuery trackQuery = new TrackQuery(
                rs.getInt("TrackId"),
                    rs.getString("Name"),
                    (Integer) rs.getObject("AlbumId"), // Kezeli a NULL értéket
                    (Integer) rs.getObject("MediaTypeId"),
                    (Integer) rs.getObject("GenreId"),
                    rs.getString("Composer"),
                    rs.getInt("Milliseconds"),
                    (Integer) rs.getObject("Bytes"),
                    rs.getDouble("UnitPrice"),
                    rs.getString("ArtistName")
                );
                result.add(trackQuery);
            }
        } catch (SQLException e) {
            System.out.println("[SQL hiba]: " + e.getMessage());
        }
        return result;
    }
    public Track getLongest() {
        Track longestTrack = null;
        String sql = "SELECT * FROM Tracks ORDER BY Milliseconds DESC LIMIT 1";
        
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if(rs.next()) {
                longestTrack = new Track(
                    rs.getInt("TrackId"),
                    rs.getString("Name"),
                    (Integer) rs.getObject("AlbumId"),
                    (Integer) rs.getObject("MediaTypeId"),
                    (Integer) rs.getObject("GenreId"),
                    rs.getString("Composer"),
                    rs.getInt("Milliseconds"),
                    (Integer) rs.getObject("Bytes"),
                    rs.getDouble("UnitPrice"),
                    rs.getInt("ArtistId")
                );
            }
        } catch (SQLException e) {
            System.out.println("[SQL hiba]: " + e.getMessage());
        }
        return longestTrack;
    }
    
    public int getRocks() {
        int count = 0;
        String sql = "SELECT COUNT(*) AS RockTrackCount FROM Tracks WHERE Name LIKE '%rock%'";
        
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()){
                count = rs.getInt("RockTrackCount");
            }
        } catch (SQLException e) {
            System.out.println("[SQL hiba]: " + e.getMessage());
        }
        return count;
    }
    
    public boolean addTrack(Track track) {
        String sql = "INSERT INTO Tracks(Name, AlbumId, MediaTypeId, GenreId, Composer, " +
                     "Milliseconds, Bytes, UnitPrice, ArtistId) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, track.getName());
            if (track.getAlbumId() != null) pstmt.setInt(2, track.getAlbumId());
            else pstmt.setNull(2, Types.INTEGER);

            if (track.getMediaTypeId() != null) pstmt.setInt(3, track.getMediaTypeId());
            else pstmt.setNull(3, Types.INTEGER);

            if (track.getGenreId() != null) pstmt.setInt(4, track.getGenreId());
            else pstmt.setNull(4, Types.INTEGER);

            pstmt.setString(5, track.getComposer());
            pstmt.setInt(6, track.getMilliseconds());

            if (track.getBytes() != null) pstmt.setInt(7, track.getBytes());
            else pstmt.setNull(7, Types.INTEGER);

            pstmt.setDouble(8, track.getUnitPrice());
            pstmt.setInt(9, track.getArtistId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("[SQL hiba]: " + e.getMessage());
            return false;
        }
    }
    public boolean updateTrackPrice(int trackId, double newUnitPrice) {
        String sql = "UPDATE Tracks SET UnitPrice = ? WHERE TrackId = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newUnitPrice);
            pstmt.setInt(2, trackId);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Error in updateTrackPrice(): " + e.getMessage());
            return false;
        }
    }
}
