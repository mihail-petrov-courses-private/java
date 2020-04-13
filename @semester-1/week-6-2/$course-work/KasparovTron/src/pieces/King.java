package pieces;

public class King extends Piece {

    King(String color,int row, int col) {
        super(color, row, col);

        this.power  = 10;
        this.id     = 4;
    }


    @Override
    public void move(int row, int col) {

    }


    public void attack(int row, int col) {

    }
}
