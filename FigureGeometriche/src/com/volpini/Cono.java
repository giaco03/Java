package com.volpini;

public class Cono extends FiguraSolida {
    private double altezza;
    private double raggio;
    private double l;

    public Cono(double altezza, double raggio, double l) {
        this.altezza = altezza;
        this.raggio = raggio;
        this.l = l;
        this.nFacce = 2;
        this.nVertici = 1;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }
    public double area(){
        return Math.PI*raggio*l+Math.pow(raggio,2)*Math.PI;
    }
    public double volume(){
        return (Math.PI * Math.pow(raggio,2)*altezza)/3;
    }
    @Override
    public String toString() {
        return "Cono{" +
                "altezza=" + altezza +
                ", raggio=" + raggio +
                ", l=" + l +
                ", nFacce=" + nFacce +
                ", nVertici=" + nVertici +
                '}';
    }
}
