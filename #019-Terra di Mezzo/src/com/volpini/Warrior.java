package com.volpini;

import java.io.Serializable;

public abstract class Warrior implements Serializable {
    private String faction;
    private int exp;
    private boolean isOccupied;
    public Warrior(boolean a, int exp) {
        if(a) {
            faction = "Bene";
        }
        else faction = "Male";
        this.exp = exp;
        isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public abstract int getForce();

    public String getFaction() {
        return faction;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    @Override
    public String toString() {
        return "\nexp -> "+exp+"\n";
    }
}
