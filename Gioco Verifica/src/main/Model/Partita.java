package main.Model;

import main.Img.Card;

import java.util.Random;

public class Partita {
    private static Carte deck;
    private static Giocatore[] pl;
    private int turn;
    public Partita() {
        pl = new Giocatore[2];
        deck = new Carte();
        turn = 1;

        pl[0] = new Giocatore("Giocatore 1", 0);
        pl[1] = new Giocatore("Giocatore 2", 0);

        setHands();

    }
    public Giocatore getGiocatore(int index){
        return pl[index];
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public static Carte getDeck() {
        return deck;
    }
    public int getRCards(){
        return deck.length();
    }
    //Metodo chek si occupa della logica del programma
    //Fa scontrare i personaggi e ne da di nuovi ai giocatori
    //Prepara già l'output per il Controller
    public String goNextTurn(){
        Personaggio p1pg = pl[0].getActive().getP();
        Personaggio p2pg = pl[1].getActive().getP();
        int result = p1pg .sfida(p2pg );
        pl[0].setPunt(p1pg.sfida(p2pg));
        pl[1].setPunt(p2pg.sfida(p1pg));
        String pareggio = (result == 0 ? "Il risultato dello scontro è un pareggio.\nNessuno perde punti": "");
        String output = "Vince il player "+ (p1pg.sfida(p2pg) > 0 ? "1 e gudagna "+result+" punti."
                : "2 e gudagna "+Math.abs(result)+" punti.");
        turn++;
        if(setHands()){
            return (result == 0 ? pareggio : output);
        }
        else {
            return "";
        }
    }
    public Card getPCard(int index){
        return pl[index].getActive();
    }
    public int calculateWinner(){
        return pl[0].getPunt()-pl[1].getPunt();
    }
    //Da personaggi casuali ad entrambi i giocatori
    //Quando sono finite le carte ritornera false
    //Se non ci sono più carte goNextTurn ritornerà una stringa vuota,
    //Grazie ad essa il controller riesce a capire se la partita è finita
    public boolean setHands(){
        for(int j = 0; j < 2; j++){
            if (deck.length() > 0) {
            int position = ran(deck.length());
            pl[j].setActive(deck.pop(position));
            } else {
                return false;
            }
        }
        return true;
    }

    public static int ran(int max){
        Random r = new Random();
        return r.nextInt(max);
    }
}
