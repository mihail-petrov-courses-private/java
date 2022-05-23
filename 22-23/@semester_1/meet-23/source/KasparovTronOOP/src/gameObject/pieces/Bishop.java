package gameObject.pieces;

import gameObject.GameObject;

public class Bishop extends GameObject {

    public Bishop(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("B");
        this.color  = color;
    }
}
