package com.volpini;

public class Menu {
    public Scaffale scaffale = new Scaffale();
    public Menu(){
        Program();
    }
    public void Program(){
        int scelta,r,p;
        System.out.println("Scaffale\n");
        scelta = ConsoleInput.readInt("1)Aggiungi Libro.\n2)Rimuovi Libro.\n 3)Stampa tutti i libri.");
        switch (scelta){
            case 1:
                Libro l = new Libro(ConsoleInput.readline("Inserisci il titolo:"),ConsoleInput.readline("Inserisci l'autore:"),ConsoleInput.readInt("Inserisci il numero di pagine"));
                r = ConsoleInput.readInt("In quale ripiano vuoi inserirlo?");
                p = ConsoleInput.readInt("Inserisci la posizione nel ripiano");
                scaffale.setLibro(l,r,p);
                break;
            case 2:
                r = ConsoleInput.readInt("In quale ripiano vuoi inserirlo?");
                p = ConsoleInput.readInt("Inserisci la posizione nel ripiano");
                scaffale.rimuoviLibro(r,p);
                break;
            case 3:
                for(int i = 0; i < 5){
                    scaffale.toString();
                }
                break;

        }


    }





}
