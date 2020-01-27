package meta;

// public -- visible everywere
public class PiecePosition {

    private int row;
    private int col;

    /*private*/ public PiecePosition(int row, int col) {

        // !!!! Notify the user that this behaivior is incorect
        this.setRow(row);
        this.setCol(col);
    }

//    public static PiecePosition createNewObject(int row, int col) {
//        return new PiecePosition(row, col);
//    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setRow(int row) {

        if(row >= 0 && row <= 9) {
            this.row = row;
        }
    }

    public void setCol(int col) {

        if(col >= 0 && col <= 9) {
            this.col = col;
        }
    }
}
