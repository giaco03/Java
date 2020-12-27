package com.volpini;

public class Cilindro extends FiguraSolida{
    private double raggio;
    private double altezza;

    public Cilindro(double raggio, double altezza) {
        this.raggio = raggio;
        this.altezza = altezza;
        this.nFacce = 3;
        this.nVertici = 2;
     }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
    public double area(){
        return (Math.PI*2)*raggio*altezza;
    }
    public double volume(){
        return Math.PI*Math.pow(raggio,2)*altezza;
    }

    @Override
    public String toString() {
        return "Cilindro{" +
                "raggio=" + raggio +
                ", altezza=" + altezza +
                ", nFacce=" + nFacce +
                ", nVertici=" + nVertici +
                '}';
    }
}
