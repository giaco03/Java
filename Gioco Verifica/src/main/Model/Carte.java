package main.Model;

import main.Img.Card;

import java.util.ArrayList;

public class Carte {
    public ArrayList<Card> carte;

    public Carte() {
        carte = new ArrayList<>();
        carte.add(new Card(new Personaggio("Brodo", 4, 5)));
        carte.add(new Card(new Personaggio("Bulbo", 4, 8)));
        carte.add(new Card(new Personaggio("Fandalf", 10, 10)));
        carte.add(new Card(new Personaggio("Rollum", 7, 8)));
        carte.add(new Card(new Personaggio("Legoland", 8, 8)));
        carte.add(new Card(new Personaggio("Faruman", 8, 10)));
        carte.add(new Card(new Personaggio("Mauron", 9, 10)));
        carte.add(new Card(new Personaggio("Garbalbero", 7, 10)));
        carte.add(new Card(new Personaggio("Aragone", 9, 6)));
        carte.add(new Card(new Personaggio("Gimilli", 5, 5)));
    }
    public Card pop(int index){
        Card c = carte.get(index);
        carte.remove(index);
        return c;
    }
    public int length(){
        return carte.size();
    }

}
