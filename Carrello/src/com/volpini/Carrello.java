package com.volpini;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private static int MAX_OGGETTI = 15;
    private List<Merce> contenutoCarrello;

    public Carrello() {
        contenutoCarrello = new ArrayList<>(MAX_OGGETTI);
    }

    public void inserisciProdotto(Merce prodotto) {
        contenutoCarrello.add(prodotto);
    }

    public boolean eliminaProdotto(int n) {
        n -= 1;
        if (n >= 0 && n < MAX_OGGETTI && n <= contenutoCarrello.size()) {
            contenutoCarrello.remove(n);
            return true;
        }
        return false;
    }

    public boolean eliminaProdotto(String s) {
        for (Merce element : contenutoCarrello) {
            if (element.getCodice().equals(s)) {
                contenutoCarrello.remove(element);
                System.out.println("Il prodotto è stato rimosso");
                return true;
            }
        }
        return false;
    }


    public static int getMaxOggetti() {
        return MAX_OGGETTI;
    }

    public static void setMaxOggetti(int maxOggetti) {
        MAX_OGGETTI = maxOggetti;
    }

    public double calcolaPrezzoTotale() {
        double conta = 0;
        for (Merce element : contenutoCarrello) {
            conta += element.calcolaImporto();
        }
        return conta;
    }

    public double calcolaCalorieTotali() {
        double conta = 0;
        for (Merce element : contenutoCarrello) {
            if (element instanceof Alimentari) {
                conta += ((Alimentari) element).calcolaCalorie();
            }
        }
        return conta;
    }


    public void Stampa() {
        int i = 0;
        for (Merce element : contenutoCarrello) {
            i++;
            if (element != null) {
                System.out.println("\n" + i + ")" + element.toString() + "\n");
            }
        }
    }

}
