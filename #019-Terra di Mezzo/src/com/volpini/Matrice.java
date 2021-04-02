package com.volpini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Matrice implements Serializable {
    private List<ArrayList<Warrior>> matrix;
    private int n;
    public Matrice(ArrayList<Warrior> rowp1, ArrayList<Warrior> rowp2,ArrayList<Warrior> voidRow, int n) {
        this.n = n;
        matrix = new ArrayList<>();
        //row "non occupate", utile sia per la stampa che per inizializzazione
        //Avere l'attributo isOccupied mi permette di spostare i personaggi con più facilità;
        for (Warrior warrior : voidRow) {
            warrior.setOccupied(false);
        }

        for(int i = 0; i < n; i++) {
            if(i != n-1) {
                if(i == 0) {
                    matrix.add(i, rowp1);
                }
                else{
                    matrix.add(i,voidRow);
                }
            }
            else {
                matrix.add(i, rowp2);
            }
        }

    }

    public List<ArrayList<Warrior>> getMatrix() {
        return matrix;
    }
    public ArrayList<Warrior> getRow(int index){
        if (index >= 0 && index <= matrix.size()) {
            try {
                return matrix.get(index);
            }
            catch (NullPointerException e){
                System.out.println("Riga non trovata o non esistente !");
                return null;
            }
        }
        else return null;
    }
    public Warrior getWarrior(int y,int x){
        if (y >= 0 && y <= matrix.size() && x >= 0 && x <= matrix.size()) {
            try {
                return matrix.get(y).get(x);
            }
            catch (NullPointerException e){
                System.out.println("Personaggio non trovato o non esistente !");
                return null;
            }
        }
        else return null;
    }
    public void setRow(int index,ArrayList<Warrior> g){
        if (index >= 0 && index <= matrix.size()) {
            try {
                matrix.set(index,g);
            }
            catch (NullPointerException e){
                System.out.println("Riga non trovata o non esistente !");

            }
        }

    }
    public void setWarrior(int index,int x,Warrior w){
        if (index >= 0 && index <= matrix.size() && x >= 0 && x <= matrix.size()) {
            try {
                matrix.get(index).set(x,w);
            }
            catch (NullPointerException e){
                System.out.println("Personaggio non trovato o non esistente !");

            }
        }
    }

    public void stampaP1(){
        StringBuilder output = new StringBuilder();
        String lines = "------------------------------------";
        output.append(lines).append("\n| ");
        for(ArrayList<Warrior> warriors : matrix){

            for(Warrior w : warriors){
                if(w.isOccupied()) {
                    if (w instanceof Character) {
                        output.append(((Character) w).getRace().charAt(0)).append(((Character) w).getRace().charAt(1)).append(" | ");
                    } else {
                        output.append("He | ");
                    }
                }
                else {
                    output.append("   | ");
                }
            }
            output.append("\n");
            output.append(lines).append("\n| ");
        }
        output.delete(output.length()-3,output.length());
        System.out.println(output);
    }
    public void stampaP2(){
        StringBuilder output = new StringBuilder();
        String lines = "------------------------------------";
        output.append(lines).append("\n| ");
        for (int i = n-1; i >= 0; i --){
            for ( int j = n-1; j >= 0; j--){
                if(getWarrior(i,j).isOccupied()) {
                    Warrior w = getWarrior(i,j);
                    if (w instanceof Character) {
                        output.append(((Character) w).getRace().charAt(0)).append(((Character) w).getRace().charAt(1)).append(" | ");
                    } else {
                        output.append("He | ");
                    }
                }
                else {
                    output.append("   | ");
                }
            }
            output.append("\n");
            output.append(lines).append("\n| ");
        }
        output.delete(output.length()-3,output.length());
        System.out.println(output);
    }

    public void Stampa(){
        for (ArrayList<Warrior> warriors : matrix){
            for(Warrior w : warriors){
                if(w.isOccupied()) {
                    System.out.println(w.toString() + "\n");
                }
            }
        }
    }

    public int size(){
        return n;
    }

}
