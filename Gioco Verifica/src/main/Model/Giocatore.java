package main.Model;



import main.Img.Card;

public class Giocatore {
    private String nome;
    private int punt; //punteggio
    private Card active;


    //costruttore
    public Giocatore(String nome, int punt) {
        this.nome = nome;
        this.punt = punt;
    }

    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunt() {
        return punt;
    }

    public void setPunt(int punt) {
        this.punt += punt;
    }

    public Card getActive() {
        return this.active;
    }

    public void setActive(Card c){
        active = c;

    }


}
