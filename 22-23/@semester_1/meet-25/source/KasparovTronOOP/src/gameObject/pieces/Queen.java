package gameObject.pieces;

import gameObject.GameObject;
import gameObject.enums.GameColorEnum;

public class Queen extends Piece {

    public Queen(int row, int col, GameColorEnum color) {
        super(row, col, color);
    }

    @Override
    public String getSign() {
        return "Q";
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
