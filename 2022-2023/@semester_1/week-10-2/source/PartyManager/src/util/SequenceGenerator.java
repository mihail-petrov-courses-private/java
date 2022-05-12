package util;

public class SequenceGenerator {

    private static int generatorSequencer = 1;
    private static int generatorSequencerEvent = 1;
    private static int generatorSequencerCustomer = 1;

    public static int next() {
        return generatorSequencer++;
    }

    public static int nextEventId() {
        return generatorSequencerEvent++;
    }

    public static int nextCustomerId() {
        return generatorSequencerCustomer++;
    }
}
