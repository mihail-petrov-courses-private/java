package gameObject.pieces;
import gameObject.GameObject;
import gameObject.enums.GameColorEnum;

public class Rook extends Piece {
    public Rook(int row, int col, GameColorEnum color) {
        super(row, col, color);
    }

    @Override
    public String getSign() {
        return "R";
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
