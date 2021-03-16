package com.volpini;

import java.io.Serializable;

public abstract class Aeromobile implements Serializable,Savable, Comparable<Aeromobile> {
    private String sigla;

    public Aeromobile(String sigla) {
        this.sigla = sigla;
    }

    public String getsigla() {
        return sigla;
    }

    public void setsigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return " {" +
                "\nsigla='" + sigla + '\'';
    }


    public abstract int compareTo(Aeromobile o);
}
