package com.volpini;

public class Medie extends Scuola{
    private static double cStudenti = 150;
    private static double cSede = 9000;
    private static double cLaboratori = 1100;

    public Medie(String codice, String denominazione,
                      String indirizzo, String città, int nStudenti, int nClassi, int nSedi, int nLaboratori) {
        super(codice,denominazione,indirizzo,città,nStudenti,nClassi,nSedi,nLaboratori);
    }

    public double getcStudenti() {
        return cStudenti;
    }

    public void setcStudenti(double cStudenti) {
        this.cStudenti = cStudenti;
    }

    public double getcSede() {
        return cSede;
    }

    public void setcSede(double cSede) {
        Medie.cSede = cSede;
    }

    public  double getcLaboratori() {
        return cLaboratori;
    }

    public void setcLaboratori(double cLaboratori) {
       Medie.cLaboratori = cLaboratori;
    }


    public double contributi() {
        return (nStudenti*cStudenti)+(cSede*nSedi)+(cLaboratori*nLaboratori);
    }

    @Override
    public String toString() {
        return "\nMedie " +
                "\nContributi per Studente -> "+cStudenti
                +"\nContributi per sedi aggiuntive -> "+cSede
                +"\nContributi per Laboratori -> "+cLaboratori
                + super.toString()+"\nContributi totali -> "
                +contributi();
    }



}
