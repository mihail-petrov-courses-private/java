package gameObject.pieces;

import gameObject.GameObject;

public class King extends GameObject {
    public King(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("Kn");
        this.color  = color;
    }
}
