package pieces;

import meta.PiecePosition;

public class Knight extends Piece {

    public Knight(String color, int row, int col) {

        super(color, "Kn", row, col);
        this.power      = 5;
        this.id         = 3;
    }

    public boolean isMoveValid(PiecePosition externalPosition) {

        int moveRowCoefficient = this.getCurrentPosition().getRowCoefficient(externalPosition);
        int moveColCoefficient = this.getCurrentPosition().getColCoefficient(externalPosition);

        return  (moveRowCoefficient == 1 && moveColCoefficient == 2) ||
                (moveColCoefficient == 1 && moveRowCoefficient == 2);
    }

    public void attack(int row, int col) {

    }

}
