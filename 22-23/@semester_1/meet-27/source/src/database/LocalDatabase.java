package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LocalDatabase {

    private static final String DB_SNAPSHOT = "local_db.txt";
    private static final String DB_KEY_VALUE_SEPARATOR = "=@=";
    private static FileWriter fileManager;

    public static void write(String value) {
        try {
            FileWriter fileManager = new FileWriter(DB_SNAPSHOT, true);
            fileManager.write(value + "\n");
            fileManager.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void write(String key, String value) {

        String dbValue = key + DB_KEY_VALUE_SEPARATOR + value;
        write(dbValue);
    }

    public static void write(String key, int[][] value) {
        write(key, DataTransformator.matrixTransform(value));
    }

    public static String read(String key) {

        try {
            FileReader baseReader        = new FileReader(DB_SNAPSHOT);
            BufferedReader readerManager = new BufferedReader(baseReader);

            String processableLine = readerManager.readLine();

            while (processableLine != null) {

                if(processableLine.contains(key)) {
                    return extractValueFromDatabase(processableLine);
                }

                processableLine = readerManager.readLine();
            }

            return null;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String readFile() {

        try {
            FileReader baseReader = new FileReader(DB_SNAPSHOT);
            BufferedReader readerManager = new BufferedReader(baseReader);

            String resultString = "";
            String processableLine = readerManager.readLine();

            while (processableLine != null) {
                resultString += processableLine + "\n";
                processableLine = readerManager.readLine();
            }

            return resultString;
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    private static String extractValueFromDatabase(String processableLine) {

        String[] stringCollection = processableLine.split(DB_KEY_VALUE_SEPARATOR);

        if(stringCollection.length == 2) {
            return stringCollection[1];
        }

        return null;
    }
}
