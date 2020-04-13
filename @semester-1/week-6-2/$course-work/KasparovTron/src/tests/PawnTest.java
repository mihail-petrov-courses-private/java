package tests;

// Import all classess
// import pieces.*;

// Import single class
import pieces.Pawn;

public class PawnTest {

     static void testValidMovementWhenMoveOneSquare() {

        System.out.print("testValidMovementWhenMoveOneSquare - ");
        // Arrange + Act + Assert

        // Arrange
        Pawn testInstance = new Pawn("white", 8, 1);

        // Act
        boolean isValid = testInstance.isMoveValid(7, 1);

        // Assert,
        String message = (isValid) ? "Success" : "Fail";
        System.out.println(message);
    }


    static void testInValidMovementWithColumnChangeForOneSquare() {

        System.out.print("testInValidMovementWithColumnChangeForOneSquare - ");
        Pawn testInstance = new Pawn("white", 8, 1);

        boolean isValid = testInstance.isMoveValid(7, 2);

        String message = (isValid == false) ? "Success" : "Fail";
        System.out.println(message);
    }

    public static void run() {

        PawnTest.testInValidMovementWithColumnChangeForOneSquare();
        PawnTest.testValidMovementWhenMoveOneSquare();
    }
}
