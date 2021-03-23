package sample;

import java.io.File;

public class ExtensionExcp extends RuntimeException {

    public ExtensionExcp(File file, String s) {
        super("Invalid extension: " + file.getName() + ". \"" + s + "\" excpected.");
    }
}