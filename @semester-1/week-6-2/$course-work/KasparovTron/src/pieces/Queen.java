package pieces;

public class Queen extends Piece {

    Queen(String color, int row, int col) {
        super(color, row, col);
        this.power  = 20;
        this.id     = 5;
    }


    @Override
    public void move(int row, int col) {

    }


    public void attack(int row, int col) {

    }

}
