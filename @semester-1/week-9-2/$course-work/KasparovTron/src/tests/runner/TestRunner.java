package tests.runner;

import tests.test.*;

public class TestRunner {

    public static void run() {

        PawnTest.run();
        RookTest.run();
        BishopTest.run();
        KnightTest.run();
        KingTest.run();
        QueenTest.run();
    }
}
