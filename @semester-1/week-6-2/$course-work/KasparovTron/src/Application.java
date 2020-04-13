import config.PieceColor;
import managers.GameBoard;
import pieces.IHealable;
import pieces.Pawn;
import pieces.Piece;
import tests.PawnTest;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to KASPAROV-TRON 101");

//        GameBoard board = new GameBoard();
//        board.populate();
//        board.render();

        // PawnTest.run();, 0, 0
        Pawn p = new Pawn(PieceColor.BLACK, 0, 0);
        // p.getInfo();


        System.out.println(p instanceof Pawn);  // true
        System.out.println(p instanceof Piece); // true
        System.out.println(p instanceof Object); // true
        System.out.println(p instanceof IHealable); // true

        IHealable healableReference = new Pawn(PieceColor.BLACK, 0, 1);
        Object objectReference      = new Pawn(PieceColor.BLACK, 0, 1);



    }
}