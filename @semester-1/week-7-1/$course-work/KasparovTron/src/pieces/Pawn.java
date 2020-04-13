package pieces;

public class Pawn extends Piece implements IHealable{

    public Pawn(String color, int row, int col) {
        super(color, row, col); // Piece

        this.power = 1;
        this.id    = 1;
    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int moveRowCoeficient = this.row - moveRow; // ?
        int moveColCoeficient = this.col - moveCol; // ?

        return (moveRowCoeficient == 1) &&
                (moveColCoeficient == 0);
    }

    public void attack(int row, int col) {

    }

    @Override
    public void heal() {

    }
}