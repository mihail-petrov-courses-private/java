package state;

import config.PieceColor;
import meta.PiecePosition;
import pieces.*;

public class GameBoard {

    // Game Board config fields
    public final int BOARD_TILE_SIDE       = 50;
    public final int BOARD_TILE_COUNT      = 10;

    private final int BOARD_MIN_PRIMARY_ROW = 0;
    private final int BOARD_MIN_UTILITY_ROW = 1;
    private final int BOARD_MAX_PRIMARY_ROW = 9;
    private final int BOARD_MAX_UTILITY_ROW = 8;

    // Game Board storage fields
    private Piece[][] matrixCollection;
    private Piece selectedPiece;

    private int moveRow;
    private int moveCol;

    private static GameBoard instance = null;
    public double randomValue = 0;

    // TODO : check if this approche is valid
    private boolean isWhitePieceMove = true;

    private GameBoard() {

        this.randomValue = Math.random();
        this.initGameBoardPieces();
    }

    // Design Pattern
    // * Singleton
    public static GameBoard getInstance() {

        if(instance == null) {
            instance = new GameBoard();
        }

        return instance;
    }

    // Design pattern
    // * Facade pattern
    public void reset() {
        this.initGameBoardPieces();
    }

    public boolean isPieceSelected() {
        return selectedPiece != null;
    }

    public void selectPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public void selectPiece(int row, int col) {
        this.selectedPiece = this.getPiece(row, col);
    }

    public Piece getSelectedPiece() {
        return this.selectedPiece;
    }

    public boolean isPieceAvailable(int row, int col) {
        return getPiece(row, col) != null;
    }

    public Piece getPiece(int row, int col) {
        return matrixCollection[row][col];
    }

    public boolean isWhiteTurn() {
        return this.isWhitePieceMove;
    }

    public boolean isBlackTurn() {
        return !this.isWhitePieceMove;
    }

    public boolean isTurnPieceSelected() {

        if(this.getSelectedPiece() == null) {
            return false;
        }

        return (this.isWhiteTurn()  && this.getSelectedPiece().isPieceColorWhite()) ||
                (this.isBlackTurn() && this.getSelectedPiece().isPieceColorBlack());
    }

    // Refactor to include the piece color
    public void nextTurn() {
        this.isWhitePieceMove = !this.isWhitePieceMove;
    }

    public void nextTurn(Piece piece, PiecePosition newPosition, PiecePosition currentPosition) {

        this.inputBoardTile(newPosition, selectedPiece);
        this.clearBoardTile(currentPosition);

        // reset board state
        this.resetSelectedPiece();

        // change the player of the curent turn
        this.nextTurn();
    }

    private void initGameBoardPieces() {

        // reset the initial matrix
        this.matrixCollection =  new Piece[BOARD_TILE_COUNT][BOARD_TILE_COUNT];

        // positian pieces
        for(int i = 0; i < 5; i++) {
            matrixCollection[BOARD_MIN_UTILITY_ROW][i] = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, i);
            matrixCollection[BOARD_MAX_UTILITY_ROW][i] = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, i);
        }

        matrixCollection[BOARD_MIN_PRIMARY_ROW][0] = new Rook(PieceColor.WHITE    , BOARD_MIN_PRIMARY_ROW, 0);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][1] = new Knight(PieceColor.WHITE  , BOARD_MIN_PRIMARY_ROW, 1);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][2] = new Bishop(PieceColor.WHITE  , BOARD_MIN_PRIMARY_ROW, 2);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][3] = new King(PieceColor.WHITE    , BOARD_MIN_PRIMARY_ROW, 3);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][4] = new Queen(PieceColor.WHITE   , BOARD_MIN_PRIMARY_ROW, 4);

        matrixCollection[BOARD_MAX_PRIMARY_ROW][0] = new Rook(PieceColor.BLACK    , BOARD_MAX_PRIMARY_ROW, 0);
        matrixCollection[BOARD_MAX_PRIMARY_ROW][1] = new Knight(PieceColor.BLACK  , BOARD_MAX_PRIMARY_ROW, 1);
        matrixCollection[BOARD_MAX_PRIMARY_ROW][2] = new Bishop(PieceColor.BLACK  , BOARD_MAX_PRIMARY_ROW, 2);
        matrixCollection[BOARD_MAX_PRIMARY_ROW][3] = new King(PieceColor.BLACK    , BOARD_MAX_PRIMARY_ROW, 3);
        matrixCollection[BOARD_MAX_PRIMARY_ROW][4] = new Queen(PieceColor.BLACK   , BOARD_MAX_PRIMARY_ROW, 4);
    }

    private void inputBoardTile(PiecePosition externalPosition, Piece piece) {
        matrixCollection[externalPosition.getRow()][externalPosition.getCol()] = piece;
    }

    private void clearBoardTile(PiecePosition externalPosition) {
        inputBoardTile(externalPosition, null);
    }

    private void resetSelectedPiece() {
        this.selectedPiece = null;
    }
}