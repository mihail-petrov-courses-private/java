package commands;

import config.Game;

public class Move {

    public static boolean isMoveValid(int[][] board, int activePlayer, int fromRow, int fromCol, int toRow, int toCol) {

        int selectedPiece = board[fromRow][fromCol];
        int targetedPiece = board[toRow][toCol];
        boolean isPathBetweenSelectedAndTargetPieceValid = isPathBetweenSelectedAndTargetPieceValid(selectedPiece, board, fromRow, fromCol, toRow, toCol );

        if(selectedPiece == Game.TILE) return false;

        if(targetedPiece != Game.TILE) {
            boolean isAttackMoveValid   = isAttackMoveValid(selectedPiece, fromRow, fromCol, toRow, toCol);
            boolean isTargetPieceValid  = isTargetPieceValid(targetedPiece, activePlayer);

            return  isAttackMoveValid   &&
                    isTargetPieceValid  &&
                    isPathBetweenSelectedAndTargetPieceValid;
        }

        boolean isDirectionMoveValid =  isDirectionMoveValid(selectedPiece, fromRow, fromCol, toRow, toCol);

        return  isDirectionMoveValid   &&
                isPathBetweenSelectedAndTargetPieceValid;
    }

    // логика за управление на атаката
    private static boolean isAttackMoveValid(int selectedPiece, int fromRow, int fromCol, int toRow, int toCol) {

        if(selectedPiece == Game.PAWN   ) return isPawnAttackValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.ROOK   ) return isRookMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.BISHOP ) return isBishopMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.KNIGHT ) return isKnightMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.QUEEN  ) return isQueenMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.KING   ) return isKingMoveValid(fromRow, fromCol, toRow, toCol);
        return false;
    }

    // логика за придвижването към празно поле
    private static boolean isDirectionMoveValid(int selectedPiece, int fromRow, int fromCol, int toRow, int toCol) {

        if(selectedPiece == Game.PAWN   ) return isPawnMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.ROOK   ) return isRookMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.BISHOP ) return isBishopMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.KNIGHT ) return isKnightMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.QUEEN  ) return isQueenMoveValid(fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.KING   ) return isKingMoveValid(fromRow, fromCol, toRow, toCol);
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

    private static boolean isPawnAttackValid(int fromRow, int fromCol, int toRow, int toCol) {

        int rowAttackCoefficient = Math.abs(fromRow - toRow);
        int colAttackCoefficient = Math.abs(fromCol - toCol);

        return (rowAttackCoefficient == colAttackCoefficient) &&
                (rowAttackCoefficient == 1);
    }

    private static boolean isTargetPieceValid(int targetPiece, int activePlayer) {
        return targetPiece * activePlayer < 0;
    }

    private static boolean isPathBetweenSelectedAndTargetPieceValid(int selectedPiece, int[][] board, int fromRow, int fromCol, int toRow, int toCol) {

        if(selectedPiece == Game.PAWN) return true;
        if(selectedPiece == Game.KING) return true;
        if(selectedPiece == Game.ROOK) return isPathBetweenSelectedAndTargetForRookValid(board, fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.BISHOP) return isPathBetweenSelectedAndTargetForBishopValid(board, fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.KNIGHT) return isPathBetweenSelectedAndTargetForKnightValid(board, fromRow, fromCol, toRow, toCol);
        if(selectedPiece == Game.QUEEN) return isPathBetweenSelectedAndTargetForQueenValid(board, fromRow, fromCol, toRow, toCol);
        return false;
    }

    private static boolean isPathBetweenSelectedAndTargetForQueenValid(int[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        return isPathBetweenSelectedAndTargetForRookValid(board, fromRow, fromCol, toRow, toCol) ||
                isPathBetweenSelectedAndTargetForBishopValid(board, fromRow, fromCol, toRow, toCol);
    }

    private static boolean isPathBetweenSelectedAndTargetForKnightValid(int[][] board, int fromRow, int fromCol, int toRow, int toCol) {
        return true;
    }

    private static boolean isPathBetweenSelectedAndTargetForBishopValid(int[][] board, int fromRow, int fromCol, int toRow, int toCol) {

        int maxRow = Math.max(fromRow, toRow);

        int minRow = Math.min(fromRow, toRow);
        int minCol = Math.min(fromCol, toCol);

        for(int index = minRow; index < maxRow; index++) {
            minRow += 1;
            minCol += 1;
            if(board[minRow][minCol] != Game.TILE) return false;
        }

        return true;
    }

    private static boolean isPathBetweenSelectedAndTargetForRookValid(int[][] board, int fromRow, int fromCol, int toRow, int toCol) {

        // обхождаме по колони
        if(fromRow == toRow) {
            int row         = fromRow;
            int startIndex  = Math.min(fromCol, toCol);
            int endIndex    = Math.max(fromCol, toCol);

            for(int index = startIndex; index < endIndex; index++) {
                if(board[row][index] != Game.TILE) return false;
            }
        }

        // обхождаме по редове
        if(fromCol == toCol) {

            int col         = fromCol;
            int startIndex  = Math.min(fromRow, toRow);
            int endIndex    = Math.max(fromRow, toRow);

            for(int index = startIndex + 1; index < endIndex; index++) {
                if(board[index][col] != Game.TILE) return false;
            }
        }
        return true;
    }
}
