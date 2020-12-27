package com.volpini;

public class Trapezio extends FiguraPiana{

    private double baseMaggiore;
    private double baseMinore;
    private double altezza;
    private double l1;
    private double l2;
    private double l3;
    private double l4;

    public Trapezio(double baseMaggiore, double baseMinore, double altezza, double l1, double l2, double l3, double l4) {
        this.baseMaggiore = baseMaggiore;
        this.baseMinore = baseMinore;
        this.altezza = altezza;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
        this.nLati = 4;
        this.nVertici = 4;
    }



    public double getBaseMaggiore() {
        return baseMaggiore;
    }

    public void setBaseMaggiore(double baseMaggiore) {
        this.baseMaggiore = baseMaggiore;
    }

    public double getBaseMinore() {
        return baseMinore;
    }

    public void setBaseMinore(double baseMinore) {
        this.baseMinore = baseMinore;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getL1() {
        return l1;
    }

    public void setL1(double l1) {
        this.l1 = l1;
    }

    public double getL2() {
        return l2;
    }

    public void setL2(double l2) {
        this.l2 = l2;
    }

    public double getL3() {
        return l3;
    }

    public void setL3(double l3) {
        this.l3 = l3;
    }

    public double getL4() {
        return l4;
    }

    public void setL4(double l4) {
        this.l4 = l4;
    }

    @Override
    public double area() {
        return ((baseMaggiore + baseMinore)*altezza)/2;
    }
    public double perimetro() {
        return l1 + l2 + l3 + l4;
    }

    @Override
    public String toString() {
        return "Trapezio{" +
                "baseMaggiore=" + baseMaggiore +
                ", baseMinore=" + baseMinore +
                ", altezza=" + altezza +
                ", l1=" + l1 +
                ", l2=" + l2 +
                ", l3=" + l3 +
                ", l4=" + l4 +
                ", nLati=" + nLati +
                ", nVertici=" + nVertici +
                '}';
    }
}


