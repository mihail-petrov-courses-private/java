package tests.test;

import config.PieceColor;
import pieces.Rook;
import tests.main.MainTest;

public class RookTest extends MainTest {

    static void testIfRookMoveIsValidWhenRowChange() {

        System.out.print("testIfRookMoveIsValidWhenRowChange - ");
        Rook rookInstance = new Rook(PieceColor.BLACK, 3, 3);
        boolean isMoveValid = rookInstance.isMoveValid(7, 3);

        assertIsTrue(isMoveValid);
    }

    static void testIfRookMoveIsValidWhenColumnChange() {

        System.out.print("testIfRookMoveIsValidWhenColumnChange - ");
        Rook rookInstance = new Rook(PieceColor.BLACK, 3, 3);
        boolean isMoveValid = rookInstance.isMoveValid(3, 7);

        assertIsTrue(isMoveValid);
    }

    static void testIfRookMoveIsNotValidWhenDiagonalMoveIsProcessed() {

        System.out.print("testIfRookMoveIsNotValidWhenDiagonalMoveIsProcessed - ");
        Rook rookInstance = new Rook(PieceColor.BLACK, 3, 3);
        boolean isMoveValid = rookInstance.isMoveValid(4, 4);

        // isMoveValid == false
        // !isMoveValid   !false <=> true
        // String message = (!isMoveValid) ? "Success" : "Fail";
        // System.out.println(message);
        assertIsFalse(isMoveValid);
    }

    public static void run() {

        System.out.println("RookTest : ");
        testIfRookMoveIsValidWhenRowChange();
        testIfRookMoveIsValidWhenColumnChange();
        testIfRookMoveIsNotValidWhenDiagonalMoveIsProcessed();
    }
}