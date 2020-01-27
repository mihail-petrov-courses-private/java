package pieces;

import meta.PiecePosition;

public class Pawn extends Piece implements IHealable, IBlastable {

    public Pawn(String color, int row, int col) {
        super(color, "P", row, col); // Piece

        this.power      = 1;
        this.id         = 1;
    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int moveRowCoeficient = Math.abs(this.row - moveRow); // ?
        int moveColCoeficient = Math.abs(this.col - moveCol); // ?

        return (moveRowCoeficient == 1) &&
                (moveColCoeficient == 0);
    }

    @Override
    public boolean isMoveValid(PiecePosition externalPosition) {
        return this.isMoveValid(externalPosition.getRow(), externalPosition.getCol());
    }

    public void attack(int row, int col) {

    }

    @Override
    public void heal() {

    }

    @Override
    public void blast() {

    }
}