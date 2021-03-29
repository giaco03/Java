package volpini;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Savable {

    String binary = ".bin";
    String txt = ".txt";

    default void write(Object object, File file) throws ExtensionExcp {
        if (!file.getName().endsWith(binary)) throw new ExtensionExcp(file, binary);
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(object);
            System.out.println("The Object  was succesfully written to a file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    default  <T> T read(File file, Class<T> target) throws ExtensionExcp, FileNotFoundException {
        if (!file.getName().endsWith(binary)) throw new ExtensionExcp(file,binary);
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
    default ArrayList<String> readTxt(File file){
        ArrayList<String> stringhe = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                stringhe.add(reader.nextLine());
            }
            reader.close();
            return stringhe;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    default void writeTxt(Object object, File file){
        /*
        try {
            FileWriter writer = new FileWriter(file.getName());
            Class<?> clazz = object.getClass();
            for(Class<?> c = clazz; c != null; c =c.getSuperclass()) {
                Field[] fields = c.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object s = field.get(object);
                    writer.write(s.toString());
                    writer.write("\n");
                }
            }
            writer.close();

        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }

         */
        try {
            {
                FileWriter writer = new FileWriter(file.getName());
                writer.write(object.toString());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    default Object loading() {
        Object o = null;
        String c = select();
        if(c.equals(binary)) {
            try {
                File dataFile = new File("./" + this.getClass().getSimpleName() + c);
                o = read(dataFile, this.getClass());
            } catch (FileNotFoundException ignored) {
            }
            if (o == null) {
                try {
                    o = this.getClass().getDeclaredConstructor().newInstance();
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        else {
            File dataFile = new File("./" + this.getClass().getSimpleName() + c);
            ArrayList<String> parameters = readTxt(dataFile);
            if(parameters != null){
                Studente s = new Studente(parameters.get(0),parameters.get(1),Integer.parseInt(parameters.get(2)),parameters.get(3).charAt(0));
                return s;
            }
                // Creo l'oggetto da leggere implementando la soluzione ogni volta
                // Un esempio può essere Studente s = new Studente(parametri);
                // I parametri per costruire l'oggetto sono contenuti nell'ArrayList parameters e devono essere parsati
                // o trasformati nel tipp di destinazione
        }


        return o;
    }

    default void save() {
        String c = select();
        File dataFile = new File("./"+this.getClass().getSimpleName()+c);
        if(c.equals(txt)){
            this.writeTxt(this, dataFile);
        }
        else {
            this.write(this, dataFile);
        }
    }
    default String select(){
        String scelta;
        do {
            scelta = ConsoleInput.readline("Che tipo di file vuoi utilizzare? (.bin, .txt) -> ");
        } while (!scelta.equals(binary) && !scelta.equals(txt));
        return scelta;
    }
}