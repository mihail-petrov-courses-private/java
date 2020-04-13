package pieces;

import config.PieceColor;
import meta.PiecePosition;
import pieces.contracts.IHealable;

public class Chudaka extends BlastPiece implements IHealable {

    public Chudaka(PieceColor color, int row, int col) {
        super(color, "Ch", row, col);
    }

    @Override
    public boolean isMoveValid(PiecePosition externalPosition) {
        return false;
    }

    @Override
    public boolean isAttackValid(PiecePosition externalPosition) {
        return isMoveValid(externalPosition);
    }

    @Override
    public void blast(int row, int col) {

    }

    @Override
    public void heal() {

    }
}
