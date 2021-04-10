package com.volpini;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Warrior implements Serializable,Cloneable {
    private String faction;
    private int exp;
    private final UUID idUnivoco;
    public Warrior(boolean a, int exp) {
        if(a) {
            faction = "Bene";
        }
        else faction = "Male";
        this.exp = exp;
        idUnivoco = UUID.randomUUID();
    }

    public abstract int getForce();
    public abstract void updateForce();
    public abstract void setForce(int force);

    public String getFaction() {
        return faction;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public int addExp(int exp){
        this.exp = getExp()+exp;
        return this.exp;
    }
    public void setFaction(String faction) {
        this.faction = faction;
    }

    @Override
    public String toString() {
        return "\nexp -> "+exp+"\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warrior)) return false;

        Warrior warrior = (Warrior) o;

        if (getExp() != warrior.getExp()) return false;
        if (getFaction() != null ? !getFaction().equals(warrior.getFaction()) : warrior.getFaction() != null)
            return false;
        return Objects.equals(idUnivoco, warrior.idUnivoco);
    }

    @Override
    public int hashCode() {
        int result = getFaction() != null ? getFaction().hashCode() : 0;
        result = 31 * result + getExp();
        result = 31 * result + (idUnivoco != null ? idUnivoco.hashCode() : 0);
        return result;
    }

    @Override
    public Warrior clone() {
        final Warrior clone;
        try {
            clone = (Warrior) super.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new RuntimeException("Superclass messed up", ex);
        }
        return clone;
    }
}
