package com.volpini;

public class Abbigliamento extends Merce {
    private static double scontoUomo = 10;
    private static double scontoDonna = 9;
    private char sesso;
    private String taglia;
    private String tipologia;

    public Abbigliamento(String codice, double prezzoUnitario, char sesso, String taglia, String tipologia) {
        super(codice, prezzoUnitario);
        this.sesso = sesso;
        this.taglia = taglia;
        this.tipologia = tipologia;
    }

    public double getScontoUomo() {
        return scontoUomo;
    }

    public void setScontoUomo(double scontoUomo) {
        Abbigliamento.scontoUomo = scontoUomo;
    }

    public double getScontoDonna() {
        return scontoDonna;
    }

    public void setScontoDonna(double scontoDonna) {
        Abbigliamento.scontoDonna = scontoDonna;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public double calcolaImporto() {
        if (sesso == 'U') {
            return getPrezzoUnitario() - scontoUomo;
        } else {
            return getPrezzoUnitario() - scontoDonna;
        }
    }

    @Override
    public String toString() {
        return "Abbigliamento{\n" + super.toString() +
                "\nscontoUomo=" + scontoUomo +
                "\nscontoDonna=" + scontoDonna +
                "\nsesso=" + sesso +
                "\ntaglia='" + taglia + '\'' +
                "\ntipologia='" + tipologia + '\'' +
                "\n}";
    }


}
