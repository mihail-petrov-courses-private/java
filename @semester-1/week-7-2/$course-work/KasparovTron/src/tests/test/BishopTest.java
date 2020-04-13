package tests.test;

import config.PieceColor;
import pieces.Bishop;
import tests.main.MainTest;

public class BishopTest extends MainTest {

    static void testCanBishopMoveDiagonaly() {

        System.out.print("testCanBishopMoveDiagonaly - ");
        Bishop bishopReference = new Bishop(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = bishopReference.isMoveValid(5, 5);
        assertIsTrue(isMoveValid);
    }

    static void testCanotBishopMoveJustOneRowUp() {

        System.out.print("testCanotBishopMoveJustOneRowUp - ");
        Bishop bishopReference = new Bishop(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = bishopReference.isMoveValid(3, 2);
        assertIsFalse(isMoveValid);
    }

    public static void run() {

        System.out.println("BishopTest :");
        testCanBishopMoveDiagonaly();
        testCanotBishopMoveJustOneRowUp();
    }
}
