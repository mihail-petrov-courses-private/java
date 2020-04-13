package pieces;

import config.PieceColor;

public abstract class Piece {

    String color;
    String signature;
    public int power;

    int id;

    public int row;
    public int col;

    public Piece(String color, String signature, int row, int col) {

        this.color      = color;
        this.signature  = signature;
        this.row        = row;
        this.col        = col;
    }

    public abstract boolean isMoveValid(int row, int col);

    public void move(int row, int col) {

        if(this.isMoveValid(row, col)) {

            this.row = row;
            this.col = col;
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
