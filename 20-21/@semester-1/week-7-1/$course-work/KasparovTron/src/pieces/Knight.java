package pieces;

public class Knight extends Piece {

    public Knight(String color, int row, int col) {

        super(color, row, col);
        this.power  = 5;
        this.id     = 3;
    }

    public boolean isMoveValid(int row, int col) {

        int moveRowCoefficient = Math.abs(this.row - row);
        int moveColCoefficient = Math.abs(this.col - col);

        return  (moveRowCoefficient == 1 && moveColCoefficient == 2) ||
                (moveColCoefficient == 1 && moveRowCoefficient == 2);
    }

    public void attack(int row, int col) {

    }

}
