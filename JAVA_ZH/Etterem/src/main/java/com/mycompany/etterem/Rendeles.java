/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.etterem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author szoky
 */

public class Rendeles {
    private int id;
    private LocalDateTime datum;
    private String ugyfelNev;
    private int etelId;
    private int mennyiseg;

    // Paraméter nélküli konstruktor
    public Rendeles() {
    }

    // Paraméteres konstruktor
    public Rendeles(int id, LocalDateTime datum, String ugyfelNev, int etelId, int mennyiseg) {
        this.id = id;
        this.datum = datum;
        this.ugyfelNev = ugyfelNev;
        this.etelId = etelId;
        this.mennyiseg = mennyiseg;
    }

    // Getterek és setterek
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getUgyfelNev() {
        return ugyfelNev;
    }

    public void setUgyfelNev(String ugyfelNev) {
        this.ugyfelNev = ugyfelNev;
    }

    public int getEtelId() {
        return etelId;
    }

    public void setEtelId(int etelId) {
        this.etelId = etelId;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    // toString() metódus
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Rendeles{" +
                "id=" + id +
                ", datum=" + datum.format(formatter) +
                ", ugyfelNev='" + ugyfelNev + '\'' +
                ", etelId=" + etelId +
                ", mennyiseg=" + mennyiseg +
                '}';
    }
}



