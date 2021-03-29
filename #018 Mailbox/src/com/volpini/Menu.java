package com.volpini;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Menu {


    public Menu() {
        program();
    }

    public void program() {
        Mailbox casella = new Mailbox();
        casella = (Mailbox) casella.loading();
        int scelta = 1;
        while (scelta != 0) {
            scelta = ConsoleInput.readInt("""
                    
                    1)Aggiungi una mail alla Mailbox
                    2)Elimina una mail
                    3)Visualizza Mailbox
                    4)Ricerca mail per oggetto
                    0)Esci e salva
                    Inserire la scelta ->\s""");
            switch (scelta) {
                case 1:
                    casella.aggiungi(selezione());
                    break;
                case 2:

                    casella.stampa();
                    if (casella.elimina(ConsoleInput.readInt("Inserisci la posizione del mail da rimuovere -> "))) {
                        System.out.println("L'elemento è stato rimosso\n");
                    } else {
                        System.out.println("L'elemento non è stato trovato.\n");
                    }

                    break;
                case 3:
                    casella.stampa();
                    casella.open(apri());
                    break;
                case 4:
                    List<Mail> lista = casella.ricerca(ConsoleInput.readline("\nInserisci l'oggetto da cercare -> "));
                    System.out.println(lista);
                    int i = apri()-1;
                    if(i <= lista.size()) {
                        System.out.println(lista.get(i).mail());
                    }
                    break;
                case 0:
                    scelta = 0;
                    casella.save();
                    break;
                default:
                    break;
            }
        }

    }

   //crea una mail
    public static Mail selezione() {
        return new Mail(ConsoleInput.readline("Mittente -> "),ConsoleInput.readline("Oggetto dell'email\n -> "),
                ConsoleInput.readline("Testo dell'email -> "));

    }
    public static int apri(){
        System.out.println("\nInserisci < per tornare indietro\n");
        String app = "";
        while (!app.equals("<")){
            app=ConsoleInput.readline("Scelta -> ");
            if(app.equals("<")) break;
            try {
                return Integer.parseInt(app);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        return 0;
    }

}