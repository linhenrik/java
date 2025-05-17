/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.etterem;

/**
 *
 * @author szoky
 */



public class Etel {
    private int id;
    private String nev;
    private int ar;

    // Paraméter nélküli konstruktor
    public Etel() {
    }

    // Paraméteres konstruktor
    public Etel(int id, String nev, int ar) {
        this.id = id;
        this.nev = nev;
        this.ar = ar;
    }

    // Getterek és setterek
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    // toString() metódus
    @Override
    public String toString() {
        return "Etel{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", ar=" + ar +
                '}';
    }
}
