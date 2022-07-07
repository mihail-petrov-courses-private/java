package me.mihailpetrov.stagestopwatch.services.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDatabase {

    public static void write(File file, String value) {

        try {
            FileWriter fileManager = new FileWriter(file, true);
            fileManager.write(value + "\n");
            fileManager.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
