package com.volpini;

import java.util.Arrays;
import java.util.Objects;

public class PortaCD {

    private int n;
    private CD[] cd;

    public PortaCD(int n) {
        this.n = n;
        cd = new CD[n];

    }

    public CD getCd(int counter) {
        if (counter < 0 || counter >= n) {
            return null;
        }
        return cd[counter];
    }

    public boolean setCd(int counter, CD c) {
        if (counter < 0 || counter >= n) {
            return false;
        }
        cd[counter] = c;
        return true;
    }

    public boolean killCd(int counter) {
        if (counter < 0 || counter >= n) {
            return false;
        }
        cd[counter] = null;
        return true;

    }

    public int getN() {
        return n;
    }

    public int cercaCDPerTitolo(String s) {

        for(int i = 0; i < n; i++){
            if(cd[i] != null) {
                if (cd[i].getTitolo().equals(s)) return i;
            }
        }
        return -1;
    }

    public int confrontaCollezione(PortaCD c) {
        int common = 0;

        for (int i = 0; i < this.n; i++) {
            for(int j = 0; j < c.getN(); j++) {
                if (this.cd[i] != null && c.cd[j] != null) {
                    if (this.cd[i].uguale(c.cd[j])) common++;
                }
            }
        }
        return common;
    }


    @Override
    public String toString() {
        return "PortaCD{" +
                "n=" + n +
                ", cd=" + Arrays.toString(cd) +
                '}';
    }




}
