package com.volpini;

public class Alianti extends Aeromobile {
    private int efficiency;

    public Alianti(String sigla, int efficiency) {
        super(sigla);
        setEfficiency(efficiency);
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        if (efficiency <= 100 && efficiency >= 0) {
            this.efficiency = efficiency;
        }
    }
    public String toString() {
        return  super.toString() +
                "\nefficineza='" + efficiency+
                "\n}";
    }


    public int compareTo(Aeromobile o) throws ClassCastException {
       if( o == null){
           throw new NullPointerException();
       }
       if(o instanceof Alianti){
           return this.efficiency - ((Alianti) o).getEfficiency();
       }
       else {
           throw new ClassCastException();
       }

    }
}
