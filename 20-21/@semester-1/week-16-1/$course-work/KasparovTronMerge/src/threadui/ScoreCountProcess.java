package threadui;

public class ScoreCountProcess extends Thread {

    public ScoreCountProcess() {

    }

    public void run() {
        this.process();
    }

    public void process() {

        for(int i = 0; i < 5; i++) {
            System.out.println("Score : " + i);
        }

    }
}
