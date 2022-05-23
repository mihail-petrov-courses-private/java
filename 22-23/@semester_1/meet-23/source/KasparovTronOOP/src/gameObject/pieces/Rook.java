package gameObject.pieces;
import gameObject.GameObject;

public class Rook extends GameObject {
    public Rook(int row, int col, String color) {
        this.setRow(row);
        this.setCol(col);
        this.setSign("R");
        this.color  = color;
    }
}
