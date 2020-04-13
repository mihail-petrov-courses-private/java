package managers;

import config.PieceColor;
import pieces.*;

public class GameBoard {

    static Piece[][] matrixCollection = new Piece[10][10];

    static final int BOARD_MIN_PRIMARY_ROW = 0;
    static final int BOARD_MIN_UTILITY_ROW = 1;

    static final int BOARD_MAX_PRIMARY_ROW = 9;
    static final int BOARD_MAX_UTILITY_ROW = 8;

    public static Piece selectedPiece;

    public static void init() {

        Pawn wp1    = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 0);
        Pawn wp2    = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 1);
        Pawn wp3    = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 2);
        Pawn wp4    = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 3);
        Pawn wp5    = new Pawn(PieceColor.WHITE, BOARD_MIN_UTILITY_ROW, 4);

        Rook wr1    = new Rook(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 0);
        Knight wkn1 = new Knight(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 1);
        Bishop wb1  = new Bishop(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 2);
        King wk1    = new King(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 3);
        Queen wq1   = new Queen(PieceColor.WHITE, BOARD_MIN_PRIMARY_ROW, 4);

        matrixCollection[BOARD_MIN_UTILITY_ROW][0] = wp1;
        matrixCollection[BOARD_MIN_UTILITY_ROW][1] = wp2;
        matrixCollection[BOARD_MIN_UTILITY_ROW][2] = wp3;
        matrixCollection[BOARD_MIN_UTILITY_ROW][3] = wp4;
        matrixCollection[BOARD_MIN_UTILITY_ROW][4] = wp5;

        matrixCollection[BOARD_MIN_PRIMARY_ROW][0] = wr1;
        matrixCollection[BOARD_MIN_PRIMARY_ROW][1] = wkn1;
        matrixCollection[BOARD_MIN_PRIMARY_ROW][2] = wb1;
        matrixCollection[BOARD_MIN_PRIMARY_ROW][3] = wk1;
        matrixCollection[BOARD_MIN_PRIMARY_ROW][4] = wq1;

        Piece bp1    = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 0);
        Piece bp2    = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 1);
        Piece bp3    = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 2);
        Piece bp4    = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 3);
        Piece bp5    = new Pawn(PieceColor.BLACK, BOARD_MAX_UTILITY_ROW, 4);

        Piece br1    = new Rook(PieceColor.BLACK    , BOARD_MAX_PRIMARY_ROW, 0);
        Piece bkn1   = new Knight(PieceColor.BLACK  , BOARD_MAX_PRIMARY_ROW, 1);
        Piece bb1    = new Bishop(PieceColor.BLACK  , BOARD_MAX_PRIMARY_ROW, 2);
        Piece bk1    = new King(PieceColor.BLACK    , BOARD_MAX_PRIMARY_ROW, 3);

        matrixCollection[BOARD_MAX_UTILITY_ROW][0] = bp1;
        matrixCollection[BOARD_MAX_UTILITY_ROW][1] = bp2;
        matrixCollection[BOARD_MAX_UTILITY_ROW][2] = bp3;
        matrixCollection[BOARD_MAX_UTILITY_ROW][3] = bp4;
        matrixCollection[BOARD_MAX_UTILITY_ROW][4] = bp5;

        matrixCollection[BOARD_MAX_PRIMARY_ROW][0] = br1;
        matrixCollection[BOARD_MAX_PRIMARY_ROW][1] = bkn1;
        matrixCollection[BOARD_MAX_PRIMARY_ROW][2] = bb1;
        matrixCollection[BOARD_MAX_PRIMARY_ROW][3] = bk1;
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

        int currentRow = selectedPiece.row;
        int currentCol = selectedPiece.col;

        selectedPiece.move(moveRow, moveCol);
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
