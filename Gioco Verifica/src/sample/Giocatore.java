package sample;

import java.util.Arrays;

public class Giocatore {
    private String nome;
    private int punt; //punteggio
    private Personaggio pg[]; //array di personaggi
    private int nTeam; //il numero di personaggi posseduti in questo momento, aiuta anche nel gioco


    //costruttore
    public Giocatore(String nome, int punt, int nTeam) { //per l'aggiunta dei personaggi  si utilizzerà il setter
        this.nome = nome;
        this.punt = punt;
        this.nTeam = nTeam;
        this.pg = new Personaggio [nTeam];
    }

    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunt() {
        return punt;
    }

    public void setPunt(int punt) {
        this.punt = punt;
    }

    public Personaggio getPg(int n) {
        return this.pg[n];
    }

    public Boolean setPg(Personaggio pg, int n) {
        Boolean ret = true;
        if (n <0 || n >= this.nTeam || this.pg[n]!=null) {
            ret = false;
        }
        else {
            this.pg[n] = pg;
        }
        return ret;
    }

    public int getnTeam() {
        return nTeam;
    }

    public void setnTeam(int nTeam) {
        this.nTeam = nTeam;
    }

    //toString
    public String toString() {
        return "Giocatore [nome=" + nome + ", punti=" + punt + ", pg=" + Arrays.toString(pg) + ", nTeam=" + nTeam + "]";
    }
}
