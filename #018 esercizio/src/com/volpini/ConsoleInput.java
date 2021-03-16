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
            System.out.print("Valore non corretto");
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

    public static char readChar(String prompt) {
        System.out.print(prompt);
        return ginga.next().charAt(0);

    }


}