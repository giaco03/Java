package com.volpini;

public class Menu {


    public Menu() {
        program();
    }

    public void program() {
        Aerodromo sasso = new Aerodromo();
        sasso = (Aerodromo) sasso.loading();

        int scelta = 1;
        while (scelta != 0) {
            scelta = ConsoleInput.readInt("\n1)Aggiungi un'aeromobile\n" +
                    "2)Elimina un aeromobile\n3)Visualizza Aerodromo\n4)Confronta due aeromobili\n0)Esci e salva\nInserire la scelta -> ");
            switch (scelta) {
                case 1:
                    sasso.aggiungi(selezione());
                    break;
                case 2:
                    switch (ConsoleInput.readInt("1)Eliminare tramite indice\n2)Tramite ricerca\nInserire la scelta -> ")) {

                        case 1:
                            sasso.Stampa();
                            if (sasso.elimina(ConsoleInput.readInt("Inserisci la posizione dell'elemento da rimuovere -> "))) {
                                System.out.println("L'elemento è stato rimosso\n");
                            } else {
                                System.out.println("L'elemento non è stato trovato.\n");
                            }
                            break;
                        case 2:
                            sasso.Stampa();
                            if (sasso.elimina(ConsoleInput.readline("Inserisci la sigla dell'aeromobile -> "))) {
                                System.out.println("L'elemento è stato rimosso\n");
                            } else {
                                System.out.println("L'elemento non è stato trovato.\n");
                            }
                            break;
                    }
                case 3:
                    sasso.Stampa();
                    break;
                case 4:
                    sasso.Stampa();
                    sasso.compare(ConsoleInput.readline("Inserisci la sigla della 1° Aeromobile da confrontare -> "),ConsoleInput.readline("Inserisci la sigla della 2° Aeromobile da confrontare -> "));
                    break;
                case 0:
                    sasso.save();
                    break;
                default:
                    break;
            }
        }

    }

    //In base alla stringa inserita dall'utente alloca un diverso tipo di oggetto
    public static Aeromobile selezione() {
        String[] array = new String[]{"AeroMotore,Aliante"};
        while (true) {
            String s = ConsoleInput.readline("Inserisci il tipo di Aeromobile -> ");
            switch (s) {
                case "AeroMotore":
                    AereoMotore a = new AereoMotore(ConsoleInput.readline("Inserisci la sigla -> "),ConsoleInput.readDouble("Inserisci la potenza CV -> "));
                    return a;
                case "Aliante":
                    Alianti b = new Alianti(ConsoleInput.readline("Inserisci la sigla -> "),ConsoleInput.readInt("Inserisci l'efficienza -> "));
                    return b;
                default:
                    System.out.println("I tipi sono:" + array[0] + "\n Reinserisci.\n");
                    break;
            }
        }
    }
}
