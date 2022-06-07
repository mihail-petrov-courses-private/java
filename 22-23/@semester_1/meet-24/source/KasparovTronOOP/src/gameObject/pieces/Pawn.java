package gameObject.pieces;

import gameObject.GameObject;

public class Pawn extends Piece {

    public Pawn(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("P");
        this.color  = color;
    }

    public String getSign() {
        return "&";
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
