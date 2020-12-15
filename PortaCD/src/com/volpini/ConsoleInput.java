package com.volpini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




    public static int readInt(String prompt)  {
        try{
            return Integer.parseInt(reader.readLine());

        }
        catch (IOException | NumberFormatException exception){
            System.out.println("Valore non corretto");
            return readInt(prompt);
        }
    }

    public static double readDouble(String prompt)  {
        System.out.println(prompt);
        try{
           return Double.parseDouble(reader.readLine());

        }
        catch (IOException | NumberFormatException exception ){
            System.out.println("Valore non corretto");
           return readDouble(prompt);
        }
    }


    public static String readline(String prompt){
        System.out.println(prompt);
       try{
          return reader.readLine();

       }
       catch (IOException exception){
           System.out.println("Stringa non valida");
           return readline(prompt);
       }
    }
    public String msg(String s){
        System.out.println(s);
        try{
            return reader.readLine();

        }
        catch (IOException exception){
            System.out.println("Stringa non valida");
            return msg(s);
        }
    }
}