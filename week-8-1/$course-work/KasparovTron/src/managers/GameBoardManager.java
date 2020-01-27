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

    public static boolean isPieceAvailable(int selectRow, int selectCol) {

        Piece selectedPiece = matrixCollection[selectRow][selectCol];
        return (selectedPiece != null);
    }

    public static void selectPiece(int selectRow, int selectCol) {
        selectedPiece = matrixCollection[selectRow][selectCol];
    }

    public static boolean isMovePossible(int moveRow, int moveCol) {
        return selectedPiece.isMoveValid(moveRow, moveCol);
    }

    public static void move(int moveRow, int moveCol) {

        int currentRow              = selectedPiece.getRow();
        int currentCol              = selectedPiece.getCol();
        PiecePosition coordinates   = selectedPiece.getCurrentPosition();

        // selectedPiece.move(moveRow, moveCol);
        selectedPiece.move(coordinates);

        // Remark use PiecePosition object - experiment with different methods
        matrixCollection[moveRow][moveCol] = selectedPiece;
        matrixCollection[currentRow][currentCol] = null;
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
}
