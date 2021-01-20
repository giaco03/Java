package com.volpini;

public class Freschi extends Alimentari {
    private static double costoSacchetto = 0.05;
    private boolean confezionato;

    public Freschi(String codice, double prezzoUnitario, String descrizione, double peso, double calorieUnitarie, boolean confezionato) {
        super(codice, prezzoUnitario, descrizione, peso, calorieUnitarie);
        this.confezionato = confezionato;
    }

    public double getCostoSacchetto() {
        return costoSacchetto;
    }

    public void setCostoSacchetto(double costoSacchetto) {
        Freschi.costoSacchetto = costoSacchetto;
    }

    public boolean getConfezionato() {
        return confezionato;
    }

    public void setConfezionato(boolean confezionato) {
        this.confezionato = confezionato;
    }

    public double calcolaImporto() {
        return getPrezzoUnitario() + costoSacchetto;
    }


    @Override
    public String toString() {
        return "Freschi{\n" + super.toString() +
                "\ncostoSacchetto=" + costoSacchetto +
                "\nconfezionato=" + confezionato +
                "\n}";
    }
}
