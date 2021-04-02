package com.volpini;

public class Pair {
    private int uno; // x
    private int due; // y

    public Pair(int uno, int due) {
        this.uno = uno;
        this.due = due;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public int getDue() {
        return due;
    }

    public void setDue(int due) {
        this.due = due;
    }
    public void setBoth(int uno, int due){
        setUno(uno);
        setDue(due);
    }
    public Pair getBoth(){
        return new Pair(getUno(),getDue());
    }
}
