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

public class RendelesQuery {
    private int id;
    private LocalDateTime datum;
    private String ugyfelNev;
    private String etelNev;
    private int mennyiseg;

    public RendelesQuery(int id, LocalDateTime datum, String ugyfelNev, String etelNev, int mennyiseg) {
        this.id = id;
        this.datum = datum;
        this.ugyfelNev = ugyfelNev;
        this.etelNev = etelNev;
        this.mennyiseg = mennyiseg;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public String getUgyfelNev() {
        return ugyfelNev;
    }

    public String getEtelNev() {
        return etelNev;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "RendelesQuery{" +
                "id=" + id +
                ", datum=" + datum.format(formatter) +
                ", ugyfelNev='" + ugyfelNev + '\'' +
                ", etelNev='" + etelNev + '\'' +
                ", mennyiseg=" + mennyiseg +
                '}';
    }
}

