package gameObject.pieces;

import config.Game;
import gameObject.GameObject;

public class Knight extends Piece {

    public Knight(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("K");
        this.color  = color;
    }

    @Override
    public boolean isDirectionMoveValid(int toRow, int toCol) {

        int rowMovementCoefficient = Math.abs(this.getRow() - toRow);
        int colMovementCoefficient = Math.abs(this.getCol() - toCol);

        return ((rowMovementCoefficient == 1) && (colMovementCoefficient == 2 )) ||
                ((rowMovementCoefficient == 2) && (colMovementCoefficient == 1 ));
    }

    @Override
    public boolean isAttackMoveValid(int toRow, int toCol) {
        return this.isDirectionMoveValid(toRow, toCol);
    }
}
