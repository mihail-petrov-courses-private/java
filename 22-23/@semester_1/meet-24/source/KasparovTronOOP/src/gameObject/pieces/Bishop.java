package gameObject.pieces;

import gameObject.GameObject;

public class Bishop extends Piece {

    public Bishop(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("B");
        this.color  = color;
    }

    @Override
    public boolean isDirectionMoveValid(int toRow, int toCol) {
        return this.isDiagonalMoveValid(toRow, toCol);
    }

    @Override
    public boolean isAttackMoveValid(int toRow, int toCol) {
        return this.isDirectionMoveValid(toRow, toCol);
    }
}
