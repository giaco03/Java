package com.volpini;

public class Partita {

    private final int n = 10;
    Personaggio[] pg ;

    public Partita() {
        pg = new Personaggio[n];
        turno();
    }

    public void turno(){
        /*Il codice è molto piu facile da capire se al post di pg[i] e pg[j]
        * Si intendono come p1 e p2 rispettivamente
        */


        Personaggio[] pg = new Personaggio[n];

        Personaggio p1 = new Personaggio(4,5,"Brodo");
        Personaggio p2 = new Personaggio(4,8,"Bulbo");
        Personaggio p3 = new Personaggio(10,10,"Fandalf");
        Personaggio p4 = new Personaggio(7,9,"Rollum");
        Personaggio p5 = new Personaggio(8,8,"Legoland");
        Personaggio p6 = new Personaggio(8,10,"Faruman");
        Personaggio p7 = new Personaggio(9,10,"Mauron");
        Personaggio p8 = new Personaggio(7,10,"Garbalbero");
        Personaggio p9 = new Personaggio(5,6,"Gerry");
        Personaggio p10 = new Personaggio(5,5,"Tipino");
        pg= new Personaggio[]{p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
        Giocatore a = new Giocatore(0,"Giocatore 1",p1);
        Giocatore b = new Giocatore(0,"Giocatore 2",p2);
        int i = 0,j=1,app = 0,turno=0;
        while(i < n){
            System.out.println("Giocatore");
            int g = ConsoleInput.readInt("Giocatore"+((turno==0) ? "1":"2") +"\nQuale personaggio scegli fra questi 2?(Rispondere con 1 o 2"+p1.toString()+p2.toString());
            if(g == 1){
                a.setP(pg[i]);
                b.setP(pg[j]);
            }
            else {
                a.setP(pg[j]);
                b.setP(pg[i]);
                app = 1;
            }

            System.out.println("Il vincitore è"+ pg[i].sfida(pg[j]));
            if(pg[i].sfida(pg[j]).equals(pg[i].getNome())){
                if(app== 1){
                    b.setPunteggio(pg[i].diffPunteggio(pg[j]));
                }
                else {
                    a.setPunteggio(pg[i].diffPunteggio(pg[j]));
                }
            }
            else{
                if(app== 1){
                    b.setPunteggio(pg[j].diffPunteggio(pg[i]));
                }
                else {
                    a.setPunteggio(pg[j].diffPunteggio(pg[i]));
                }
            }

            if(turno == 0){
                turno=1;
            }
            else turno =0;
            j+=2;
            i+=2;
        }
        if(a.getPunteggio() > b.getPunteggio()){
            System.out.println("Il vincitore è il giocatore 1 con"+a.getPunteggio());
        }
        else{
            System.out.println("Il vincitore è il giocatore 2 con"+b.getPunteggio());
        }
    }
}
