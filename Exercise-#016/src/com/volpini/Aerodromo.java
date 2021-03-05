package com.volpini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aerodromo implements Serializable,Savable {
    private List<Aeromobile> lista;
    public Aerodromo(){
        lista = new ArrayList<>();
    }
    public void aggiungi(Aeromobile a){
        lista.add(a);
    }
    public boolean elimina(int index){
        index-=1;
        if(index >= 0 && index <= lista.size()){
            lista.remove(index);
            return true;
        }
        return false;
    }
    public boolean elimina(String s){
        for(Aeromobile element : lista){
            if(element.getsigla().equals(s)){
                lista.remove(element);
                return true;
            }
        }
        return false;
    }
    public void compare(String sigla1, String sigla2){
        int index1 = -1;
        int index2 = -1;

        for(int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getsigla().equals(sigla1)) index1 = i;

            if(lista.get(i).getsigla().equals(sigla2)) index2 = i;
        }
        if(index1  == -1 || index2 == -1) System.out.println("L'elemento non è stato trovato");
        try {
            System.out.println("La differenza fra i due è ->"+lista.get(index1).compareTo(lista.get(index2)));
        } catch (ClassCastException | NullPointerException e){
            System.out.println("Non è possibile confrontare i due elementi");
        }


    }
    public void Stampa() {
        int i = 0;
        for (Aeromobile element : lista) {
            i++;
            if (element != null) {
                System.out.println("\n" + i + ")" +element.getClass().getSimpleName()
                        + element.toString() + "\n");
            }
        }
    }



}
