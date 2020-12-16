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
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getNumeroBrani() {
        return numeroBrani;
    }

    public void setNumeroBrani(int numeroBrani) {
        this.numeroBrani = numeroBrani;
    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }

    public double compareDurata(CD album) {
        return album.durata - this.durata;
    }

    @Override
    public String toString() {
        return "CD{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", numeroBrani=" + numeroBrani +
                ", durata=" + durata +
                '}';
    }
    public boolean uguale(CD c){
        if(c != null && getTitolo().equals(c.titolo) && getAutore().equals(c.autore)){
            return true;
        }
        else return false;

    }
}
