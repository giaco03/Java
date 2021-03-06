package com.volpini;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Crea giocatori matrice ecc. in una unica scelta
//Passando poi i parametri a Partita si ha un ottimizzazione del codice
//In questo modo è 100000 volte più facile creare una nuova partita e caricarla da file
//Si riducono anche le righe di codice e si ottimizza molto.

public class Menu {
    private static final String[] races = new String[]{"Uomini","Elfi","Nani","Hobbit","Ent","Orchi","Urukhai","Sudroni","Troll","Goblin"};
    private static final String[] heroes = new String[]{"Sauron","Gollum","Gandalf","Aragorn"};
    public Menu() {
        initialize();
    }


    public void initialize() {
        int scelta = -1;
        while (scelta != 5) {
            System.out.println("""
                                        
                    ----Gioco della terra di mezzo----
                    |                                |
                    |   1) Regole e informazioni.    |
                    |   2) Inizio nuova Partita.     |
                    |   3) Carica partita da file.   |
                    |   4) Elimina partita           |
                    |   5) Esci.                     |
                    |                                |
                    |--------------------------------|""");
            scelta = ConsoleInput.readInt("\nInserisci la scelta ->  ");
            switch (scelta) {
                case 1 -> {
                    System.out.println("""

                             - Il gioco consiste in vari turni dove il giocatore sceglie dove muovere i propri personaggi appartenenti ad una certa fazione.
                             - Ogni fazione dispone di alcune razze con certi pro e contro.
                             - Le fazioni sono scelte tramite testa o croce oppure randomicamente a scelta dei giocatori.
                             - È anche possibile salvare la partita corrente per riprenderla successivamente.
                             - L'obbiettivo del gioco sta nell'annientare ogni personaggio nemico prima dell'inizio del suo turno.
                             - Il gioco dispone di varie fasi dove è possibile comprare nuovi personaggi o potenziare i propri.
                             - Il primo giocatore a perdere ogni personaggio perde.
                            !! ATTENZIONE --- Il movimento dei personaggi avviene tramite i tasti W-A-S-D --- ATTENZIONE !!
                            """);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ignored) {

                    }
                }
                case 2 -> {
                    //private boolean p1Turn = true;
                    // variabile per chiamare più facilmente un personaggio o un eroe del bene o del male
                    //Chiama un warrior del bene se true ; chiama un warrior del male se false
                    // di conseguenza il p2 sarà !p1 , quindi l'opposto
                    int sGold = 100;
                    int endTurn = 20;
                    Giocatore p1 = new Giocatore(null, sGold, "Bene");
                    Giocatore p2 = new Giocatore(null, sGold, "Male");
                    boolean p1Good = true;
                    int n = 5;
                    int pauseFase = 8;
                    int choice = 0;
                    do {
                        System.out.println("""
                                   
                                | -------------     ------------- |
                                ·                                 ·
                                |     1) Inizia nuova partita.    |
                                ·     2) Scegli fazioni.          ·
                                |     3) Impostazioni.            |
                                ·     4) Esci.                    ·
                                |                                 |
                                · ------------       ------------ ·
                                              
                                """);
                        choice = ConsoleInput.readInt("\nInserisci la scelta ->  ");
                        switch (choice) {
                            case 1 -> {

                                //prima riga con personaggi casuali con un eroe per il p1
                                ArrayList<Warrior> rowp1 = new ArrayList<>(n);
                                ArrayList<Warrior> rowp2 = new ArrayList<>(n);

                                for (int i = 0; i < n; i++) {
                                    if (i != n / 2) {
                                        rowp1.add(new Character(p1Good, ran(10) + 1, races[(p1Good ? ran(5) : ran(5) + 5)]));
                                        rowp2.add(new Character(!p1Good, ran(10) + 1, races[(p1Good ?ran(5) + 5  : ran(5))]));
                                    } else {
                                        rowp1.add(new Hero(p1Good, ran(10) + 1, ran(10) + 1, heroes));
                                        rowp2.add(new Hero(!p1Good, ran(10) + 1, ran(10) + 1, heroes));
                                    }
                                }
                                Matrice matrix = new Matrice(rowp1,rowp2,n);
                                //ultima riga con personaggi casuali con un eroe per il p2
                                p1.setCharacters(rowp1);
                                p2.setCharacters(rowp2);

                                Partita p = new Partita(p1, p2, endTurn, matrix, pauseFase, 1);
                                p.start();
                                String name = "Nuova partita";
                                name = ConsoleInput.readline(name+"\nSalvala come -> ");

                                for(String names : p.list()){
                                    if(name.equals(names)){
                                        char yn = 'p';
                                        yn = ConsoleInput.readChar("Esiste già un file con questo nome.\nVuoi sovrascriverlo?(Y/N) -> ");
                                        if(yn == 'Y') {
                                            p.save(name);
                                        }
                                        else{
                                            p.save("Nuova partita"+ p.list().size());
                                        }
                                        break;
                                    }

                                }
                                p.save(name);
                                scelta = 5;
                                choice = 4;
                            }
                            case 2 -> {
                                int decision = ConsoleInput.readInt("\nScelta fazioni tramite:\n1)Testa o croce.\n2)Random.\nScelta -> ");
                                switch (decision) {
                                    case 1 -> {
                                        String hx;
                                        do {
                                            hx = ConsoleInput.readline("\nGiocatore 1 inserisci 'Testa' o 'Croce' -> ");
                                        } while (!hx.equals("Testa") && !hx.equals("Croce"));
                                        System.out.println("\nFlipping the pancakes :P\n");
                                        int coin = ran(2);
                                        if (coin == 0 && hx.equals("Testa") || coin == 1 && hx.equals("Croce")) {
                                            System.out.println((coin == 0 ? "Testa" : "Croce") + ".\n");
                                            while (true) {
                                                p1.setFaction(ConsoleInput.readline("Giocatore 1 scrivi la tua fazione -> "));
                                                if (p1.getFaction().equals("Bene")) {
                                                    p1Good = true;
                                                    p2.setFaction("Male");
                                                    break;
                                                }
                                                if (p1.getFaction().equals("Male")) {
                                                    p2.setFaction("Bene");
                                                    p1Good = false;
                                                    break;
                                                } else System.out.println("La fazione" + p1.getFaction() + "non esiste.\nInserisci 'Bene' o 'Male' a seconda della tua scelta.\n");
                                            }
                                        } else {
                                            System.out.println((coin == 0 ? "Testa" : "Croce")+ ", Il giocatore 2 sceglierà la fazione.\n");
                                            while (true) {
                                                p2.setFaction(ConsoleInput.readline("Giocatore 2 scrivi la tua fazione -> "));
                                                if (p2.getFaction().equals("Bene")) {
                                                    p1.setFaction("Male");
                                                    p1Good = false;
                                                    break;
                                                }
                                                if (p2.getFaction().equals("Male")) {
                                                    p1.setFaction("Bene");
                                                    p1Good = true;
                                                    break;
                                                } else System.out.println("La fazione " + p2.getFaction() + " non esiste.\nInserisci 'Bene' o 'Male' a seconda della tua scelta.\n");
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        int r = ran(100);
                                        if (r < 50) {
                                            p1.setFaction("Bene");
                                            p1Good = true;
                                            System.out.println("La fazione del giocatore 1 sarà quella del Bene.\nQuella del giocatore 2 sarà invece quella del Male");
                                            p2.setFaction("Male");
                                        } else {
                                            p2.setFaction("Bene");
                                            p1Good = false;
                                            System.out.println("La fazione del giocatore 1 sarà quella del Male.\nQuella del giocatore 2 sarà invece quella del Bene");
                                            p1.setFaction("Male");
                                        }
                                    }
                                }
                            }
                            case 3 -> {
                                System.out.println("Dimensione matrice -> " + n + "\nNumero turni prima della fase di pausa -> " + pauseFase+"\nOro iniziale -> "+p1.getGold()+"\nFine partita al turno -> "+endTurn);
                                int scelt = ConsoleInput.readInt("\n1)Modifica oro di partenza.\n2)Modifica numero turni prima della pausa.\n3)Cambia numero di turni prima della fine.\n4)Cambia dimensione matrice.\n5)Esci.\nScelta -> ");
                                if (scelt == 1) {
                                    sGold = ConsoleInput.readIntP("Oro di partenza = ");
                                    p1.setGold(sGold);
                                    p2.setGold(sGold);
                                } if(scelt == 2) pauseFase = ConsoleInput.readInt("Fase di pausa ogni -> ");
                                if(scelt == 3) endTurn = ConsoleInput.readIntP("Fine partita al turno -> ");
                                if(scelt == 4) n = ConsoleInput.readIntP("Dimensione matrice -> ");
                            }
                            case 4 -> {

                            }
                            default -> System.out.println("Opzione non valida.\n");
                        }

                    } while (choice != 4);
                }
                case 3 -> {
                    Partita p = new Partita(null,null,0,null,0,0);
                    //Sceglie il file da caricare
                    String selected = p.select();
                    //Carica la partita
                    p = (Partita) p.loading(selected);
                    if(p != null) {
                        //Inizia la partita
                        p.start();
                        //Salva la partita sul file da cui è stata caricata oppure ne crea una
                        p.save(selected);
                    }
                    scelta = 4;
                }
                case 4 ->{
                    Partita p = new Partita(null,null,0,null,0,0);
                    String selected = p.select();
                    p.delete(selected);

                }
                case 5 ->{

                }
                default -> System.out.println("Opzione non valida reinserisci.\n");
            }
        }
    }
    public static int ran(int a){
        Random r = new Random();
        return r.nextInt(a);
    }

    public static String[] getRaces() {
        return races;
    }
    public static String[] getHeroes() {
        return heroes;
    }
}

