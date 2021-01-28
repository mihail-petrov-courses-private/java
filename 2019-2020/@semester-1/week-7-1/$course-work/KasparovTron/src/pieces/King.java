package pieces;

public class King extends Piece {

    public King(String color, int row, int col) {
        super(color, row, col);

        this.power  = 10;
        this.id     = 4;
    }

    @Override
    public boolean isMoveValid(int row, int col) {

        int moveRowCoefficient = Math.abs(this.row - row);
        int moveColCoefficient = Math.abs(this.col - col);

        return  (moveRowCoefficient == 0 && moveColCoefficient == 1) ||
                (moveRowCoefficient == 1 && moveColCoefficient == 1) ||
                (moveColCoefficient == 0 && moveRowCoefficient == 1);
    }

    public void attack(int row, int col) {

    }
}
