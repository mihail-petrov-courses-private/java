package tests.test;
import meta.PiecePosition;
import pieces.Pawn;
import tests.main.MainTest;

public class PawnTest extends MainTest {

     static void testValidMovementWhenMoveOneSquare() {

        System.out.print("testValidMovementWhenMoveOneSquare - ");
        Pawn testInstance = new Pawn("white", 8, 1);
        boolean isValid = testInstance.isMoveValid(new PiecePosition(7,  1));
        assertIsTrue(isValid);
    }

    static void testValidMovementWhenMoveOneSquareInOpossiteDirection() {

        System.out.print("testValidMovementWhenMoveOneSquareInOpossiteDirection - ");
        Pawn testInstance = new Pawn("white", 1, 1);
        boolean isValid = testInstance.isMoveValid(new PiecePosition(2,  1));
        assertIsTrue(isValid);
    }


    static void testInValidMovementWithColumnChangeForOneSquare() {

        System.out.print("testInValidMovementWithColumnChangeForOneSquare - ");
        Pawn testInstance = new Pawn("white", 8, 1);

        boolean isValid = testInstance.isMoveValid(new PiecePosition(7,  2));
        assertIsFalse(isValid);
    }

    public static void run() {

        System.out.println("PawnTest : ");
        PawnTest.testInValidMovementWithColumnChangeForOneSquare();
        testValidMovementWhenMoveOneSquareInOpossiteDirection();
        PawnTest.testValidMovementWhenMoveOneSquare();
    }
}
