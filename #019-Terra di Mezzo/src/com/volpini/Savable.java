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
    default Object loading() {
        Object o = null;
        String s = select();
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
                e.printStackTrace();
            }
        }

        return o;
    }

    default void save(String s) {
        File dataFile = new File("./"+s+".bin");
        this.write(this, dataFile);
        System.out.println("Arrivederci");
    }
    default String select(){
        File files = new File("./");
        String[] pathnames = files.list();
        ArrayList<String> salvataggi = new ArrayList<>();
        assert pathnames != null;
        for(String path : pathnames){
            if(path.endsWith(".bin")){
                salvataggi.add(path);
            }
        }
        int i = 0;
        for(String options : salvataggi){
            i++;
            System.out.println(i+")"+options);
        }
        int choice;
        String selected;
        do{
            choice = ConsoleInput.readInt("Indice del file -> ");
            if(choice >= 0 && choice < salvataggi.size()){
                selected = salvataggi.get(choice);
                break;
            }
        }while (true);
        return selected;
    }
    default ArrayList<String> saves(){
        File files = new File("./");
        String[] pathnames = files.list();
        ArrayList<String> salvataggi = new ArrayList<>();
        assert pathnames != null;
        for(String path : pathnames){
            if(path.endsWith(".bin")){
                salvataggi.add(path);
            }
        }
        return salvataggi;
    }
}