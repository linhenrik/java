package com.mycompany.etterem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author linhenrik
 */
public class etel {
    private int id;
    private String nev;
    private int ar;

    public etel(int id, String nev, int ar) {
        this.id = id;
        this.nev = nev;
        this.ar = ar;
    }

    public int getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "etel{" + "id=" + id + ", nev=" + nev + ", ar=" + ar + '}';
    }
    
}
