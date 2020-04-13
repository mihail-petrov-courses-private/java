package pieces;

public class Bishop extends Piece {

    Bishop(String color, int row, int col) {

        super(color, row, col);
        this.power  = 5;
        this.id     = 4;
    }

    @Override
    public void move(int row, int col) {

    }


    public void attack(int row, int col) {

    }
}
