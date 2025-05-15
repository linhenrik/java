/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.artist;

/**
 *
 * @author linhenrik
 */
public class TrackQuery {
    private int trackId;
    private String name; // Zene címe
    private Integer albumId;
    private Integer mediaTypeId;
    private Integer genreId;
    private String composer;
    private int milliseconds;
    private Integer bytes;
    private double unitPrice;
    private String artistName; // Előadó neve

    public TrackQuery(int trackId, String name, Integer albumId, Integer mediaTypeId, Integer genreId, String composer, int milliseconds, Integer bytes, double unitPrice, String artistName) {
        this.trackId = trackId;
        this.name = name;
        this.albumId = albumId;
        this.mediaTypeId = mediaTypeId;
        this.genreId = genreId;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
        this.artistName = artistName;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getName() {
        return name;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public Integer getMediaTypeId() {
        return mediaTypeId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public String getComposer() {
        return composer;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public Integer getBytes() {
        return bytes;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public void setMediaTypeId(Integer mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "TrackQuery{" + "trackId=" + trackId + ", name=" + name + ", albumId=" + albumId + ", mediaTypeId=" + mediaTypeId + ", genreId=" + genreId + ", composer=" + composer + ", milliseconds=" + milliseconds + ", bytes=" + bytes + ", unitPrice=" + unitPrice + ", artistName=" + artistName + '}';
    }
    
}
