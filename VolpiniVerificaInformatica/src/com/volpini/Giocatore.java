package com.volpini;

public class Giocatore {
    private int punteggio;
    private String nome;
    Personaggio p;

    public Giocatore(int punteggio, String nome, Personaggio p) {
        this.punteggio = punteggio;
        this.nome = nome;
        this.p = p;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Personaggio getP() {
        return p;
    }

    public void setP(Personaggio p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "punteggio=" + punteggio +
                ", nome='" + nome + '\'' +
                ", p=" + p +
                '}';
    }
}
