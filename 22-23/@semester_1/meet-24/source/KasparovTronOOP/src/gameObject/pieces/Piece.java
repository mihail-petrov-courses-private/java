package gameObject.pieces;

import gameObject.GameObject;

public abstract class Piece extends GameObject {

    protected boolean isLineMoveValid(int toRow, int toCol) {

        int rowMovementCoefficient = this.getRow() - toRow;
        int colMovementCoefficient = this.getCol() - toCol;

        return ((rowMovementCoefficient == 0) && (colMovementCoefficient != 0)) ||
                ((rowMovementCoefficient != 0) && (colMovementCoefficient == 0));
    }

    protected boolean isDiagonalMoveValid(int toRow, int toCol) {

        int rowMovementCoefficient = Math.abs(this.getRow() - toRow);
        int colMovementCoefficient = Math.abs(this.getCol() - toCol);

        return rowMovementCoefficient == colMovementCoefficient;
    }

    public abstract boolean isDirectionMoveValid(int toRow, int toCol);

    public abstract boolean isAttackMoveValid(int roRow, int toCol);
}
