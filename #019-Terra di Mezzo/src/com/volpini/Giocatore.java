package com.volpini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Giocatore implements Serializable {
    private ArrayList<Warrior> characters;
    private int gold;
    private String faction;

    public Giocatore(ArrayList<Warrior> characters, int gold, String faction) {
        this.characters = characters;
        this.gold = gold;
        this.faction = faction;
    }

    public ArrayList<Warrior> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Warrior> characters) {
        this.characters = characters;
    }
    public void addWarrior(Warrior w){
        characters.add(w);
    }
    public void removeWarrior(int n) {
        n -= 1;
        if (n >= 0 && n <= characters.size()) {
            characters.remove(n);
        }
    }
    public Warrior getWarrior(int index){
        if (index >= 0 && index <= characters.size()) {
            try {
               return characters.get(index);
            }
            catch (NullPointerException e){
                System.out.println("Personaggio non trovato o non esistente !");
                return null;
            }
        }
        else return null;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }
    public String stampaGiocatori(){

            StringBuilder app = new StringBuilder();
            int i = 0;
            for (Warrior w : characters) {
                i++;
                app.append(i).append(")");
                if (w instanceof Character) {
                    app.append(w.getFaction());
                }
                if (w instanceof Hero) {
                    app.append("Eroe");
                }
                if (app.length() > 50) {
                    app.append("\n");
                }

            }
            return app.toString();

    }
}
