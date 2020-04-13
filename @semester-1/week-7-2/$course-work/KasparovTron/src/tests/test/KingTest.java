package tests.test;

import config.PieceColor;
import pieces.King;
import pieces.Piece;
import tests.main.MainTest;

public class KingTest extends MainTest {

    static void testKingMoveSingleRow() {

        System.out.print("testKingMoveSingleRow - ");
        Piece kingReference = new King(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = kingReference.isMoveValid(3, 2);
        assertIsTrue(isMoveValid);
    }

    static void testKingMoveSingleColumn() {

        System.out.print("testKingMoveSingleColumn - ");
        Piece kingReference = new King(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = kingReference.isMoveValid(2, 3);
        assertIsTrue(isMoveValid);
    }

    static void testKingMoveDiagonaly() {

        System.out.print("testKingMoveDiagonaly - ");
        Piece kingReference = new King(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = kingReference.isMoveValid(3, 3);
        assertIsTrue(isMoveValid);
    }

    static void testFailKingMoveTwoSquares() {

        System.out.print("testKingMoveTwoSquares - ");
        Piece kingReference = new King(PieceColor.BLACK, 2, 2);
        boolean isMoveInValid = kingReference.isMoveValid(4, 2);
        assertIsFalse(isMoveInValid);
    }

    public static void run() {

        System.out.println("KingTest :");
        testFailKingMoveTwoSquares();
        testKingMoveDiagonaly();
        testKingMoveSingleColumn();
        testKingMoveSingleRow();
    }
}