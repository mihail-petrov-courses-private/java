package commands;

import config.Game;

public class Move {

    public static boolean isMoveValid(int selectedPiece, int fromRow, int fromCol, int toRow, int toCol) {

        if(selectedPiece == Game.TILE) return false;

        // TODO : да се върна и да променя - идентификаторите на фигурите
        if(selectedPiece == Game.PAWN) {
            return isPawnMoveValid(fromRow, fromCol, toRow, toCol);
        }

        if(selectedPiece == Game.ROOK) {
            return isRookMoveValid(fromRow, fromCol, toRow, toCol);
        }

        if(selectedPiece == Game.BISHOP) {
            return isBishopMoveValid(fromRow, fromCol, toRow, toCol);
        }

        if(selectedPiece == Game.KNIGHT) {
            return isKnightMoveValid(fromRow, fromCol, toRow, toCol);
        }

        if(selectedPiece == Game.QUEEN) {
            return isQueenMoveValid(fromRow, fromCol, toRow, toCol);
        }

        if(selectedPiece == Game.KING) {
            return isKingMoveValid(fromRow, fromCol, toRow, toCol);
        }

        return false;
    }

    private static boolean isPawnMoveValid(int fromRow, int fromCol, int toRow, int toCol) {

        int rowMovementCoefficient = Math.abs(fromRow - toRow);
        int colMovementCoefficient = fromCol - toCol;

        boolean isRowMovementCorrect = rowMovementCoefficient == 1;
        boolean isColMovementCorrect = colMovementCoefficient == 0;

        return isRowMovementCorrect &&
                isColMovementCorrect;
    }

    private static boolean isRookMoveValid(int fromRow, int fromCol, int toRow, int toCol) {

        // местене по редове - вертикално преместване
        // -> статична колона   - не се променя
        // -> динамичен ред     - променя се с произволен коефициент

        // местене по колони - хоризонтално преместване
        // -> статичен ред      - не се променя
        // -> динамична колона  - променя се с произволен коефициент

        int rowMovementCoefficient = fromRow - toRow;
        int colMovementCoefficient = fromCol - toCol;

        return ((rowMovementCoefficient == 0) && (colMovementCoefficient != 0)) ||
                ((rowMovementCoefficient != 0) && (colMovementCoefficient == 0));
    }

    private static boolean isBishopMoveValid(int fromRow, int fromCol, int toRow, int toCol) {

        int rowMovementCoefficient = Math.abs(fromRow - toRow);
        int colMovementCoefficient = Math.abs(fromCol - toCol);

        return rowMovementCoefficient == colMovementCoefficient;
    }

    private static boolean isKnightMoveValid(int fromRow, int fromCol, int toRow, int toCol) {

        // валидни коефициенти
        // ред -> 1
        // колона -> 2
        // ред -> 2
        // колона -> 1

        int rowMovementCoefficient = Math.abs(fromRow - toRow);
        int colMovementCoefficient = Math.abs(fromCol - toCol);

        return ((rowMovementCoefficient == 1) && (colMovementCoefficient == 2 )) ||
                ((rowMovementCoefficient == 2) && (colMovementCoefficient == 1 ));
    }

    private static boolean isQueenMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        return  isRookMoveValid(fromRow, fromCol, toRow, toCol) ||
                isBishopMoveValid(fromRow, fromCol, toRow, toCol);
    }

    private static boolean isKingMoveValid(int fromRow, int fromCol, int toRow, int toCol) {

        boolean isFreeMoveValid = isQueenMoveValid(fromRow, fromCol, toRow, toCol);

        int rowMovementCoefficient          = Math.abs(fromRow - toRow);
        int colMovementCoefficient          = Math.abs(fromCol - toCol);
        boolean isCoefficientCheckCorrect   = rowMovementCoefficient == 1 ||
                colMovementCoefficient == 1;

        return  isFreeMoveValid &&
                isCoefficientCheckCorrect;
    }
}
