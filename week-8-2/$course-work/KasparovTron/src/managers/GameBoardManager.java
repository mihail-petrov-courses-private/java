package managers;

import config.PieceColor;
import meta.PiecePosition;
import pieces.*;

public class GameBoardManager {

    static Piece[][] matrixCollection = new Piece[10][10];

    static final int BOARD_MIN_PRIMARY_ROW = 0;
    static final int BOARD_MIN_UTILITY_ROW = 1;

    static final int BOARD_MAX_PRIMARY_ROW = 9;
    static final int BOARD_MAX_UTILITY_ROW = 8;

    public static Piece selectedPiece;

    // Bad design
    public static void init() {

        matrixCollection[BOARD_MIN_UTILITY_ROW][0] = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 0);
        matrixCollection[BOARD_MIN_UTILITY_ROW][1] = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 1);
        matrixCollection[BOARD_MIN_UTILITY_ROW][2] = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 2);
        matrixCollection[BOARD_MIN_UTILITY_ROW][3] = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 3);
        matrixCollection[BOARD_MIN_UTILITY_ROW][4] = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 4);

        matrixCollection[BOARD_MIN_PRIMARY_ROW][0] = new Rook(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 0);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][1] = new Knight(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 1);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][2] = new Bishop(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 2);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][3] = new King(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 3);
        matrixCollection[BOARD_MIN_PRIMARY_ROW][4] = new Queen(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 4);

        matrixCollection[BOARD_MAX_UTILITY_ROW][0] = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 0);
        matrixCollection[BOARD_MAX_UTILITY_ROW][1] = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 1);
        matrixCollection[BOARD_MAX_UTILITY_ROW][2] = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 2);
        matrixCollection[BOARD_MAX_UTILITY_ROW][3] = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 3);
        matrixCollection[BOARD_MAX_UTILITY_ROW][4] = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 4);

        matrixCollection[BOARD_MAX_PRIMARY_ROW][0] = new Rook(PieceColor.BLACK    , BOARD_MAX_PRIMARY_ROW, 0);;
        matrixCollection[BOARD_MAX_PRIMARY_ROW][1] = new Knight(PieceColor.BLACK  , BOARD_MAX_PRIMARY_ROW, 1);
        matrixCollection[BOARD_MAX_PRIMARY_ROW][2] = new Bishop(PieceColor.BLACK  , BOARD_MAX_PRIMARY_ROW, 2);
        matrixCollection[BOARD_MAX_PRIMARY_ROW][3] = new King(PieceColor.BLACK    , BOARD_MAX_PRIMARY_ROW, 3);
        matrixCollection[BOARD_MAX_PRIMARY_ROW][4] = new Queen(PieceColor.BLACK   , BOARD_MAX_PRIMARY_ROW, 4);
    }

    //public static boolean isPieceAvailable(int selectRow, int selectCol) {
    public static boolean isPieceAvailable(PiecePosition externalPosition) {

        //Piece selectedPiece = matrixCollection[selectRow][selectCol];
        Piece selectedPiece = getBoardTile(externalPosition);
        return (selectedPiece != null);
    }

    public static void pickPiece(PiecePosition externalPosition) {
        selectedPiece = getBoardTile(externalPosition);
    }

    public static boolean isMovePossible(PiecePosition externalPosition) {
        return selectedPiece.isMoveValid(externalPosition);
    }

    //public static void move(int moveRow, int moveCol) {
    public static void move(PiecePosition externalPosition) {

        // int currentRow              = selectedPiece.getRow();
        // int currentCol              = selectedPiece.getCol();
        PiecePosition currentPosition   = selectedPiece.getCurrentPosition();

        // selectedPiece.move(moveRow, moveCol);
        selectedPiece.move(externalPosition);

        // Remark use PiecePosition object - experiment with different methods
        // matrixCollection[moveRow][moveCol] = selectedPiece;
        inputBoardTile(externalPosition, selectedPiece);
        //matrixCollection[currentRow][currentCol] = null;
        // inputBoardTile(currentPosition, null);
        clearBoardTile(currentPosition);
    }

    public static void render() {

        Piece matrixElement;
        String signature;
        for(int i = 0; i < matrixCollection.length; i++) { // 1
            for(int j = 0; j < matrixCollection.length; j++) {

                matrixElement = matrixCollection[i][j];
                signature = (matrixElement == null) ?
                            " * "                   :
                        (" " + matrixElement.getSignature() + " ");

                System.out.print(signature);
            }
            System.out.println();
        }
    }


    private static Piece getBoardTile(PiecePosition externalPosition) {
        return matrixCollection[externalPosition.getRow()][externalPosition.getCol()];
    }

    private static void inputBoardTile(PiecePosition externalPosition, Piece piece) {
        matrixCollection[externalPosition.getRow()][externalPosition.getCol()] = piece;
    }

    private static void clearBoardTile(PiecePosition externalPosition) {
        inputBoardTile(externalPosition, null);
    }

}
