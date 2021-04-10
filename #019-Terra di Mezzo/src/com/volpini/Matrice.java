package com.volpini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Matrice implements Serializable {
   // private List<ArrayList<Warrior>> matrix;
    private Warrior[][] matrix;
    private int n;
    public Matrice(ArrayList<Warrior> rowp1, ArrayList<Warrior> rowp2, int n) {
        this.n = n;
        matrix = new Warrior[n][n];
        setRow(0, rowp1.toArray(Warrior[]::new));
        setRow(n-1, rowp2.toArray(Warrior[]::new));
    }
    public void addToFirstEmpty(Warrior w,Giocatore p,boolean p1Turn){
        int whereToStart = (p1Turn ? 0 : size()-1);
        int whereToGo = (p1Turn ? 1 : -1);
        for(int i = whereToStart; (p1Turn ? i < size() : i > 0); i+=whereToGo){
            if(getRow(i) != null) {
                for (int j = 0; j < size(); j++) {
                    if (getWarrior(i, j) == null) {
                        setWarrior(i, j, w);
                         i = (p1Turn ? size() :  0);
                        break;
                    }
                }
            }
        }
        System.out.println("Personaggio aggiunto con successo !\n");

    }
    public Warrior[] getRow(int index){
        if (index >= 0 && index <= size()) {
                return matrix[index];
        }
        else return null;
    }
    public Warrior getWarrior(int y,int x){
        if (y >= 0 && y <= size() && x >= 0 && x <= size()) {
            return matrix[y][x];
        }
        else return null;
    }
    public void setRow(int index, Warrior[] g){
        if (index >= 0 && index <= size()) {
            matrix[index] = g.clone();
        }
    }
    public void setWarrior(int index,int x,Warrior w){
        if (index >= 0 && index <= size() && x >= 0 && x <= size()) {
            matrix[index][x] = w;
        }
    }

    public void stampaMatrice(boolean p1){
        StringBuilder output = new StringBuilder();
        String lines = "-";
        for(int i = 0; i < size(); i++){
            lines += "------";
        }
        output.append(lines).append("\n| ");
        int whereToStart = (p1 ? 0 : size()-1);
        int whereToGo = (p1 ? 1 : -1);
        for (int i = whereToStart; (p1 ? i < size() : i >= 0); i+=whereToGo){
            for (int j = 0;  j < size(); j++){
                Warrior w = getWarrior(i,j);
                if(w != null) {
                    if (w instanceof Character) {
                        output.append(((Character) w).getRace(),0,3).append(" | ");
                    } else {
                        output.append(((Hero) w).getName(), 0, 3).append(" | ");
                    }
                }
                else {
                    output.append("    | ");
                }
            }
            output.append("\n");
            output.append(lines).append("\n| ");
        }
        output.delete(output.length()-3,output.length());
        System.out.println(output);
    }


    public int size(){
        return n;
    }

    public Pair getCoordinates(Warrior w) {
        for(int i = 0;  i < size() ; i++){
                for (int j = 0; j < size(); j++) {
                    if (getWarrior(i, j) != null) {
                        if (getWarrior(i, j).equals(w)) {
                            return new Pair(j, i);
                        }
                    }
                }

        }
        return new Pair(-1,-1);
    }
    public void effect(Hero h,double toMultiply){
        for(int i = 0; i < size(); i ++){
            for(int j = 0; j < size(); j++){
                if (getWarrior(i, j) != null) {
                    Warrior w = getWarrior(i, j);
                    if ((toMultiply == 0.5) ^ w.getFaction().equals(h.getFaction())) {
                        w.setForce((int) (w.getForce()*toMultiply));
                        if (w instanceof Hero && (toMultiply == 0.5)) {
                            ((Hero) w).decreaseEnergy(1);
                        }
                    }
                }
            }
        }
    }
    public void updateALL(){
        for(int i = 0; i < size(); i ++){
            for(int j = 0; j < size(); j++){
                if (getWarrior(i, j) != null) {
                    getWarrior(i,j).updateForce();
                }
            }
        }
    }
    public void allenamento(Hero h){
        for(int i = 0; i < size(); i ++){
            for(int j = 0; j < size(); j++){
                if (getWarrior(i, j) != null) {
                    Warrior w = getWarrior(i, j);
                    if (w.getFaction().equals(h.getFaction())) {
                        w.addExp(1);
                        w.updateForce();
                    }
                }
            }
        }
    }
}
