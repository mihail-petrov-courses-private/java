package pieces;

public class Pawn extends Piece implements IHealable{

    // field variables
    // String color; // white / black
    // int power;
    // int id;

    // int row;
    // int col;

    // pieces.Pawn(String inputColor) {
    public Pawn(String color, int row, int col) {
        super(color, row, col); // Piece

        // get field variable with (this.)
        // this.color = color;
        this.power = 1;
        this.id    = 1;

        // initialise pieces.Pawn coordinates
        // this.row = row;
        // this.col = col;

        // without overshadowing
        // color = inputColor
    }
//
//    public Pawn(String color) {
//        // super(color, 0, 0);
//
//        this.color = color;
//        this.power = 1;
//        this.id = 1;
//
//        this.row = 0;
//        this.col = 0;
//    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int moveRowCoeficient = this.row - moveRow; // ?
        int moveColCoeficient = this.col - moveCol; // ?

        return (moveRowCoeficient == 1) &&
                (moveColCoeficient == 0);
    }

    public void move(int moveRow, int moveCol) {

        if(isMoveValid(moveRow, moveCol)) {

            this.row = moveRow;
            this.col = moveCol;
        }
    }

    public void attack(int row, int col) {

    }


    public void getInfo() {
        System.out.print("Pawn specific info");
    }

    @Override
    public void heal() {

    }
}