package tests.test;

import config.PieceColor;
import meta.PiecePosition;
import pieces.Bishop;
import tests.main.MainTest;

public class BishopTest extends MainTest {

    public static void run() {

        System.out.println("BishopTest :");
        testCanBishopMoveDiagonaly();
        testCanotBishopMoveJustOneRowUp();
    }

    private static void testCanBishopMoveDiagonaly() {

        System.out.print("testCanBishopMoveDiagonaly - ");
        Bishop bishopReference = new Bishop(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = bishopReference.isMoveValid(new PiecePosition(5,  5));
        assertIsTrue(isMoveValid);
    }

    private static void testCanotBishopMoveJustOneRowUp() {

        System.out.print("testCanotBishopMoveJustOneRowUp - ");
        Bishop bishopReference = new Bishop(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = bishopReference.isMoveValid(new PiecePosition(3,  2));
        assertIsFalse(isMoveValid);
    }
}
