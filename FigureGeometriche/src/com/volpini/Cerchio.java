package com.volpini;

public class Cerchio extends FiguraPiana {
    private double raggio;

    public Cerchio(double raggio) {
        this.raggio = raggio;
        this.nLati = 0;
        this.nVertici = 0;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }
    @Override
    public double perimetro(){
        return (raggio*2) * Math.PI;
    }
    @Override
    public double area(){
        return Math.pow(raggio,2)*Math.PI;
    }

    @Override
    public String toString() {
        return "Cerchio{" +
                "raggio=" + raggio +
                ", nLati=" + nLati +
                ", nVertici=" + nVertici +
                '}';
    }
}
