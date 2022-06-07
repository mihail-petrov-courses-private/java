package gameObject;

public abstract class GameObject {

    protected int row;
    protected int col;
    protected String color;
    protected String sign = "P";

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

    public String getColor() {
        return color;
    }

    public String getSign() {
        return sign;
    }

    public void setPosition(int row, int col) {
        this.setRow(row);
        this.setCol(col);
    }

    protected void setSign(String sign) {
        this.sign = sign;
    }
}
