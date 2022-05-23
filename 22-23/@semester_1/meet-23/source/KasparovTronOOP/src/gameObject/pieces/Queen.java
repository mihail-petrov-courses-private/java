package gameObject.pieces;

import gameObject.GameObject;

public class Queen extends GameObject {

    public Queen(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("Q");
        this.color  = color;
    }
}
