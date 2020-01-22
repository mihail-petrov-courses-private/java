package pieces;

public abstract class Piece {

    public String color;
    public int power;
    public int id;

    public int row;
    public int col;

//    public Piece() {
//        this.power = 25;
//    }

//    public Piece(String color) {
//
//    }

    public Piece(String color, int row, int col) {

        this.color  = color;
        this.row    = row;
        this.col    = col;
    }

    public abstract void move(int row, int col);

    public abstract void attack(int row, int col);

    // It does not belong to this general class
    // public abstract void blast(int row, int col);

    public void getInfo() {

        System.out.println("Row -> " + this.row);
        System.out.println("Col -> " + this.col);
    }
}
