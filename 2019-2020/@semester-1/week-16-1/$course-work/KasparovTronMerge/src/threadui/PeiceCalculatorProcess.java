package threadui;

public class PeiceCalculatorProcess extends Thread {


    public PeiceCalculatorProcess() {

    }

    public void run() {
        this.process();
    }

    public void process() {

        int peiceCalculation = 0;

//        for(int i = 0; i  < 100000; i++) {
        for(int i = 0; i  < 10; i++) {
            //peiceCalculation = peiceCalculation * 2;
            System.out.println("Iteration finish");
        }

        System.out.println("Result is done");
    }

}
