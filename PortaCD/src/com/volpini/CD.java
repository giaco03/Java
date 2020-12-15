package com.volpini;
public class CD {
    private String titolo;
    private String autore;
    private int numeroBrani;
    private double durata;

    public CD(String titolo, String autore, int numeroBrani, double durata) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroBrani = numeroBrani;
        this.durata = durata;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return this.autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getNumeroBrani() {
        return this.numeroBrani;
    }

    public void setNumeroBrani(int numeroBrani) {
        this.numeroBrani = numeroBrani;
    }

    public double getDurata() {
        return this.durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }

    public double compareDurata(CD album) {
        return album.durata - this.durata;
    }

    public String toString() {
        return "CD{titolo='" + this.titolo + "', autore='" + this.autore + "', numeroBrani=" + this.numeroBrani + ", durata=" + this.durata + "}";
    }
}
