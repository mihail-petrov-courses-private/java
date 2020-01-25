package pieces;

public abstract class BlastPiece extends Piece {

    public BlastPiece(String color, int row, int col) {
        super(color, row, col);
    }

    public abstract void blast(int row, int col);
}
