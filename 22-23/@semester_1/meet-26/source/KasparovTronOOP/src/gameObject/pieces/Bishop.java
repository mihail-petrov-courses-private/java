package gameObject.pieces;

import gameObject.GameObject;
import gameObject.enums.GameColorEnum;

public class Bishop extends Piece {

    public Bishop(int row, int col, GameColorEnum color) {
        super(row, col, color);
    }

    @Override
    public String getSign() {
        return "B";
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
