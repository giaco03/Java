package com.volpini;

import java.io.Serializable;
import java.util.*;


public class Mailbox implements Serializable,Savable {
    private Stack<Mail> mailbox;

    public Mailbox() {
        mailbox = new Stack<>();
    }
    public void aggiungi(Mail m){
        mailbox.push(m);
    }
    public boolean elimina(int i){
        i -= 1;
        if (i >= 0  && i <= mailbox.size()) {
            mailbox.remove(i);
            return true;
        }
        return false;
    }
    public List<Mail> ricerca(String s){
        List<Mail> lista = new ArrayList<>();
        for (Mail element : mailbox) {
            if (element.getOggetto().contains(s)) {
                lista.add(element);
            }
        }
        return lista;
    }
    public void stampa(){
        int i = 0;
        for (Mail element : mailbox) {
            i++;
            if (element != null) {
                System.out.println( i + ")"
                        +element.toString()+"\n");
            }
        }
    }
    public void open(int n){
         n-= 1;
        if (n >= 0  && n <= mailbox.size() && mailbox.size() >= 1) {
            System.out.println(mailbox.get(n).mail());
        }
    }
}
