package com.artist;
public class Artist {
    private int artistId;
    private String name;

    // Paraméteres konstruktor
    public Artist(int artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    // Getterek (lekérdezők)
    public int getArtistId() {
        return artistId;
    }

    public String getName() {
        return name;
    }

    // Setterek (beállítók)
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString() metódus felüldefiniálása
    @Override
    public String toString() {
        return "Artist{" +
               "artistId=" + artistId +
               ", name='" + name + '\'' +
               '}';
    }
}