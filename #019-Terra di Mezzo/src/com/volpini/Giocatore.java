package com.volpini;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class Giocatore implements Serializable {
    private ArrayList<Warrior> characters;
    private int gold;
    private String faction;
    private int cooldown;


    public Giocatore(ArrayList<Warrior> characters, int gold, String faction) {
        this.characters = characters;
        this.gold = gold;
        this.faction = faction;
        cooldown = 0;
    }

    public void effect(Hero h,double toMultiply){
        for (Warrior w : characters){
            if ((toMultiply == 0.5) ^ w.getFaction().equals(h.getFaction())) {
                w.setForce((int) (w.getForce()*toMultiply));
                if (w instanceof Hero && (toMultiply == 0.5)) {
                    ((Hero) w).decreaseEnergy(1);

                }
            }
        }
    }
    public void allenamento(Hero h){
        for (Warrior w : characters){
                w.addExp(1);
                w.updateForce();

        }
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public boolean decreaseCooldown() {
        if(cooldown != 0){
            cooldown--;
        }
        return false;
    }
    public void updateALL(){
        decreaseCooldown();
        for(Warrior w : characters){
            w.updateForce();
        }
    }
    public void setCharacters(ArrayList<Warrior> characters) {
        this.characters = (ArrayList<Warrior>) characters.clone();
    }
    public void addWarrior(Warrior w){
        characters.add(w);
    }

    public Warrior getWarrior(int index){
        if (index >= 0 && index < characters.size()) {
            return characters.get(index);
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
    public String stampaAlleati(boolean p1){
        StringBuilder app = new StringBuilder();
        int i = 0;
        int index = (p1 ? 1 : -1);
        for (Warrior w : characters) {
            i+= index;
            if(p1) app.append(i).append(") ");
            else  app.append("[").append(i).append("] ");
            if (w instanceof Character) {
                app.append(((Character) w).getRace()).append(" - ").append((i % 4 == 0 ? "\n" : "") );
            }
            if (w instanceof Hero) {
                 app.append(((Hero) w).getName()).append(" - ");
            }
        }

        app.replace(app.length()-1,app.length()-1,"\n");
        app.replace(app.length()-3,app.length()-2,"");
        app.append("\n");
        return app.toString();
    }

    public boolean isHere(Warrior g){
        for (Warrior w : characters){
            if(w.equals(g)) return true;
        }
        return false;
    }
    public void addGold(int gold){
        this.gold = getGold() + gold;
    }
    public int size(){
        return characters.size();
    }
    public void scambia(int index1, int index2){
        Warrior w = characters.get(index1);
        characters.set(index1,characters.get(index2));
        characters.set(index2,w);
    }
    public int remainingWarriors(){
        return characters.size();
    }
    public void rimuovi(Warrior w){
        characters.remove(w);
    }
    //Qua ho inserito funzioni utili per la gestione della "buyList" che gestisco tramite questi metodi dal Menu nella fase di pausa
    //Ritorna un Arraylist di Guerrieri che è possibile comprare, generati in base al player;
    //la forza minima dei guerrieri è 3 cosi si evitano situazioni dove ci sono opzioni inutili
    public ArrayList<Warrior> shop(){
        ArrayList<Warrior> buy = new ArrayList<>();
        for(int i = 0; i < characters.size()-2; i++){
            if (i != characters.size() / 2) buy.add(new Character((faction.equals("Bene")), Menu.ran(8) + 3, Menu.getRaces()[Menu.ran(3)+(faction.equals("Bene") ? 1 : 4)]));
            else buy.add(new Hero((faction.equals("Bene")), Menu.ran(8) + 3,Menu.ran(9) + 2,Menu.getHeroes()));
        }
        return buy;
    }

    public Warrior selectShop(ArrayList<Warrior> shop){
        int index = -1;
        boolean bought = false;
        do{
            System.out.println(stampaArray(shop,true));
            index = ConsoleInput.readIntP("Inserisci l'indice del personaggio da comprare -> ");
            index--;
            if(index < shop.size()){
                ConsoleInput.slowPrint(shop.get(index).toString(),1000);
                int select = ConsoleInput.readChar("Vuoi comprare questo personaggio ? (Y/N)");
                if(select == 'Y') {
                    int price = prezzoP(shop.get(index).getForce());
                    if (price > gold) {
                        System.out.println("Non hai abbastanza oro per comprare questo personaggio !\nInserisci " + (shop.size()) + " per uscire.");
                    } else {

                        break;
                    }
                }

            }
            if(index >= shop.size()){
                if(index == (shop.size())){
                    index = -1;
                    break;
                }
                else {
                    System.out.println("Posizione non valida !\nInserisci " + (shop.size()) + " per uscire.");
                }

            }
        }while (true);
        if(index != -1) {
            setGold(getGold() - shop.get(index).getForce() / 5);
            //Il personaggio viene aggiunto all'arsenale del giocatore e gli viene detratto l'oro
            addWarrior(shop.get(index));
            return shop.get(index);
        }
        return null;
    }

    public Warrior selectCharacter() {
        int index = -1;
        int exp = 0;
        do{
            System.out.println(stampaArray(characters,false));
            index = ConsoleInput.readIntP("Inserisci l'indice del personaggio da potenziare -> ");
            if(index <= size()) {
                exp = prezzoP(characters.get(index-1).getExp());
                if (exp > gold) {
                    System.out.println("Non hai abbastanza oro per potenziare questo personaggio !\nInserisci "+(size()+1)+" per uscire.");
                }
                else {
                    break;
                }
            }
            if(index > size() ){
                if(index == size()+1){
                    index = -1;
                    break;
                }
                else {
                    System.out.println("Posizione non valida !\nInserisci " + (size() + 1) + " per uscire.");
                }

            }
        }while (true);
        if(index != -1) {
            setGold(getGold() - exp);
            return getWarrior(index-1);
        }
        return null;
    }
    public int prezzoC(int forza){
        return (forza /4)+ 20;
    }
    public int prezzoP(int exp){
        return (int) (Math.pow(exp, 2) * 3);
    }
    public String stampaArray(ArrayList<Warrior> array,boolean compra){
        StringBuilder app = new StringBuilder();
        int treshold;
        int i = 0;
        for (Warrior w : array) {
            i++;
            treshold = (compra ? prezzoC(w.getForce()) : prezzoP(w.getExp()));
            app.append("[").append((treshold <= gold ? i : "-")).append("] ");
            if (w instanceof Character) {
                app.append(((Character) w).getRace()).append(" - ").append(i%4==0 ? "\n" : "");
            }
            if (w instanceof Hero) {
                 app.append(((Hero) w).getName()).append(" - ");
            }
        }
        app.replace(app.length()-1,app.length()-1,"\n");
        app.replace(app.length()-3,app.length()-1,"");
        app.append("[").append(i+=1).append("] Esci ");

        return app.toString();
    }
    public void stampaEroi(){
        int i = 0;
        String s="";
        for(Warrior w : characters){
            if(w instanceof Hero){
                i++;
                s+="\n"+i+") ";
                s+=((Hero) w).getName();
                s+=" - " + ((Hero) w).getSpecialAbility();
            }
        }
        i++;

        s+= "\n"+i+") "+"Esci";
        System.out.println(s);
    }
    public int nEroi(){
        int i = 0;
        for (Warrior w : characters){
            if (w instanceof Hero){
                i++;
            }
        }
        return i;
    }
    public int useAbility(){
        int scelta = -1;
        if(getCooldown() != 0) {
            System.out.println("Le tue abilità eroe sono ancora in cooldown per altri "+cooldown+" turni !");
            return scelta;
        }
        do{
            stampaEroi();
            scelta = ConsoleInput.readIntP("Usa l'abilità -> ");
            scelta--;
            if(scelta < nEroi()){
                System.out.println(" - Abilità attivata ! Cooldown -> "+ (cooldown+3));
                setCooldown(3);
                return scelta;
            }
            if(scelta >= nEroi() ){
                if(scelta == nEroi()){
                    scelta = -1;
                    break;
                }
                else {
                    System.out.println("Posizione non valida !\nInserisci " + (nEroi() + 1) + " per uscire.");
                }

            }
        }while (true);
        return scelta;
    }
    public Hero getHero(int index){
        int counter = nEroi()-1;
        int i = 0;
        for (Warrior w : characters){
            if(w instanceof Hero){
                if(counter == 0){
                    return (Hero) w;
                }
                else {
                    counter --;
                }
            }
            i++;
        }
        return null;
    }

}
