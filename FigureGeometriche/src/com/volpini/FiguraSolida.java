package com.volpini;

public abstract class FiguraSolida extends FiguraGeometrica{
    protected int nFacce;

    public int getnFacce() {
        return nFacce;
    }
    public abstract double volume();

    @Override
    public String toString() {
        return "FiguraSolida{" +
                "nFacce=" + nFacce +
                ", nVertici=" + nVertici +
                '}';
    }
}
