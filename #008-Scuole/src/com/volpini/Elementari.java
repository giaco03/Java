package com.volpini;

public class Elementari extends Scuola{
    private static double cStudenti=125;
    private static double cSede=9000;

    public Elementari(String codice, String denominazione,
                      String indirizzo, String città, int nStudenti, int nClassi, int nSedi, int nLaboratori) {
        super(codice,denominazione,indirizzo,città,nStudenti,nClassi,nSedi,nLaboratori);
    }

    public double getcStudenti() {
        return cStudenti;
    }

    public void setcStudenti(double cStudenti) {
        Elementari.cStudenti = cStudenti;
    }

    public double getcSede() {
        return cSede;
    }

    public void setcSede(double cSede) {
        Elementari.cSede = cSede;
    }


    public double contributi() {
        return (nStudenti*cStudenti)+(cSede*nSedi);
    }

    @Override
    public String toString() {
        return "\nElementari " +
              "\nContributi per studente -> "+cStudenti+
                "\nContributi per sedi aggiuntive -> " +cSede
                + super.toString()+"\nContributi totali -> "+
                contributi();
    }
}
