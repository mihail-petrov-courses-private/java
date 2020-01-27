package pieces;

import config.PieceColor;
import meta.PiecePosition;

public abstract class Piece {

    protected String color;
    protected String signature;
    protected int power;

    protected int id;

    protected int row;
    protected int col;

    protected PiecePosition position;

    public Piece(String color, String signature, int row, int col) {

        this.color      = color;
        this.signature  = signature;
        this.position   = new PiecePosition(row, col);
    }

    public Piece(String color, String signature, PiecePosition position) {

        this.color      = color;
        this.signature  = signature;
        this.position   = position;
    }

    public int getRow() {
        return this.position.getRow();
    }

    public int getCol() {
        return this.position.getCol();
    }

    public PiecePosition getCurrentPosition() {
        return this.position;
    }

    public abstract boolean isMoveValid(int row, int col);
    public abstract boolean isMoveValid(PiecePosition externalPosition);

    public void move(int row, int col) {

        if(this.isMoveValid(row, col)) {

            this.row = row;
            this.col = col;
        }
    }
    public void move(PiecePosition externalPosition) {

        if(this.isMoveValid(externalPosition.getRow(), externalPosition.getCol())) {

            this.position.setRow(externalPosition.getRow());
            this.position.setRow(externalPosition.getCol());
        }
    }

    public String getSignature() {

        if(this.color.equals(PieceColor.WHITE)) {
            return ("w" + this.signature);
        }

        return ("b" + this.signature);
    }

    public abstract void attack(int row, int col);
}
