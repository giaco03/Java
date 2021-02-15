package com.volpini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Treno implements Serializable {
    private static double MAX_TRENI=100;
    private List<Vagone> treno;


    public Treno() {
        treno = new ArrayList<>();
    }
    public void aggiungiVagone(Vagone v){
       treno.add(v);

    }
    public boolean eliminaVagone(int n) {
        n -= 1;
        if (n >= 0 && n < MAX_TRENI && n <= treno.size()) {
            treno.remove(n);
            return true;
        }
        return false;
    }

    public boolean eliminaVagone(String s) {
        for (Vagone element : treno) {
            if (element.getCodice().equals(s)) {
                treno.remove(element);
                return true;
            }
        }
        return false;
    }

    public static double getMaxTreni() {
        return MAX_TRENI;
    }

    public static void setMaxTreni(double maxTreni) {
        MAX_TRENI = maxTreni;
    }
    public double pesoTreno(){
        double c=0;
        for(Vagone element : treno){
            c+=element.getPesoToT();
        }
        return c;
    }
    public void Stampa() {
        int i = 0;
        for (Vagone element : treno) {
            i++;
            if (element != null) {
                System.out.println("\n" + i + ")" +element.getClass().getSimpleName()
                        + element.toString() + "\n");
            }
        }
    }

}
