package com.volpini;

public class Tecnici extends Scuola{

    private static double cLaboratori = 6000;
    private static double cClassi = 3500;
    private static double cIndirizzi = 0;
    private int nIndirizzi;

    public Tecnici(String codice, String denominazione,
                 String indirizzo, String città, int nStudenti, int nClassi, int nSedi, int nLaboratori,int nIndirizzi) {
        super(codice,denominazione,indirizzo,città,nStudenti,nClassi,nSedi,nLaboratori);
        this.nIndirizzi = nIndirizzi;
    }

    public double getcClassi() {
        return cClassi;
    }

    public void setcClassi(double cClassi) {
        Tecnici.cClassi = cClassi;
    }

    public int getnIndirizzi() {
        return nIndirizzi;
    }

    public void setnIndirizzi(int nIndirizzi) {
        this.nIndirizzi = nIndirizzi;
    }

    public double getcLaboratori() {
        return cLaboratori;
    }

    public void setcLaboratori(double cLaboratori) {
         Tecnici.cLaboratori = cLaboratori;
    }

    public  double getcIndirizzi() {
        return cIndirizzi;
    }

    public void setcIndirizzi(double cIndirizzi) {
        Tecnici.cIndirizzi = cIndirizzi;
    }


    public double contributi() {
        return (cClassi*nClassi)+(cLaboratori*nLaboratori)+(cIndirizzi*nIndirizzi);
    }

    @Override
    public String toString() {
        return "\nIstituto Tecnici " +
                "\nContributi per Classe -> " + cClassi
                +"\nContributi per Laboratori -> " + cLaboratori
                +"\nContributi per indirizzo -> " + cIndirizzi
                + super.toString()+"\nContributi totali -> "
                +contributi();
    }
}
