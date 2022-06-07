package gameObject.pieces;

import gameObject.GameObject;

public class Queen extends Piece {

    public Queen(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("Q");
        this.color  = color;
    }

    @Override
    public boolean isDirectionMoveValid(int toRow, int toCol) {
        return  isLineMoveValid(toRow, toCol) ||
                isDiagonalMoveValid(toRow, toCol);
    }

    @Override
    public boolean isAttackMoveValid(int toRow, int toCol) {
        return this.isDirectionMoveValid(toRow, toCol);
    }
}
