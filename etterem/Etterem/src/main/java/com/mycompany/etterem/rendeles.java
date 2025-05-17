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
public class rendeles {
    private int id;
    private LocalDateTime datum;
    private String ugyfel_nev;
    private int etel_id;
    private int mennyiseg;

    public rendeles(int id, LocalDateTime datum, String ugyfel_nev, int etel_id, int mennyiseg) {
        this.id = id;
        this.datum = datum;
        this.ugyfel_nev = ugyfel_nev;
        this.etel_id = etel_id;
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

    public int getEtel_id() {
        return etel_id;
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

    public void setEtel_id(int etel_id) {
        this.etel_id = etel_id;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    @Override
    public String toString() {
        return "rendeles{" + "id=" + id + ", datum=" + datum + ", ugyfel_nev=" + ugyfel_nev + ", etel_id=" + etel_id + ", mennyiseg=" + mennyiseg + '}';
    }
    
}
