import managers.GameBoard;
import tests.PawnTest;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to KASPAROV-TRON 101");

//        GameBoard board = new GameBoard();
//        board.populate();
//        board.render();

        PawnTest.run();
    }
}