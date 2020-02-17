package pieces;

import config.PieceColor;
import meta.PiecePosition;

public abstract class Piece {

    // protected String color;
    protected PieceColor pieceColor;

    protected String signature;
    protected int power;

    protected int id;

    // public String errorCode;
    // protected int row;
    // protected int col;

    protected PiecePosition position;

        // old school constructor
//    public Piece(String color, String signature, int row, int col) throws Exception {
//
//        // this.color      = color;
//        this.setColor(color);
////        if(this.errorCode == "INVALID_INPUT_PARAM_FOR_COLOR") {
////            System.out.println("Invalid object");
////        }
//        this.signature  = signature;
//        this.position   = new PiecePosition(row, col);
//        // this.row        = row;
//        // this.col        = col;
//    }

    // enum constructor
    public Piece(PieceColor color, String signature, int row, int col) throws Exception {

        this.setColor(color);
        //this.pieceColor = color;
        this.signature = signature;
        // this.position = new PiecePosition(row, col);
        this.setCurrentPosition(new PiecePosition(row, col));
    }

//
//    public Piece(String color, String signature, PiecePosition position) throws Exception {
//
//        //this.color      = color;
//        this.setColor(color);
//
//        this.signature  = signature;
//        this.position   = position;
//        // this.row        = this.position.getRow();
//        // this.col        = this.position.getCol();
//    }

    // enum constructor
    public Piece(PieceColor color, String signature, PiecePosition position) {

        //this.pieceColor = color;
        this.setColor(color);
        this.signature  = signature;
        //this.position   = position;
        this.setCurrentPosition(position);
    }

    public void setRow(int row) throws Exception {
        this.position.setRow(row);
    }

    public int getRow() {
        return this.position.getRow();
    }

    public void setCol(int col) throws Exception {
        this.position.setCol(col);
    }

    public int getCol() {
        return this.position.getCol();
    }

    public void setCurrentPosition(PiecePosition position) {
        this.position = position;
    }

    public PiecePosition getCurrentPosition() {
        return this.position;
    }

    // color related activities
//    public void setColor(String color) throws Exception {
//
//        if(color.equals(PieceColor.WHITE) || color.equals(PieceColor.BLACK)) {
//            this.color = color;
//        }
//        else {
//            throw new Exception("INVALID_INPUT_PARAM_FOR_COLOR");
//        }
//
//        // this.errorCode = "INVALID_INPUT_PARAM_FOR_COLOR";
//    }

    public void setColor(PieceColor color) {
        this.pieceColor = color;
    }

    public PieceColor getColor() {
        return this.pieceColor;
    }

    // public abstract boolean isMoveValid(int row, int col);
    public abstract boolean isMoveValid(PiecePosition externalPosition);

    public void move(PiecePosition externalPosition) throws Exception {

        // if(this.isMoveValid(externalPosition.getRow(), externalPosition.getCol())) {
        if(this.isMoveValid(externalPosition)) {

            this.position.setRow(externalPosition.getRow());
            this.position.setCol(externalPosition.getCol());
        }
    }

    public String getSignature() throws Exception {

        if(this.pieceColor == PieceColor.WHITE) {
            return ("w" + this.signature);
        }

        if(this.pieceColor == PieceColor.BLACK) {
            return ("b" + this.signature);
        }

        throw new Exception("INVALID_PIECE_COLOR : Except only PieceColor.WHITE / PieceCOlor.BLACK");


//        if(this.color.equals(PieceColor.WHITE)) {
//            return ("w" + this.signature);
//        }
//
//        return ("b" + this.signature);
    }

    public abstract void attack(int row, int col);
}
