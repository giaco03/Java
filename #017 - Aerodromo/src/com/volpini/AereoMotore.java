package com.volpini;

public class AereoMotore extends Aeromobile{
    private double potenzaCV;

    public AereoMotore(String sigla, double potenzaCV) {
        super(sigla);
        this.potenzaCV = potenzaCV;
    }

    public double getPotenzaCV() {
        return potenzaCV;
    }

    public void setPotenzaCV(double potenzaCV) {
        this.potenzaCV = potenzaCV;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\npotenzaCV=" + potenzaCV +
                "\n}";
    }


    @Override
    public int compareTo(Aeromobile o) {
        if(o == null){
            throw new NullPointerException("l'elemento è null");
        }
        if(o instanceof AereoMotore){
            return (int) (this.potenzaCV - ((AereoMotore) o).getPotenzaCV());
        }
        else {
            throw new ClassCastException("Non è possibile comparare i due metodi");
        }

    }
}
