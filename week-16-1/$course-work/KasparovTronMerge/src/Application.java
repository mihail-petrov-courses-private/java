import config.PieceColor;
import managers.GameBoardManager;
import pieces.Piece;
import threadui.PeiceCalculatorProcess;
import threadui.ScoreCountProcess;

public class Application {

    public static void main(String[] args) { // Main Thread
        // GameBoardManager.init();

        // Thread simulation
        // 1. SLow asss hell
        PeiceCalculatorProcess processPiece = new PeiceCalculatorProcess();

        // 2. Concurency
        ScoreCountProcess scoreCountPiece      = new ScoreCountProcess();

        // create new Thread
        processPiece.start(); // -- live in separate Thread

        // 1. Non blocking UI
        // 2. Hevy lifting

        // processPiece.process();
        scoreCountPiece.start(); // -- main Thread
    }
}
