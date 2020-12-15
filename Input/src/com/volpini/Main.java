package com.volpini;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    //Input da tastiera
    public static void main(String[] args)  {
	// write your code here
        double euro = 0,totale;

        int centesimi = ConsoleInput.readInt("Quanti centesimi hai?");

        euro = ConsoleInput.readDouble("Supponiamo di avere 75 centesimi di Euro, quanti Euro sono?");
        do{
            euro = ConsoleInput.readDouble("I conti  non tornano.\nQuanti Euro sono 75 centesimi?");
        }while (euro != 0.75);

        String chi = ConsoleInput.readline("A chi devi questi soldi?");
        totale = centesimi*0.01 + euro;
        System.out.println("Devi"+totale+"£ a "+chi);
    }
}
//Nella stessa classe con stesso nome ma diversa firmatura
