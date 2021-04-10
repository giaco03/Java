package com.volpini;

public class Hero extends Warrior {
    private int energy;
    private int force;
    private String name;
    private String specialAbility;
    public Hero(boolean a, int exp, int energy,String [] names) {
        super(a, exp);
        this.energy = energy;
        force = getForce();
        this.name = names[Menu.ran(names.length/2) + (a ? 2 : 0)];
        switch (this.name) {
            case "Sauron" -> specialAbility = "Maledizione dell'Occhio";
            case "Gollum" -> specialAbility = "Il mio Tesssoro";
            case "Gandalf" -> specialAbility = "Benedizione della Compagnia";
            case "Aragorn" -> specialAbility = "Allenamento dei Re";
        }
    }

    @Override
    public int getForce() {
       return 50*getExp()+50*getEnergy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        if (!super.equals(o)) return false;

        Hero hero = (Hero) o;

        if (getEnergy() != hero.getEnergy()) return false;
        if (getForce() != hero.getForce()) return false;
        return getName() != null ? getName().equals(hero.getName()) : hero.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getEnergy();
        result = 31 * result + getForce();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public void updateForce(){
        this.force = getForce();
    }

    @Override
    public void setForce(int force) {
        this.force = force;
    }

    public String getName() {
        return name;
    }


    public int getEnergy() {
        return energy;
    }

    public void decreaseEnergy(int dmg) {
        energy = getEnergy() - dmg;
    }

    @Override
    public String toString(){
        return  name+"{" +
            super.toString()+
            "force -> " + force +
            "\nVital energy -> " + energy +
            "\n}";
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }
}
