package tests.test;
import pieces.Pawn;
import tests.main.MainTest;

public class PawnTest extends MainTest {

     static void testValidMovementWhenMoveOneSquare() {

        System.out.print("testValidMovementWhenMoveOneSquare - ");
        Pawn testInstance = new Pawn("white", 8, 1);
        boolean isValid = testInstance.isMoveValid(7, 1);
        assertIsTrue(isValid);
    }

    static void testInValidMovementWithColumnChangeForOneSquare() {

        System.out.print("testInValidMovementWithColumnChangeForOneSquare - ");
        Pawn testInstance = new Pawn("white", 8, 1);

        boolean isValid = testInstance.isMoveValid(7, 2);
        assertIsFalse(isValid);
    }

    public static void run() {

        System.out.println("PawnTest : ");
        PawnTest.testInValidMovementWithColumnChangeForOneSquare();
        PawnTest.testValidMovementWhenMoveOneSquare();
    }
}
