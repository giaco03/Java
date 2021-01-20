package com.volpini;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Carrello shop = new Carrello();
        Freschi fc = new Freschi("Hel", 4, "Prodotto fresco", 4.6, 57, true);
        shop.inserisciProdotto(fc);
        int scelta = 1;
        while (scelta != 0) {
            scelta = ConsoleInput.readInt("1)Aggiugini prodotto al carrello\n" +
                    "2)Togli un prodotto dal carrelo\n3)Visualizza carrello\n0)Esci\nInserire la scelta -> ");
            switch (scelta) {
                case 1:
                    shop.inserisciProdotto(selezione(ConsoleInput.readline("Inserisci il nome del tipo del prodotto  -> ")));
                    break;
                case 2:
                    if (ConsoleInput.readInt("1)Eliminare tramite indice\n2)Tramite ricerca\nInserire la scelta -> ") == 1) {
                        shop.Stampa();
                        if (shop.eliminaProdotto(ConsoleInput.readInt("Inserisci la posizione dell'oggeto da rimuovere -> "))) {
                            System.out.println("L'elemento è stato rimosso\n");
                        } else {
                            System.out.println("L'elemento non è stato trovato.\n");
                        }
                    } else {
                        shop.Stampa();
                        shop.eliminaProdotto(ConsoleInput.readline("Inserisci il codice del prodotto da eliminare - > "));
                    }
                    break;
                case 3:
                    shop.Stampa();
                    break;
                case 0:
                    scelta = 0;
                    break;
                default:
                    break;
            }
        }

    }

    //In base alla stringa inserita dall'utente alloca un diverso tipo di oggetto
    public static Merce selezione(String s) {
        String[] array = new String[]{"Abbigliamento", "Freschi", "Conservati"};
        while (true) {
            s = ConsoleInput.readline("Inserisci il nome del tipo del prodotto -> ");
            switch (s) {
                case "Abbigliamento":
                    Abbigliamento a = new Abbigliamento(ConsoleInput.readline("Inserisci il nome -> "), ConsoleInput.readDouble("Inserisci il prezzo Unitario -> "), ConsoleInput.readChar("Inserisci il sesso -> "), ConsoleInput.readline("Inserisci la taglia -> "), ConsoleInput.readline("Di che tipologia è?"));
                    return a;
                case "Freschi":
                    Freschi f = new Freschi(ConsoleInput.readline("Inserisci il codice -> "), ConsoleInput.readDouble("Inserisci il prezzo Unitario -> "), ConsoleInput.readline("Inserisci la descrizione -> "), ConsoleInput.readDouble("Inserisci il peso -> "), ConsoleInput.readDouble("Inserisci le calorie unitarie -> "), ConsoleInput.readline("È confezionato o no?Si/No").equals("Si"));
                    return f;
                case "Conservati":
                    Conservati c = new Conservati(ConsoleInput.readline("Inserisci il codice -> "), ConsoleInput.readDouble("Inserisci il prezzo Unitario -> "), ConsoleInput.readline("Inserisci la descrizione -> "), ConsoleInput.readDouble("Inserisci il peso -> "), ConsoleInput.readDouble("Inserisci le calorie unitarie -> "), ConsoleInput.readline("Inserisci la marca -> "));
                    return c;
                default:
                    System.out.println("I tipi di abbigliamento sono:" + array[0] + array[1] + array[2] + "\n Reinserisci.\n");
                    break;
            }
        }
    }


}
