package com.volpini;

import java.util.ArrayList;
import java.util.List;

public class Operazione {

    public static double risolviEQ(double a, double b) throws EqImpossibile,IndetermExcp{
        if(a== 0 && b==0){
            throw new IndetermExcp();
        }
        if(a==0) throw new EqImpossibile();
        if(b==0) return 0;
        return -b/a;
    }

    public static List<Double> Eq(double a, double b, double c){
        double delta;
        List<Double> list = new ArrayList<>();
        if(a == 0){
            list.add(Operazione.risolviEQ(b,c));
            return list;
        }
        if(b == 0){
            if(a==0){
                throw new EqImpossibile("Il risultato è uguale a"+c);
            }
            if(-c/a < 0){
                throw new EqImpossibile();
            }
            list.add(Math.sqrt(-c/a));
            list.add(-Math.sqrt(-c/a));
            return list;
        }
        if(c == 0){
            list.add((double) 0);
            list.add(Operazione.risolviEQ(a,b));
            return list;
        }
        delta=Math.pow(b,2)-(4*(a*c));
        if(delta < 0){
            throw new EqImpossibile("L'equazione è impossibile perché il delta è negativo");
        }
        if(delta == 0){
            list.add(-b/(2*a));
            list.add(-b/(2*a));
            return list;
        }
        list.add((-b-Math.sqrt(delta))/2*a);
        list.add((-b+Math.sqrt(delta))/2*a);
        return list;
    }
    public static double getDelta(double a, double b, double c){
        return  Math.pow(b,2)-(4*(a*c));
    }
}
