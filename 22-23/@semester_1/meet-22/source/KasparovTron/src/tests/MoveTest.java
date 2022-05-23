package tests;

import commands.Move;
import config.Game;

public class MoveTest {

    private static int[][] board = {
            { Game.TILE,Game.W_ROOK,Game.W_KNIGHT,Game.W_BISHOP,Game.W_QUEEN, Game.W_KING,Game.W_BISHOP,Game.W_KNIGHT,Game.W_ROOK,Game.TILE  },
            { Game.TILE,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.TILE            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.TILE            },
            { Game.TILE,Game.B_ROOK,Game.B_KNIGHT,Game.B_BISHOP,Game.B_QUEEN,Game.B_KING,Game.B_BISHOP,Game.B_KNIGHT,Game.B_ROOK,Game.TILE   },
    };

    private static int[][] attackBoard = {
            { Game.W_ROOK,Game.TILE     },
            { Game.TILE,Game.TILE       },
            { Game.TILE,Game.TILE       },
            { Game.B_ROOK,Game.TILE     },
    };

    private static int[][] attackBoardFriendly = {
            { Game.W_ROOK,Game.TILE     },
            { Game.TILE,Game.TILE       },
            { Game.TILE,Game.TILE       },
            { Game.W_ROOK,Game.TILE     },
    };

    public static void test() {
        testIfPawnCanMoveCorrectly();
        testIfPawnMoveFail();
        testIfRookCanNotTravelThruTileBlockedByPawn();
        testIfBishopCanNotTraverThrowTileBlockedByPawn();
        testIfRookCanAttackOpponent();
        testIdRookCanNotAttackFriendlyUnit();
    }

    private static void testIfPawnCanMoveCorrectly() {
        boolean isValid =  Move.isMoveValid(board, Game.W_PLAYER, 1, 1, 2, 1);
        assertIsTrue(isValid);
    }

    private static void testIfRookCanNotTravelThruTileBlockedByPawn() {
        boolean isValid = Move.isMoveValid(board, Game.W_PLAYER, 0, 2, 2, 2 );
        assertIsFalse(isValid);;
    }

    private static void testIfPawnMoveFail() {

        boolean isValid =  Move.isMoveValid(board, Game.W_PLAYER, 1, 1, 3, 1);
        assertIsFalse(isValid);
    }

    private static void testIfBishopCanNotTraverThrowTileBlockedByPawn() {
        boolean isValid = Move.isMoveValid(board, Game.W_PLAYER, 0, 3, 2, 1 );
        assertIsFalse(isValid);;
    }

    private static void  testIfRookCanAttackOpponent() {

        boolean isValid = Move.isMoveValid(attackBoard, Game.W_PLAYER, 0,0, 3, 0);
        assertIsTrue(isValid);
    }

    private static void  testIdRookCanNotAttackFriendlyUnit() {

        boolean isValid = Move.isMoveValid(attackBoardFriendly, Game.W_PLAYER, 0,0, 3, 0);
        assertIsFalse(isValid);
    }

    private static void assertIsTrue(boolean isValid) {

        String message = isValid ? "Теста премина успешно" : "Теста се провали";
        System.out.println(message);
    }

    private static void assertIsFalse(boolean isValid) {
        assertIsTrue(!isValid);
    }
}
