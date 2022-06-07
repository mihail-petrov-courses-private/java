package gameObject.pieces;
import gameObject.GameObject;

public class Rook extends Piece {
    public Rook(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("R");
        this.color  = color;
    }

    @Override
    public boolean isDirectionMoveValid(int toRow, int toCol) {
        return this.isLineMoveValid(toRow, toCol);
    }

    @Override
    public boolean isAttackMoveValid(int toRow, int toCol) {
        return this.isDirectionMoveValid(toRow, toCol);
    }
}
