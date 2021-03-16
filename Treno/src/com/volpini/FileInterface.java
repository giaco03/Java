package com.volpini;

import com.volpini.ExtensionExcp;

import java.io.File;
import java.io.FileNotFoundException;

public interface FileInterface {

    void save(Object object, File file) throws ExtensionExcp;
    <T> T load(File file, Class<T> target) throws ExtensionExcp, FileNotFoundException;

}