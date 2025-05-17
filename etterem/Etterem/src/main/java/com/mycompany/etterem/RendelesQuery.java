/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.etterem;

import java.time.LocalDateTime;

/**
 *
 * @author linhenrik
 */
public class RendelesQuery {
    private int id;
    private LocalDateTime datum;
    private String ugyfel_nev;
    public String etel;
    public int mennyiseg;

    public RendelesQuery(int id, LocalDateTime datum, String ugyfel_nev, String etel, int mennyiseg) {
        this.id = id;
        this.datum = datum;
        this.ugyfel_nev = ugyfel_nev;
        this.etel = etel;
        this.mennyiseg = mennyiseg;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public String getUgyfel_nev() {
        return ugyfel_nev;
    }

    public String getEtel() {
        return etel;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public void setUgyfel_nev(String ugyfel_nev) {
        this.ugyfel_nev = ugyfel_nev;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    @Override
    public String toString() {
        return "RendelesQuery{" + "id=" + id + ", datum=" + datum + ", ugyfel_nev=" + ugyfel_nev + ", etel=" + etel + ", mennyiseg=" + mennyiseg + '}';
    }
    
}
