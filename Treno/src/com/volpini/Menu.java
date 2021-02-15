package com.volpini;

import java.io.File;
import java.io.FileNotFoundException;

public class Menu {
    private static final File dataFile = new File("./treno.bin");
    private static final FileInterface fileInterface = new FileBinario();


    public Menu() {
        program();
    }

    public void program() {
        Treno train = loading();
        int scelta = 1;
        while (scelta != 0) {
            scelta = ConsoleInput.readInt("1)Aggiugini un vagone al treno\n" +
                    "2)Elimina un vagone\n3)Visualizza treno\n4)Calcola peso totale treno\n0)Esci\nInserire la scelta -> ");
            switch (scelta) {
                case 1:
                    train.aggiungiVagone(selezione(ConsoleInput.readline("Inserisci il tipo di vagone -> ")));
                    break;
                case 2:
                    switch (ConsoleInput.readInt("1)Eliminare tramite indice\n2)Tramite ricerca\nInserire la scelta -> ")) {

                        case 1:
                            train.Stampa();
                            if (train.eliminaVagone(ConsoleInput.readInt("Inserisci la posizione del vagone da rimuovere -> "))) {
                                System.out.println("L'elemento è stato rimosso\n");
                            } else {
                                System.out.println("L'elemento non è stato trovato.\n");
                            }
                            break;
                        case 2:
                            train.Stampa();
                            if (train.eliminaVagone(ConsoleInput.readline("Inserisci il codice del vagone da rimuovere -> "))) {
                                System.out.println("L'elemento è stato rimosso\n");
                            } else {
                                System.out.println("L'elemento non è stato trovato.\n");
                            }
                            break;
                    }

                case 3:
                    train.Stampa();
                    break;
                case 4:
                    System.out.println(train.pesoTreno()+"\n");
                    break;
                case 0:
                    scelta = 0;
                    saving(train);
                    break;
                default:
                    break;
            }
        }

    }

    //In base alla stringa inserita dall'utente alloca un diverso tipo di oggetto
    public static Vagone selezione(String s) {
        String[] array = new String[]{"Merci,Passeggeri"};
        while (true) {
            switch (s) {
                case "Merci":
                    return new VagoneMerci(ConsoleInput.readline("Inserisci il codice -> "),ConsoleInput.readDouble("Inserisci il peso vuoto -> "),
                            ConsoleInput.readline("Inserisci il nome della azienda costruttrice -> "),ConsoleInput.readline("Inserisci l'anno di costruzione -> "),
                            ConsoleInput.readline("Inserisci il volume di carico -> "),ConsoleInput.readDouble("Inserisci il peso massimo per il vagone -> "),ConsoleInput.readDouble("Inserisci il peso effettivo -> "));
                case "Passeggeri":
                    return new VagonePasseggero(ConsoleInput.readline("Inserisci il codice -> "),ConsoleInput.readDouble("Inserisci il peso vuoto -> "),
                            ConsoleInput.readline("Inserisci il nome della azienda costruttrice -> "),ConsoleInput.readline("Inserisci l'anno di costruzione -> "),
                            ConsoleInput.readline("Inserisci la classe del vagone -> "),ConsoleInput.readInt("Inserisci il numero di posti liberi -> "),ConsoleInput.readInt("Inserisci i posti occupati -> "));
                default:
                    System.out.println("I tipi sono:" + array[0] + "\n Reinserisci.\n");
                    selezione(s);
                    break;
            }
        }
    }
    public static Treno loading() {
        Treno treno = null;
        try {
            treno = fileInterface.load(dataFile, Treno.class);
        } catch (FileNotFoundException ignored) {
        }
        if (treno == null) {
            treno = new Treno();
        }
        return treno;
    }

    public static void saving(Object o) {
        fileInterface.save(o, dataFile);
        System.out.println("Arrivederci");
    }
}
