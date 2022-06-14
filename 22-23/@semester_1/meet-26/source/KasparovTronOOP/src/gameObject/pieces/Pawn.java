package gameObject.pieces;

import gameObject.GameObject;
import gameObject.enums.GameColorEnum;

public class Pawn extends Piece {

    public Pawn(int row, int col, GameColorEnum color) {
        super(row, col, color);
    }

    @Override
    public String getSign() {
        return "P";
    }

    public boolean isDirectionMoveValid(int toRow, int toCol) {

        int rowMovementCoefficient = Math.abs(this.getRow() - toRow);
        int colMovementCoefficient = this.getCol() - toCol;

        boolean isRowMovementCorrect = rowMovementCoefficient == 1;
        boolean isColMovementCorrect = colMovementCoefficient == 0;

        return isRowMovementCorrect &&
                isColMovementCorrect;
    }

    @Override
    public boolean isAttackMoveValid(int toRow, int toCol) {

        int rowAttackCoefficient = Math.abs(this.getRow() - toRow);
        int colAttackCoefficient = Math.abs(this.getCol() - toCol);

        return (rowAttackCoefficient == colAttackCoefficient) &&
                (rowAttackCoefficient == 1);
    }
}
