package pieces;

import config.PieceColor;
import meta.PiecePosition;

public class Knight extends Piece {

    public Knight(PieceColor color, int row, int col) throws Exception {

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

    public void isAttackValid(int row, int col) {

    }

}
