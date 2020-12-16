package com.volpini;

public class Menu {
    PortaCD[] cd;
    int n = 10;

    public PortaCD[] collezione;
        public Menu() {
            cd = new PortaCD[n];
            Program();
         }

    public void Program(){
        int app=1,j,k;

        CD c1 = new CD("Toxicity", "System of a Down", 14, 43.58);
        CD c2 = new CD("Kety", "Ketama126", 15, 44.0);
        CD c3 = new CD("Furi","The Toxic Avenger", 22,43);
        CD c4 = new CD("Octavarium","Dream Theater", 8, 75.47);

        collezione = new PortaCD[n];
        PortaCD portaCd1 = new PortaCD(15);
        PortaCD portaCd2 = new PortaCD(12);

        portaCd1.setCd(0,c1);
        portaCd1.setCd(2,c3);
        portaCd2.setCd(0,c4);
        portaCd2.setCd(4,c2);
        collezione[0] = portaCd1;
        collezione[1] = portaCd2;
        while(app != 0) {
            app = ConsoleInput.readInt("1)setCD.\n2)killCD.\n3)getN.\n4)Cerca un CD per titolo.\n5)Confronta la collezione di due portaCD.\n6)Stampa tutti i PortaCD.\n0)Exit");

            switch (app) {
                case 1:
                    j = ConsoleInput.readInt("In quale porta CD vuoi accedere?");
                    CD cn = new CD(ConsoleInput.readline("Inserisci il titolo:"), ConsoleInput.readline("Inserisci l'autore:"), ConsoleInput.readInt("Inserisci il numero di brani:"), ConsoleInput.readDouble("Inserisci la durata del CD:"));
                    collezione[j].setCd(ConsoleInput.readInt("Inserisci la posizione nel portaCD:"), cn);
                    break;
                case 2:
                    j = ConsoleInput.readInt("In quale porta CD vuoi accedere?");
                    collezione[j].killCd(ConsoleInput.readInt("Inserisci la posizione nel portaCD:"));
                    break;
                case 3:
                    j = ConsoleInput.readInt("In quale porta CD vuoi accedere?");
                    System.out.println(collezione[j].getN());
                    break;
                case 4:
                    String s;
                    int c = 0;
                    s = ConsoleInput.readline("Inserisci il nome del CD:");
                    for (int i = 0; i < 2; i++) {
                        k = collezione[i].cercaCDPerTitolo(s);
                        if (k != -1) {
                            System.out.println("Il CD è stato trovato nel portaCD " + i + "\n" + collezione[i].getCd(k).toString());
                            c++;
                        }
                    }
                    if (c == 0) {
                        System.out.println("Il CD non è stato trovato");
                    }
                    break;
                case 5:

                    System.out.println("Il numero di CD in comune è " + collezione[0].confrontaCollezione(collezione[1]));
                    break;
                case 6:

                    for (int i = 0; i < collezione.length; i++){
                        if(collezione[i] != null){
                             for(int h = 0; h < collezione[i].getN(); h++){
                                 if(collezione[i].getCd(h) != null) System.out.println(collezione[i].getCd(h).toString());
                             }
                        }
                    }

                default:
                    break;
            }
        }


    }


}
