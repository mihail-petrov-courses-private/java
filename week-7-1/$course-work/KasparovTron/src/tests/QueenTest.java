package tests;

import config.PieceColor;
import pieces.King;
import pieces.Piece;
import pieces.Queen;

public class QueenTest extends MainTest {

    static void testQueenMoveSingleRow() {

        System.out.print("testQueenMoveSingleRow - ");
        Piece queenReference = new Queen(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = queenReference.isMoveValid(3, 2);
        assertIsTrue(isMoveValid);
    }

    static void testQueenMoveSingleColumn() {

        System.out.print("testQueenMoveSingleColumn - ");
        Piece queenReference = new Queen(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = queenReference.isMoveValid(2, 3);
        assertIsTrue(isMoveValid);
    }

    static void testQueeMoveDiagonaly() {

        System.out.print("testQueeMoveDiagonaly - ");
        Piece queenReference = new Queen(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = queenReference.isMoveValid(3, 3);
        assertIsTrue(isMoveValid);
    }

    public static void run() {

        System.out.println("QueenTest :");
        testQueeMoveDiagonaly();
        testQueenMoveSingleColumn();
        testQueenMoveSingleRow();
    }
}