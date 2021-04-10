package com.volpini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleInput {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner ginga = new Scanner(System.in);


    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {
             return Integer.parseInt(reader.readLine());

        } catch (IOException | NumberFormatException exception) {
            System.out.println("Valore non corretto");
            return readInt(prompt);
        }
    }
    public static int readIntP(String prompt) {
        System.out.print(prompt);
        try {
            int i = Integer.parseInt(reader.readLine());
             if(i > 0){
                return i;
             }
             else{
                System.out.print("Il valore deve essere positivo.\n");
                return readIntP(prompt);
             }

        } catch (IOException | NumberFormatException exception) {
            System.out.println("Valore non corretto");
            return readInt(prompt);
        }
    }


    public static double readDouble(String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(reader.readLine());

        } catch (IOException | NumberFormatException exception) {
            System.out.println("Valore non corretto");
            return readDouble(prompt);
        }
    }


    public static String readline(String prompt) {
        System.out.print(prompt);
        try {
            return reader.readLine();

        } catch (IOException exception) {
            System.out.println("Stringa non valida");
            return readline(prompt);
        }
    }
    public static String readWhile(String prompt,String toBecome){
        System.out.print(prompt);
        try {
            String output;
                 output = reader.readLine();
                 if(output.equals(toBecome))
                     return output;
                 else {
                     System.out.println("Valore inserito non corretto.\n");
                     readWhile(prompt,toBecome);
                 }
        } catch (IOException exception) {
            System.out.println("Stringa non valida");
            return readline(prompt);
        }
        return null;
    }
    public static String readWhile2(String prompt,String toBecome,String option){
        System.out.print(prompt);
        try {
            String output;
            output = reader.readLine();
            if(output.equals(toBecome) || output.equals(option))
                return output;
            else {
                System.out.println("Valore inserito non corretto.\n");
                readWhile2(prompt,toBecome,option);
            }
        } catch (IOException exception) {
            System.out.println("Stringa non valida");
            return readline(prompt);
        }
        return null;
    }

    public static char readChar(String prompt) {
        System.out.print(prompt);
       return ginga.next().toUpperCase().charAt(0);

    }
    public static void slowPrint(String s,int milliseconds)  {
        try {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
                Thread.sleep(100);
            }
            Thread.sleep(milliseconds);
            System.out.println();
        }
        catch (InterruptedException i){
            i.printStackTrace();
        }
    }


}
