package com.volpini;

public class Hero extends Warrior {
    private int energy;
    private int force;
    public Hero(boolean a, int exp, int energy) {
        super(a, exp);
        this.energy = energy;
        force = getForce();
    }

    @Override
    public int getForce() {
       return 50*getExp()+50*getEnergy();
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setForce(int force) {
        this.force = force;
    }
    @Override
    public String toString(){
        return  "Eroe{" +
            super.toString()+
            "force -> " + force +
            "\nVital energy -> " + energy +
            "\n}";
    }
}
