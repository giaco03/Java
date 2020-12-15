package com.volpini;

import java.util.Arrays;

public class PortaCD {

    private int n;
    private CD[] cd;
    private int counter;
    public PortaCD(int n) {
        this.n = n;
        cd = new CD[n];

    }

    public CD getCd(int counter) {
       if(counter < 0 || counter >= n ){

       }
       return cd[counter];
    }

    public  boolean setCd(int counter, CD c) {
        if(counter < 0 || counter >= n ){
            return false;
        }
        cd[counter] = c;
        return true;
    }
    public boolean killCD(int counter){
        if(counter < 0 || counter >= n ){
            return false;
        }
        cd[counter] = null;
        return  true;

    }
    public int getN( ){
        return n;


    }
    public int cercaCDPerTitolo(String s) {
        int i=0,app=0;
        while(i<cd.length){
            if(cd[i].getTitolo().equals(s)){
                return i;
            }
            i++;

        }
        return -1;
    }

    public int confrontaCollezione(PortaCD c){
        int common=0,min;
        if(n > c.getN()){
            min = c.getN();
        }
        else{
            min = n;
        }
        for(int i = 0; i < min; i++){
            if(cd[i].equals(c.getCd(i))){
                common++;
            }
        }
        return common;
  }


    @Override
    public String toString() {
        return "PortaCD{" +
                "n=" + n +
                ", cd=" + Arrays.toString(cd) +
                ", counter=" + counter +
                '}';
    }
    public String Stampa(int i){
        return i+")"+cd[i];
    }
}
