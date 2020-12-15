package com.volpini;

public class Menu {
    Personaggio[] pg;

    public Menu() {
        stampa();
    }
    public void stampa(){
        int scelta;
        scelta = ConsoleInput.readInt("1)Nuova partita\n2)Fine partita");
        switch(scelta){
            case 1:
                System.out.println("Nuova partita");
                for(int i = 0; i < 10; i++){
                    pg[i].toString();
                }
                new Partita();
                break;
            case 2:
               break;
            default:
                break;
        }
    }
}
