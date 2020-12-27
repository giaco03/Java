package com.volpini;

public abstract class FiguraPiana extends FiguraGeometrica{
    protected int nLati;
    public int getNLati(){
        return nLati;
        }
        public abstract double perimetro();

    @Override
    public String toString() {
        return "FiguraPiana{" +
                "nLati=" + nLati +
                ", nVertici=" + nVertici +
                '}';
    }
}
