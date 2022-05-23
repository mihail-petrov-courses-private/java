package gameObject.tiles;

import config.Game;
import gameObject.GameObject;

public class Tile extends GameObject {
    public Tile(int row, int col) {
        this.col = col;
        this.row = row;
        this.setSign("X");
    }
}
