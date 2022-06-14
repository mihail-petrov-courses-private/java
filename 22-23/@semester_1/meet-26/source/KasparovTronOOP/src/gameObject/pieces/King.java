package gameObject.pieces;

import gameObject.GameObject;
import gameObject.enums.GameColorEnum;

public class King extends Piece {
    public King(int row, int col, GameColorEnum color) {
        super(row, col, color);
    }

    @Override
    public String getSign() {
        return "Kn";
    }

    @Override
    public boolean isDirectionMoveValid(int toRow, int toCol) {

        boolean isFreeMoveValid =   isLineMoveValid(toRow, toCol) ||
                                    isDiagonalMoveValid(toRow, toCol);

        int rowMovementCoefficient          = Math.abs(this.getRow() - toRow);
        int colMovementCoefficient          = Math.abs(this.getCol() - toCol);
        boolean isCoefficientCheckCorrect   = rowMovementCoefficient == 1 ||
                colMovementCoefficient == 1;

        return  isFreeMoveValid &&
                isCoefficientCheckCorrect;
    }


    @Override
    public boolean isAttackMoveValid(int toRow, int toCol) {
        return this.isDirectionMoveValid(toRow, toCol);
    }
}