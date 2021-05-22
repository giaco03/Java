package com.volpini;

import java.io.Serializable;
import java.util.Objects;

public class Character extends Warrior {
    private String race;
    private int force;

    public Character(boolean a, int exp, String race) {
        super(a, exp);
        this.race = race;
        if(race.equals("Ent") || race.equals("Goblin")) addExp(2);
        force = getForce();
    }


    public String getRace() {
        return race;
    }
    @Override
    public int getForce(){
        switch (getRace()){
            case "Uomini":
                force = (int) (30+(Math.pow(2,getExp()) / 5));
                break;
            case "Elfi":
                if(getExp() <= 5) force = 20+(5*getExp());
                else force = 80+(getExp()*getExp());
                break;
            case "Nani":
                force = 20+(4*getExp()*2);
                break;
            case "Hobbit":
                force = 30+(3*getExp());
                break;
            case "Ent":
                force = 40 + (getExp()*4);
                break;
            case "Orchi":
                if(getExp() <= 5) force = 40+(2*getExp()+getExp());
                else force = (int) (70+((Math.pow(Math.E,getExp()))/Math.pow(getExp(),2)*2));
                break;
            case "Urukhai":
                force = (int) Math.pow(getExp(),(Math.abs(getExp()-7)));
                break;
            case "Sudroni":
                force = 40+(5*getExp());
                break;
            case "Goblin":
                force = 30 + (2*getExp());
                break;

            case "Troll":
                force = 100 + (3*getExp());
                break;
        }
        return force;
    }
    @Override
    public void updateForce(){
        this.force = getForce();
    }

    @Override
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


   /* public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        if (!super.equals(o)) return false;

        Character character = (Character) o;

        if (getForce() != character.getForce()) return false;
        return getRace().equals(character.getRace());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getRace().hashCode();
        result = 31 * result + getForce();
        return result;
    }
    */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        if (!super.equals(o)) return false;
        Character character = (Character) o;
        return getForce() == character.getForce() && getRace().equals(character.getRace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRace(), getForce());
    }
}
