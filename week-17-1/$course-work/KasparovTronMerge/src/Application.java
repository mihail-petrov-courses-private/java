import config.PieceColor;
import managers.GameBoardManager;
import pieces.Piece;
import threadui.PeiceCalculatorProcess;
import threadui.ScoreCountProcess;

public class Application {

    public static void main(String[] args) { // Main Thread

//        System.out.println(Thread.currentThread());
//        PeiceCalculatorProcess p1   = new PeiceCalculatorProcess();
//        //ScoreCountProcess p2        = new ScoreCountProcess();
//
//        p1.start();
//        //p2.start();
//        //p2.run();
//
//        //Thread t1 = new Thread(p2);
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.print(Thread.currentThread());
//                for(int i = 0; i < 5; i++) {
//                    System.out.println("Score : " + i);
//                }
//            }
//        });
//        t1.start();
//


        GameBoardManager.init();

//        System.out.print(Thread.currentThread());
//        try {
//            Thread.sleep(1000);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // System.out.println("Finish thread sleep");
    }
}
