package pieces;

public class Pawn {

    // field variables
    String color; // white / black
    int power;
    int id;

    int row;
    int col;

    // pieces.Pawn(String inputColor) {
    public Pawn(String color, int row, int col) {

        // get field variable with (this.)
        this.color = color;
        this.power = 1;
        this.id    = 1;

        // initialise pieces.Pawn coordinates
        this.row = row;
        this.col = col;

        // without overshadowing
        // color = inputColor
    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int moveRowCoeficient = this.row - moveRow; // ?
        int moveColCoeficient = this.col - moveCol; // ?

        return (moveRowCoeficient == 1) &&
                (moveColCoeficient == 0);
    }

    void move(int moveRow, int moveCol) {

        if(isMoveValid(moveRow, moveCol)) {

            this.row = moveRow;
            this.col = moveCol;
        }
    }

    void attack() {

    }
}