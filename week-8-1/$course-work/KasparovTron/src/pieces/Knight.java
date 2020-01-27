package pieces;

import meta.PiecePosition;

public class Knight extends Piece {

    public Knight(String color, int row, int col) {

        super(color, "Kn", row, col);
        this.power      = 5;
        this.id         = 3;
    }

    public boolean isMoveValid(int row, int col) {

        int moveRowCoefficient = Math.abs(this.row - row);
        int moveColCoefficient = Math.abs(this.col - col);

        return  (moveRowCoefficient == 1 && moveColCoefficient == 2) ||
                (moveColCoefficient == 1 && moveRowCoefficient == 2);
    }


    @Override
    public boolean isMoveValid(PiecePosition externalPosition) {
        return this.isMoveValid(externalPosition.getRow(), externalPosition.getCol());
    }

    public void attack(int row, int col) {

    }

}
