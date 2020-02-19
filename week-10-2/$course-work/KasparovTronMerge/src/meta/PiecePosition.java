package meta;

public class PiecePosition {

    private int row;
    private int col;

    public PiecePosition(int row, int col) throws Exception {
        this.setRow(row);
        this.setCol(col);
    }


    public PiecePosition(PiecePosition externalPosition) throws Exception {

        this.setRow(externalPosition.getRow());
        this.setCol(externalPosition.getCol());

        // use internal constructor
        // super(externalPosition.getRow(), externalPosition.getCol());
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setRow(int row) throws Exception {

        if(row < 0 || row > 9) {
            throw new Exception("INVALID_ROW_INPUT :  You must input row and col between 0 and 9");
        }

        this.row = row;
//
//        if(row >= 0 && row <= 9) {
//            this.row = row;
//        }
//        else {
//            throw new Exception("INVALID_ROW_INPUT :  You must input row and col between 0 and 9");
//        }
    }

    public void setCol(int col) throws Exception {

        if(row < 0 || row > 9) {
            throw new Exception("INVALID_COL_INPUT :  You must input row and col between 0 and 9");
        }

        this.col = col;
    }

    public boolean areRowEqual(PiecePosition externalPosition) {
        return this.getRow() == externalPosition.getRow();
    }

    public boolean areColEqual(PiecePosition externalPosition) {
        return this.getCol() == externalPosition.getCol();
    }

    public int getRowCoefficient(PiecePosition externalPosition) {
        return Math.abs(this.subRow(externalPosition));
    }

    public int getColCoefficient(PiecePosition externalPosition) {
        return Math.abs(this.subCol(externalPosition));
    }

    private int subRow(PiecePosition externalPosition) {
        return this.getRow() - externalPosition.getRow();
    }

    private int subCol(PiecePosition externalPosition) {
        return this.getCol() - externalPosition.getCol();
    }
}
