package pieces;

import config.PieceColor;
import meta.PiecePosition;

public class King extends Piece {

    public King(PieceColor color, int row, int col) {
        super(color,"K", row, col);

        this.power      = 10;
        this.id         = 4;
    }

    @Override
    public boolean isMoveValid(PiecePosition externalPosition) {

        int moveRowCoefficient = this.getCurrentPosition().getRowCoefficient(externalPosition);
        int moveColCoefficient = this.getCurrentPosition().getColCoefficient(externalPosition);

        return  (moveRowCoefficient == 0 && moveColCoefficient == 1) ||
                (moveRowCoefficient == 1 && moveColCoefficient == 1) ||
                (moveColCoefficient == 0 && moveRowCoefficient == 1);
    }

    public boolean isAttackValid(PiecePosition externalPosition) {
        return isMoveValid(externalPosition);
    }
}
