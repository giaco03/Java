package com.volpini;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public interface Savable {


    default void write(Object object, File file) throws ExtensionExcp {
        if (!file.getName().endsWith(".bin")) throw new ExtensionExcp(file, ".bin");
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(object);
            System.out.println("The Object  was succesfully written to a file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    default  <T> T read(File file, Class<T> target) throws ExtensionExcp, FileNotFoundException {
        if (!file.getName().endsWith(".bin")) throw new ExtensionExcp(file,".bin");
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            Object o = reader.readObject();
            if (target.isInstance(o)) return (T) o;
            return null;
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    default Object loading(String s) {
        Object o = null;
        if(s == null) return o;
        try {
            File dataFile = new File("./"+s+".bin");
            o = read(dataFile, this.getClass());
        } catch (FileNotFoundException ignored) {
            System.out.println("File non trovato :/");
        }
        if (o == null) {
            try {
                o = this.getClass().getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
                System.out.println("Non è stato possibile istanziare questo oggetto.\n");
            }
        }
        return o;
    }
    default Object loading() {
        Object o = null;
        try {
            File dataFile = new File("./"+this.getClass().getSimpleName()+".bin");
            o = read(dataFile, this.getClass());
        } catch (FileNotFoundException ignored) {
            System.out.println("File non trovato :/");
        }
        if (o == null) {
            try {
                o = this.getClass().getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
                System.out.println("Non è stato possibile istanziare questo oggetto.\n");
            }
        }
        return o;
    }
    default void save() {
        File dataFile = new File("./"+this.getClass().getSimpleName()+".bin");
        this.write(this, dataFile);
        System.out.println("Arrivederci");
    }
    default void save(String s) {
        File dataFile = new File("./"+s+".bin");
        this.write(this, dataFile);
        System.out.println("Arrivederci");
    }
    default String select(){
        ArrayList<String> salvataggi = saves();
        if(salvataggi == null) return null;
        int i = 0;
        for(String options : salvataggi){
            i++;
            System.out.println(i+")"+options);
        }
        int choice;
        String selected;
        do{
            choice = ConsoleInput.readInt("Indice del file -> ");
            choice--;
            if(choice >= 0 && choice < salvataggi.size()){
                selected = salvataggi.get(choice);
                selected = selected.replace(".bin","");
                break;
            }
        }while (true);
        return selected;
    }

    default void delete(String toDelete){
        char confirm;
        confirm = ConsoleInput.readChar("Vuoi davvero cancellare questo file? (Y/N) -> ");
        if (confirm == 'N') {
            toDelete = null;
        }
        if(toDelete != null){
            File temp = new File("./"+toDelete+".bin");
            System.out.println(temp.delete() ? toDelete +" Cancellato con succeso!" : "File non trovato, se si vuole cancellare una directory essa deve esesere vuota.");
        }
    }
    default ArrayList<String> list(){
        File files = new File("./");
        String[] pathnames = files.list();
        ArrayList<String> validFiles = new ArrayList<>();
        if (pathnames != null) {
            for (String path : pathnames) {
                if (path.endsWith(".bin")) {
                    validFiles.add(path);
                }
            }

        }
        return validFiles;
    }
    default ArrayList<String> saves(){
        File files = new File("./");
        String[] pathnames = files.list();
        ArrayList<String> salvataggi = new ArrayList<>();
        boolean empty = true;
        if (pathnames != null) {
            for (String path : pathnames) {
                if (path.endsWith(".bin")) {
                    salvataggi.add(path);
                    empty = false;
                }
            }
        }
        if(!empty) {
            return salvataggi;
        }
        else {
            System.out.println("Non ci sono salvataggi in questa directory !");
            return null;
        }
    }
}