import pieces.Knight;
import tests.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to KASPAROV-TRON 101");

        PawnTest.run();
        RookTest.run();
        BishopTest.run();
        KnightTest.run();
        KingTest.run();
        QueenTest.run();
    }
}