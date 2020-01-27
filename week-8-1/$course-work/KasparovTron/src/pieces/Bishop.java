package pieces;

import meta.PiecePosition;

public class Bishop extends Piece {

    public Bishop(String color, int row, int col) {

        super(color,"B", row, col);
        this.power      = 5;
        this.id         = 4;
    }

    public boolean isMoveValid(int row, int col) {

        int moveRowCoefficient = Math.abs(this.row - row);
        int moveColCoefficient = Math.abs(this.col - col);

        return moveRowCoefficient == moveColCoefficient;
    }

    @Override
    public boolean isMoveValid(PiecePosition externalPosition) {
        return this.isMoveValid(externalPosition.getRow(), externalPosition.getCol());
    }

    public void attack(int row, int col) {

    }
}
