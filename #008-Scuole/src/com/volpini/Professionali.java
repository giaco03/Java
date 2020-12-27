package com.volpini;

public class Professionali extends Scuola{
    private static double cLaboratori = 6000;
    private static double cClassi = 3500;
    private double cRegionali;

    public Professionali(String codice, String denominazione,
                   String indirizzo, String città, int nStudenti, int nClassi, int nSedi, int nLaboratori) {
        super(codice,denominazione,indirizzo,città,nStudenti,nClassi,nSedi,nLaboratori);
        this.cRegionali = 0;
    }

    public double getCLaboratori(){
        return cLaboratori;
    }

    public void setcLaboratori(double cLaboratori) {
        Professionali.cLaboratori = cLaboratori;
    }

    public  double getcClassi() {
        return cClassi;
    }

    public void setcClassi(double cClassi) {
        Professionali.cClassi = cClassi;
    }

    public double getcRegionali() {
        return cRegionali;
    }

    public void setcRegionali(double cRegionali) {
        this.cRegionali = cRegionali;
    }

    public double contributi() {
        return (cClassi*nClassi)+(cLaboratori*nLaboratori)+cRegionali;
    }

    @Override
    public String toString() {
        return "\nIstituto Professionali " +
                "\nContributi per Classe -> " + cClassi
                +"\nContributi per Laboratori -> " + cLaboratori
                +"\nContributi regionali -> " + cRegionali
                + super.toString() + "\nContributi totali -> "
                + contributi();
    }
}
