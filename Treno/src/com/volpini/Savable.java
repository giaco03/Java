package com.volpini;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface Savable {
    static final File dataFile = new File("./storage.bin");

    default void sasso(Object object, File file) throws ExtensionExcp {
        if (!file.getName().endsWith(".bin")) throw new ExtensionExcp(file, ".bin");
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(object);
            System.out.println("The Object  was succesfully written to a file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    default  <T> T load(File file, Class<T> target) throws ExtensionExcp, FileNotFoundException {
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
    default Object loaded() {
        Object o  = null;

        try {
             o = load(dataFile, this.getClass());
        } catch (FileNotFoundException ignored) {
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

    default void save() {
        this.sasso(this, dataFile);
        System.out.println("Arrivederci");
    }
}
