import config.PieceColor;
import meta.PiecePosition;
import pieces.Pawn;
import pieces.Piece;

public class Application {

    public static void main(String[] args) {

        Piece testPawn = null;
        try {
            //testPawn = new Pawn(PieceColor.WHITE, 0, 0);
            testPawn = new Pawn(PieceColor.WHITE, 0, 0);

            PiecePosition p = new PiecePosition(9, 9);
            System.out.println("Proceeed over the first try / catch");
        } catch (Exception e) {
            System.out.println("Application level try/catch");
            e.printStackTrace();
        } finally {
            System.out.println("Final count down");
        }
    }
}
