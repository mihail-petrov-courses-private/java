package pieces;

public class Rook extends Piece{

    Rook(String color, int row, int col) {


        super(color, row, col);
        this.power  = 5;
        this.id     = 2;
    }


    @Override
    public void move(int row, int col) {

    }


    public void attack(int row, int col) {

    }
}
