package util;

public class SequenceGenerator {

    private static int generatorSequencer = 1;

    public static int next() {
        return generatorSequencer++;
    }
}
