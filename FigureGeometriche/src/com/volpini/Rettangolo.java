package com.volpini;

public class Rettangolo extends FiguraPiana{
    private double base;
    private double altezza;

    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
        this.nLati = 4;
        this.nVertici = 4;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
    @Override
    public double area(){
        return base * altezza;
    }

    @Override
    public double perimetro() {
        return (base + altezza) * 2;
    }

    @Override
    public String toString() {
        return "Rettangolo{" +
                "base=" + base +
                ", altezza=" + altezza +
                ", nLati=" + nLati +
                ", nVertici=" + nVertici +
                '}';
    }
}
