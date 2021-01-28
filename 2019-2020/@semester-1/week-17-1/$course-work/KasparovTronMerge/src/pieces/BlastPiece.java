package pieces;

import config.PieceColor;

public abstract class BlastPiece extends Piece {

    public BlastPiece(PieceColor color, String signature, int row, int col) {
        super(color, signature, row, col);
    }

    public abstract void blast(int row, int col);
}
