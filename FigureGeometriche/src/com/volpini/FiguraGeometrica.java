package com.volpini;

public abstract class FiguraGeometrica {
    protected int nVertici;

    public int getnVertici() {
        return nVertici;
    }


    public abstract double area();



    @Override
    public String toString() {
        return "FiguraGeometrica{" +
                "nVertici=" + nVertici +
                '}';
    }
}
//cilindro in figure solide e parallelepipedo cono
//rettangolo trapezio cerchio