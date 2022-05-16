package state;

public class TimeCount {

    private static TimeCount instance   = null;
    private int counter                 = 0;

    public static TimeCount getInstance() {

        if(instance == null) {
            instance = new TimeCount();
        }

        return instance;
    }

    public int getCounter() {
        return counter;
    }

    public void reset() {
        this.counter = 0;
    }

    public void update() {
        this.counter++;
    }

    private TimeCount() {

    }
}
