package com.volpini;
//todo ricordarsi del casting leggere polimofismo
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<FiguraGeometrica> figure = new ArrayList<>();
        figure.add(new Cerchio(2));
        figure.add(new Cono(3,5,6));
        figure.add(new Cilindro(2,5));
        figure.add(new Cilindro(2,5));
        figure.add(new Rettangolo(2,5));
        figure.add(new Trapezio(6,3,5,1,1,1,2));
        figure.add(new Parallelepipedo(2,5,8));

        for(FiguraGeometrica element : figure){
            System.out.println("\n"+element.getClass().getSimpleName());
            System.out.println(element.area());
            if(element instanceof FiguraSolida){
                System.out.println(((FiguraSolida) element).volume());
            }
            if(element instanceof FiguraPiana){
                System.out.println(((FiguraPiana) element).perimetro());
            }
        }
    }
}
