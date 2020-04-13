package pieces;

import config.PieceColor;
import meta.PiecePosition;

public abstract class Piece {

    protected PieceColor pieceColor;

    protected String signature;
    protected int power;

    protected int id;

    protected PiecePosition position;

    // enum constructor
    public Piece(PieceColor color, String signature, int row, int col) {

        this.setColor(color);
        this.signature = signature;
        this.setCurrentPosition(new PiecePosition(row, col));
    }

    // enum constructor
    public Piece(PieceColor color, String signature, PiecePosition position) {

        this.setColor(color);
        this.signature  = signature;
        this.setCurrentPosition(position);
    }

    public void setRow(int row){
        this.position.setRow(row);
    }

    public int getRow() {
        return this.position.getRow();
    }

    public void setCol(int col) {
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

    public void setColor(PieceColor color) {
        this.pieceColor = color;
    }

    public PieceColor getColor() {
        return this.pieceColor;
    }

    public boolean isPieceColorWhite() {
        return this.getColor() == PieceColor.WHITE;
    }

    public boolean isPieceColorBlack() {
        return this.getColor() == PieceColor.BLACK;
    }

    public void move(PiecePosition externalPosition) {

        if(this.isMoveValid(externalPosition)) {

            this.position.setRow(externalPosition.getRow());
            this.position.setCol(externalPosition.getCol());
        }
    }

    public String getSignature() {

        if(this.pieceColor == PieceColor.WHITE) {
            return ("w" + this.signature);
        }

        if(this.pieceColor == PieceColor.BLACK) {
            return ("b" + this.signature);
        }

        throw new RuntimeException("INVALID_PIECE_COLOR : Except only PieceColor.WHITE / PieceCOlor.BLACK");
    }

    public abstract boolean isMoveValid(PiecePosition externalPosition);

    public abstract boolean isAttackValid(PiecePosition externalPosition);
}
