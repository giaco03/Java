package com.volpini;

public class Menu {
    public Scaffale scaffale = new Scaffale();
    public Menu(){
        Program();
    }
    public void Program(){
        Libro book = new Libro("Cosi parlo Zarathustra","Friederich Nietzche",352);
        scaffale.setLibro(book,1,1);
        int scelta=1,r,p;
        while(scelta != 0) {
        System.out.println("Scaffale\n");
        scelta = ConsoleInput.readInt("1)Aggiungi Libro.\n2)Rimuovi Libro.\n3)Stampa tutti i libri.\n0)Esci");

            switch (scelta) {
                case 1:
                    Libro l = new Libro(ConsoleInput.readline("Inserisci il titolo:"), ConsoleInput.readline("Inserisci l'autore:"), ConsoleInput.readInt("Inserisci il numero di pagine"));
                    r = ConsoleInput.readInt("In quale ripiano vuoi inserirlo?");
                    p = ConsoleInput.readInt("Inserisci la posizione nel ripiano");
                    while(scaffale.getLibro(r,p) != null ){
                        if(p < Mensola.getNumMaxVolumi()){
                            scaffale.setLibro(l, r, p);
                            p++;
                        }
                        if( p == Mensola.getNumMaxVolumi()){
                            r++;
                            p=0;
                        }
                     }
                    scaffale.setLibro(l, r, p);
                    break;
                case 2:
                    r = ConsoleInput.readInt("In quale ripiano si trova?");
                    p = ConsoleInput.readInt("Inserisci la posizione nel ripiano");
                    scaffale.rimuoviLibro(r, p);
                    break;
                case 3:
                    for (int i = 0; i < Scaffale.getNumRipiani(); i++) {
                        if(scaffale.getNumLibri(i) != 0) {
                            for (int j = 0; j < Mensola.getNumMaxVolumi(); j++) {
                                if (scaffale.getLibro(i, j) != null) {
                                    System.out.println(scaffale.getLibro(i, j).toString());
                                }
                            }
                        }
                    }
                    break;
                default:
                    break;

            }
        }

    }





}
