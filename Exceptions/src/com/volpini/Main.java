package com.volpini;

import java.util.Random;


public class Main {

    public static void main(String[] args) {
	// write your code here
        int s=6;
        double a,b,c;
        do {
            s = ConsoleInput.readInt("\n1)Risolvi equazione\n2)Genera equazione\n3)Formula generale\n0)Esci\nInserisci la scelta -> ");
            switch (s) {
                case 1:
                    a = ConsoleInput.readDouble("\nInserisci il coeff a -> ");
                    b = ConsoleInput.readDouble("\nInserisci il coeff b -> ");
                    c = ConsoleInput.readDouble("\nInserisci il termine noto -> ");
                    System.out.println("Eq ->[" + a + " x^2 + " + b + " x + " + c + "]");
                    System.out.println("∆ = ("+b+")^2"+" - 4*("+a+"*"+c+")");
                    System.out.println("x1,2 = (-"+b+" +- √"+Operazione.getDelta(a,b,c)+") / 2*"+a);
                    try { System.out.println("x1,2" + Operazione.Eq(a, b, c));
                    } catch (EqImpossibile | IndetermExcp e2) { System.out.println(e2.getMessage());
                    }
                    break;
                case 2:
                    a = ran();
                    b = ran();
                    c = ran();
                    try {
                    System.out.println("Eq ->[" + a + " x^2 + " + b + " x + " + c + "]");
                    System.out.println("x1,2" + Operazione.Eq(a, b, c));
                } catch (EqImpossibile | IndetermExcp e2) {
                    System.out.println(e2.getMessage());
                }
                break;
                case 3:
                    System.out.println("∆ = (b)^2 - 4* (a*c)");
                    System.out.println("x1,2 = (-b +- √∆) / 2*a");
                    break;
                default:
                    System.out.println("Valore non corretto.\nReinserire\n");
            }
        }while (s!=0);
    }

    public static double ran(){
        Random r = new Random();
        return r.nextInt(200) / 10.0;
    }

}
