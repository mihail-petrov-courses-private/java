package pieces;

import config.PieceColor;
import meta.PiecePosition;

public class Queen extends Piece {

    public Queen(PieceColor color, int row, int col) {
        super(color,"Q", row, col);
        this.power  = 20;
        this.id     = 5;
        //this.signature = "Q";
    }

    @Override
    public boolean isMoveValid(PiecePosition externalPosition) {

        int moveRowCoefficient = this.getCurrentPosition().getRowCoefficient(externalPosition);
        int moveColCoefficient = this.getCurrentPosition().getColCoefficient(externalPosition);

        return  (moveRowCoefficient == 0 && moveColCoefficient > 0) ||
                ((moveRowCoefficient ==  moveColCoefficient) && (moveRowCoefficient > 0) && (moveColCoefficient > 0)) ||
                (moveColCoefficient == 0 && moveRowCoefficient > 0);
    }

    public boolean isAttackValid(PiecePosition externalPosition) {
        return isMoveValid(externalPosition);
    }
}


// * isAttackValid  -> true | false
// * isMoveValid    -> true