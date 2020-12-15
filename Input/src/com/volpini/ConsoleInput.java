package com.volpini;
import java.io.*;

public class ConsoleInput {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




    public static int readInt(String prompt)  {
        try{
            return Integer.parseInt(reader.readLine());

        }
        catch (java.io.IOException | NumberFormatException exception){
            System.out.println("Valore non corretto");
            return readInt(prompt);
        }
    }

    public static double readDouble(String prompt)  {
        System.out.println(prompt);
        try{
           return Double.parseDouble(reader.readLine());

        }
        catch (java.io.IOException | NumberFormatException exception ){
            System.out.println("Valore non corretto");
           return readDouble(prompt);
        }
    }


    public static String readline(String prompt){
        System.out.println(prompt);
       try{
          return reader.readLine();

       }
       catch (java.io.IOException exception){
           System.out.println("Stringa non valida");
           return readline(prompt);
       }
    }
}