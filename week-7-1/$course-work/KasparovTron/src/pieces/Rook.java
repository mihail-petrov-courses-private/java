package pieces;

public class Rook extends Piece{

    public Rook(String color, int row, int col) {

        super(color, row, col);
        this.power  = 5;
        this.id     = 2;
    }

    public boolean isMoveValid(int row, int col) {

        int moveRowCoefficient = Math.abs(this.row - row);
        int moveColCoefficient = Math.abs(this.col - col);

        return  (moveColCoefficient == 0  && moveRowCoefficient > 0) ||
                (moveRowCoefficient == 0 && moveColCoefficient > 0);
    }

    public void attack(int row, int col) {

    }
}
