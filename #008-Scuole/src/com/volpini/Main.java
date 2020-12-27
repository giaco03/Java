package com.volpini;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
      List<Scuola> scuole = new ArrayList<>();

      scuole.add(new Elementari("1A","Gandhi","Via degli Ulivi","Sesto Fiorentino",400,20,2,0));
      scuole.add(new Medie("1B","Lorenzo de Medici","Via dell'Erede","Barberino del Mugello",200,6,0,2));
      scuole.add(new Licei("2A","Leonardo da Vinci","Via Giovanni de Marignoli","Firenze",2000,40,1,8));
      scuole.add(new Tecnici("2B","ITIS Buzzi","Viale della Repubblica","Prato",2400,60,0,15,6));
      scuole.add(new Professionali("3A","Alberghiero Matteotti","Via Italo Possenti","Pisa",2060,30,1,8));

      for(Scuola element : scuole){
          if(element instanceof Professionali){
              ((Professionali) element).setcRegionali(ConsoleInput.readDouble("Inserire contributi regionali -> "));
          }
          if(element instanceof Tecnici){
              ((Tecnici) element).setcIndirizzi(ConsoleInput.readDouble("Inserire contributi per indirizzo - > "));
          }
          System.out.println(element.toString());
      }
    }
}
