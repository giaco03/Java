package com.volpini;
import java.io.*;

public class FileBinario implements FileInterface{

    public void save(Object object, File file) throws ExtensionExcp {
        if (!file.getName().endsWith(".bin")) throw new ExtensionExcp(file, ".bin");
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(object);
            System.out.println("The Object  was succesfully written to a file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public <T> T load(File file, Class<T> target) throws ExtensionExcp, FileNotFoundException {
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
}
