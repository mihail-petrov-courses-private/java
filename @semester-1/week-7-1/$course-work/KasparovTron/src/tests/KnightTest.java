package tests;

import config.PieceColor;
import pieces.Knight;
import pieces.Piece;

public class KnightTest extends MainTest {

    static void testKnightInstanceOfPiece() {

        System.out.print("testKnightInstanceOfPiece - ");

        Knight knightReference = new Knight(PieceColor.BLACK, 2, 2);
        assertIsTrue(knightReference instanceof Piece);
    }

    static void testKnightMoveOneRowAndTwoCol() {

        System.out.print("testKnightMoveOneRowAndTwoCol - ");
        Piece knightReference = new Knight(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = knightReference.isMoveValid(3, 4);

        assertIsTrue(isMoveValid);
    }

    static void testKnightMoveTwoRowAndOneCol() {
        System.out.print("testKnightMoveTwoRowAndOneCol - ");

        Piece knightReference = new Knight(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = knightReference.isMoveValid(4, 3);

        assertIsTrue(isMoveValid);
    }

    static void testKnightMoveForward() {

        System.out.print("testKnightMoveForward - ");
        Piece knightReference = new Knight(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = knightReference.isMoveValid(4, 2);

        assertIsFalse(isMoveValid);
    }

    public static void run() {

        System.out.println("KnightTest :");
        testKnightInstanceOfPiece();
        testKnightMoveOneRowAndTwoCol();
        testKnightMoveTwoRowAndOneCol();
        testKnightMoveForward();
    }

}
