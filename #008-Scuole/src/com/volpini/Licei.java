package com.volpini;

public class Licei extends Scuola{
    private static double cStudenti = 150;
    private static double cLaboratori = 1100;

    public Licei(String codice, String denominazione,
                 String indirizzo, String città, int nStudenti, int nClassi,int nSedi,int nLaboratori) {
        super(codice,denominazione,indirizzo,città,nStudenti,nClassi,nSedi,nLaboratori);
    }

    public double getcStudenti() {
        return cStudenti;
    }

    public void setcStudenti(double cStudenti) {
        this.cStudenti = cStudenti;
    }



    public  double getcLaboratori() {
        return cLaboratori;
    }

    public void setcLaboratori(double cLaboratori) {
        Licei.cLaboratori = cLaboratori;
    }


    public double contributi() {
        return (nStudenti*cStudenti)+(cLaboratori*nLaboratori);
    }

    @Override
    public String toString() {
        return "\nIstituti liceali " +
                "\nContributi per Studente -> "+cStudenti
                +"\nContributi per Laboratori -> "+cLaboratori
                + super.toString()+"\nContributi totali -> "
                +contributi();
    }

}
