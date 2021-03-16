package com.volpini;
import java.io.Serializable;

public class VagonePasseggero extends Vagone{
    private String classe;
    private int nPostiL;
    private int nPostiO;
    private static double pMediopass;

    public VagonePasseggero(String codice, double pesoV, String aziendaC, String annoC, String classe, int nPostiL, int nPostiO) {
        super(codice, pesoV, aziendaC, annoC);
        this.classe = classe;
        this.nPostiL = nPostiL;
        this.nPostiO = nPostiO;
        pMediopass=65;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getnPostiL() {
        return nPostiL;
    }

    public void setnPostiL(int nPostiL) {
        this.nPostiL = nPostiL;
    }

    public int getnPostiO() {
        return nPostiO;
    }

    public void setnPostiO(int nPostiO) {
        this.nPostiO = nPostiO;
    }

    public static double getpMediopass() {
        return pMediopass;
    }

    public static void setpMediopass(double pMediopass) {
        VagonePasseggero.pMediopass = pMediopass;
    }
    @Override
    public double getPesoToT(){
        return super.getPesoToT() + (getnPostiO() * getpMediopass());
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nclasse='" + classe + '\'' +
                "\nnPostiL=" + nPostiL +
                "\nnPostiO=" + nPostiO +
                "\nPesoTot=" + getPesoToT() +
                "\n";
    }
}
