package patatina;

import java.io.File;
import java.util.ArrayList;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Classe lista = new Classe();
        Classe lista2 = new Classe();

        lista.aggiungi(new Studente("Ciccio", "Doppio Ciao", 30, 'a'));
        lista.aggiungi(new Studente("Ciao2", "Doppio Ciao2", 33, 'b'));

        try{
            TextFile out = new TextFile("file.txt",'W');
            out.writeData(lista.toString());
            out.closeFile();
        }
        catch(IOException e2){
            e2.printStackTrace();
        }

        String[] parametri;
        try{
            TextFile in = new TextFile("file.txt",'R');
            while((parametri = in.readData()) != null && parametri.length >= 5){
                lista2.aggiungi(new Studente(parametri[0], parametri[1], Integer.parseInt(parametri[2]), parametri[3].charAt(0)));
            }
            in.closeFile();
        }
        catch(IOException e2){
            e2.printStackTrace();
        }

        System.out.println(lista2.toString());
    }
}
