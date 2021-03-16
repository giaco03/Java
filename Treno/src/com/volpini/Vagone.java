package com.volpini;

import java.io.Serializable;

public class Vagone implements Serializable {
    private String codice;
    private double pesoV;
    private String aziendaC;
    private String annoC;

    public Vagone(String codice, double pesoV, String aziendaC, String annoC) {
        this.codice = codice;
        this.pesoV = pesoV;
        this.aziendaC = aziendaC;
        this.annoC = annoC;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public double getPesoV() {
        return pesoV;
    }

    public void setPesoV(double pesoV) {
        this.pesoV = pesoV;
    }

    public String getAziendaC() {
        return aziendaC;
    }

    public void setAziendaC(String aziendaC) {
        this.aziendaC = aziendaC;
    }

    public String getAnnoC() {
        return annoC;
    }

    public void setAnnoC(String annoC) {
        this.annoC = annoC;
    }
    public double getPesoToT(){
        return getPesoV();
    }

    @Override
    public String toString() {
        return " {" +
                "\ncodice='" + codice + '\'' +
                "\npesoV=" + pesoV +
                "\naziendaC='" + aziendaC + '\'' +
                "\nannoC='" + annoC + '\'';
    }
}
