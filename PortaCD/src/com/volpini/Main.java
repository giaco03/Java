package com.volpini;



public class Main {

    public static  void main(String[] args) {
	// write your code here
        CD c1 = new CD("Toxicity", "System of a Down", 14, 43.58);
        CD c2 = new CD("Kety", "Ketama126", 15, 44.0);
        CD c3 = new CD("Furi","The Toxic Avenger", 22,43);
        CD c4 = new CD("Octavarium","Dream Theater", 8, 75.47);
        PortaCD[] collezione = new PortaCD[8];
        PortaCD portaCd1 = new PortaCD(5);
        portaCd1.setCd(0,c1);
        portaCd1.setCd(2,c3);
        collezione[1] = portaCd1;

        PortaCD portaCd2 = new PortaCD(6);
        portaCd2.setCd(0,c4);
        portaCd2.setCd(4,c2);
        portaCd2.killCD(0);
        portaCd1.Stampa(portaCd1.cercaCDPerTitolo("Toxicity"));
        for(int i = 0; i < portaCd1.getN();  i++){
            portaCd1.Stampa(i);
        }
        for(int i = 0; i < portaCd2.getN();  i++){
            portaCd2.Stampa(i);
        }
        portaCd2.setCd(2,c1);
        System.out.println(portaCd1.confrontaCollezione(portaCd2));


    }
}
