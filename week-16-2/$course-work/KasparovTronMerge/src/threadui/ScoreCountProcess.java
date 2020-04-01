package threadui;

// public class ScoreCountProcess extends Thread {
public class ScoreCountProcess implements Runnable {

    public ScoreCountProcess() {

    }

    public void run() {
        System.out.println(Thread.currentThread());
        this.process();
    }

    public void process() {

        for(int i = 0; i < 5; i++) {
            System.out.println("Score : " + i);
        }

    }
}
