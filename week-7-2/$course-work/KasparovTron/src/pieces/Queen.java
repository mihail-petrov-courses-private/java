package pieces;

public class Queen extends Piece {

    public Queen(String color, int row, int col) {
        super(color,"Q", row, col);
        this.power  = 20;
        this.id     = 5;
        //this.signature = "Q";
    }

    @Override
    public boolean isMoveValid(int row, int col) {

        int moveRowCoefficient = Math.abs(this.row - row);
        int moveColCoefficient = Math.abs(this.col - col);

        return  (moveRowCoefficient == 0 && moveColCoefficient > 0) ||
                ((moveRowCoefficient ==  moveColCoefficient) && (moveRowCoefficient > 0) && (moveColCoefficient > 0)) ||
                (moveColCoefficient == 0 && moveRowCoefficient > 0);
    }

    public void attack(int row, int col) {

    }
}
