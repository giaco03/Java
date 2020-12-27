package com.volpini;

public class Parallelepipedo extends FiguraSolida{
    private double base;
    private double profondita;
    private double altezza;

    public Parallelepipedo(double base, double profondita, double altezza) {
        this.base = base;
        this.profondita = profondita;
        this.altezza = altezza;
        this.nFacce = 6;
        this.nVertici = 8;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getProfondita() {
        return profondita;
    }

    public void setProfondita(double profondita) {
        this.profondita = profondita;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
    public double area(){
       return (perimetroB()*altezza)+(perimetroB()*2);
    }
    public double perimetroB(){
        return 2*(base+profondita);
    }
    public double volume(){
        return perimetroB()*altezza;
    }

    @Override
    public String toString() {
        return "Parallelepipedo{" +
                "base=" + base +
                ", profondita=" + profondita +
                ", altezza=" + altezza +
                ", nFacce=" + nFacce +
                ", nVertici=" + nVertici +
                '}';
    }
}
