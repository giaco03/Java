package com.volpini;

import java.util.ArrayList;
import java.util.List;

public class Scaffale {

    private List<Mensola> ripiani;
    private static final int NUM_RIPIANI = 5;

    public Scaffale() {
        ripiani = new ArrayList<>(NUM_RIPIANI);
        for (int i=0; i<NUM_RIPIANI; i++) ripiani.add(new Mensola());
    }

    public int setLibro(Libro libro, int ripiano, int posizione) {
        if (ripiano < 0 || ripiano >= NUM_RIPIANI) return -1;
        return ripiani.get(ripiano).setVolume(libro, posizione);
    }

    public Libro getLibro(int ripiano, int posizione) {
        if (ripiano < 0 || ripiano >= NUM_RIPIANI) return null;
        return ripiani.get(ripiano).getVolume(posizione);
    }

    public int rimuoviLibro(int ripiano, int posizione) {
        if (ripiano < 0 || ripiano >= NUM_RIPIANI) return -1;
        return ripiani.get(ripiano).rimuoviVolume(posizione);
    }

    public static int getNumRipiani() {
        return NUM_RIPIANI;
    }

    public int getNumMaxLibri() {
        return NUM_RIPIANI * Mensola.getNumMaxVolumi();
    }

    public long getNumLibri() {
        return
    }

    public long getNumLibri(int ripiano) {
        return ripiani.get(ripiano).getNumVolumi();
    }

    @Override
    public String toString() {
        return "Scaffale{" +
                "ripiani=" + ripiani +
                '}';
    }
}
