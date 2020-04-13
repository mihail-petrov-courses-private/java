package pieces;

public abstract class Piece {

    String color;
    int power;
    int id;

    int row;
    int col;

    public Piece(String color, int row, int col) {

        this.color  = color;
        this.row    = row;
        this.col    = col;
    }

    public abstract boolean isMoveValid(int row, int col);

    public void move(int row, int col) {

        if(this.isMoveValid(row, col)) {

            this.row = row;
            this.col = col;
        }
    }

    public abstract void attack(int row, int col);
}
