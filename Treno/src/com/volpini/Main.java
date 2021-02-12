package com.volpini;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Treno train = new Treno();
        VagoneMerci a = new VagoneMerci("1ASDB",300,"Mercedes","16/04/20","3 m^3",3000,500);
        train.aggiungiTreno(a);
        train.Stampa();
    }
}
