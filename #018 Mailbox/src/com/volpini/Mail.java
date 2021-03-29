package com.volpini;

import java.io.Serializable;

import java.time.LocalTime;
import java.util.Date;

public class Mail implements Serializable {
    private String mittente;
    private String oggetto;
    private String testo;
    private Date orario;

    public Mail(String mittente, String oggetto, String testo) {
        this.mittente = mittente;
        this.oggetto = oggetto;
        this.testo = testo;
        orario = new java.util.Date();
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getOggetto() {
        return oggetto;
    }

    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Date getOrario() {
        return orario;
    }

    public void setOrario(Date orario) {
        this.orario = orario;
    }

    @Override
    public String toString() {
        return mittente+" -> " + oggetto;
    }
    public String mail(){
        return "\nMail{" +
                "\nmittente='" + mittente + '\'' +
                "\noggetto='" + oggetto + '\'' +
                "\ntesto='" + testo + '\'' +
                "\ndata=" + orario +
                "\n}";
    }
}
