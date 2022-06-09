package gameObject;

import gameObject.enums.GameColorEnum;

public abstract class GameObject {

    protected int row;
    protected int col;
    protected GameColorEnum color;

    public abstract String getSign();

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public GameColorEnum getColor() {
        return color;
    }

    public void setPosition(int row, int col) {
        this.setRow(row);
        this.setCol(col);
    }
}
