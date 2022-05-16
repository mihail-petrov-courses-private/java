package tests.test;

import config.PieceColor;
import meta.PiecePosition;
import pieces.Knight;
import pieces.Piece;
import tests.main.MainTest;

public class KnightTest extends MainTest {

    static void testKnightInstanceOfPiece() {

        System.out.print("testKnightInstanceOfPiece - ");

        Knight knightReference = new Knight(PieceColor.BLACK, 2, 2);
        assertIsTrue(knightReference instanceof Piece);
    }

    static void testKnightMoveOneRowAndTwoCol() {

        System.out.print("testKnightMoveOneRowAndTwoCol - ");
        Piece knightReference = new Knight(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = knightReference.isMoveValid(new PiecePosition(3,  4));

        assertIsTrue(isMoveValid);
    }

    static void testKnightMoveTwoRowAndOneCol() {
        System.out.print("testKnightMoveTwoRowAndOneCol - ");

        Piece knightReference = new Knight(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = knightReference.isMoveValid(new PiecePosition(4,  3));

        assertIsTrue(isMoveValid);
    }

    static void testKnightMoveForward() {

        System.out.print("testKnightMoveForward - ");
        Piece knightReference = new Knight(PieceColor.BLACK, 2, 2);
        boolean isMoveValid = knightReference.isMoveValid(new PiecePosition(4,  2));

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
