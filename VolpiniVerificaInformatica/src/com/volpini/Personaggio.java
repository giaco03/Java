package com.volpini;

public class Personaggio {
   private int forza;
   private int esperienza;
   private String nome;

    public Personaggio(int forza, int esperienza, String nome) {
        this.forza = forza;
        this.esperienza = esperienza;
        this.nome = nome;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public int getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(int esperienza) {
        this.esperienza = esperienza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String sfida(Personaggio p){
        if(this.forza > p.forza){
            return this.nome;
        }
        if(this.forza < p.forza){
            return p.nome;
        }
        if(getEsperienza() > p.esperienza) return p.nome;
        else return nome;

    }
    public int diffPunteggio(Personaggio p){
        if(getForza() > p.forza){
            return getForza()-p.forza;
        }
        else{
            if(getEsperienza() < p.esperienza){
                return p.esperienza-getEsperienza();
            }
        }
        return 0;
    }


    @Override
    public String toString() {
        return "Personaggio{" +
                "forza=" + forza +
                ", esperienza=" + esperienza +
                ", nome='" + nome + '\'' +
                '}';
    }
}
