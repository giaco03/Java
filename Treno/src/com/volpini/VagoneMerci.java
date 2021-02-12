package com.volpini;

public class VagoneMerci extends Vagone{
    private String volume;
    private double pMax;
    private double pEff;

    public VagoneMerci(String codice, double pesoV, String aziendaC, String annoC, String volume, double pMax, double pEff) {
        super(codice, pesoV, aziendaC, annoC);
        this.volume = volume;
        this.pMax = pMax;
        this.pEff = pEff;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public double getpMax() {
        return pMax;
    }

    public void setpMax(double pMax) {
        this.pMax = pMax;
    }

    public double getpEff() {
        return pEff;
    }

    public void setpEff(double pEff) {
        this.pEff = pEff;
    }
    @Override
    public double getPesoToT(){
        return super.getPesoToT() + getpEff();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nvolume=" + volume +
                "\npMax=" + pMax +
                "\npEff=" + pEff +
                "\nPesoTot=" + getPesoToT() +
                "\n}";
    }
}
