package com.volpini;

public  class Scuola {
    protected String codice;
    protected String denominazione;
    protected String indirizzo;
    protected String città;
    protected int nStudenti;
    protected int nClassi;
    protected int nSedi;
    protected int nLaboratori;

    public Scuola(String codice, String denominazione, String indirizzo, String città, int nStudenti, int nClassi, int nSedi, int nLaboratori) {
        this.codice = codice;
        this.denominazione = denominazione;
        this.indirizzo = indirizzo;
        this.città = città;
        this.nStudenti = nStudenti;
        this.nClassi = nClassi;
        this.nSedi = nSedi;
        this.nLaboratori = nLaboratori;
    }

    public String getCodice() {
        return codice;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public int getnStudenti() {
        return nStudenti;
    }

    public int getnClassi() {
        return nClassi;
    }

    public int getnSedi() {
        return nSedi;
    }

    public int getnLaboratori() {
        return nLaboratori;
    }


    @Override
    public String toString() {
        return "\n{" +
                "codice='" + codice + '\'' +
                "\n denominazione='" + denominazione + '\'' +
                "\n indirizzo='" + indirizzo + '\'' +
                "\n città='" + città + '\'' +
                "\n nStudenti=" + nStudenti +
                "\n nClassi=" + nClassi +
                "\n nSedi=" + nSedi +
                "\n nLaboratori=" + nLaboratori +
                '}';
    }
}
