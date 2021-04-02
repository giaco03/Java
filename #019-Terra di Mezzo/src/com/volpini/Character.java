package com.volpini;

import java.io.Serializable;

public class Character extends Warrior {
    private String race;
    private int force;

    public Character(boolean a, int exp, String race) {
        super(a, exp);
        this.race = race;
        force = getForce();
    }


    public String getRace() {
        return race;
    }
    @Override
    public int getForce(){
        switch (getRace()){
            case "Uomini":
                return 30+(6*getExp());
            case "Elfi":
                if(getExp() < 5) return 20+(3*getExp());
                else return 80+(2*getExp());
            case "Nani":
                return 20+(4*getExp());
            case "Hobbit":
                return 10+(3*getExp());
            case "Orchi":
                if(getExp() < 5) return 30+(2*getExp());
                else return 70+(3*getExp());
            case "Urukhai":
                return 50+(5*getExp());
            case "Sudroni":
                return 40+(5*getExp());
            default:
                return 1;
        }
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return  race +"{" +
                super.toString()+
                "force -> " + force +
                "\n}";
    }
}
