package gameObject.pieces;

import gameObject.GameObject;

public class Pawn extends GameObject {

    public Pawn(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("P");
        this.color  = color;
    }

    public String getSign() {
        return "&";
    }

}
