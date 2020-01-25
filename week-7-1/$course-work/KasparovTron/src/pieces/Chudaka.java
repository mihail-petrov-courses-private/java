package pieces;

public class Chudaka extends BlastPiece implements IHealable {

    public Chudaka(String color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isMoveValid(int row, int col) {
        return false;
    }

    @Override
    public void move(int row, int col) {

    }

    @Override
    public void attack(int row, int col) {

    }

    @Override
    public void blast(int row, int col) {

    }

    @Override
    public void heal() {

    }
}
