package gameObject.pieces;

import config.Game;
import gameObject.GameObject;

public class Knight extends GameObject {

    public Knight(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("K");
        this.color  = color;
    }
}
