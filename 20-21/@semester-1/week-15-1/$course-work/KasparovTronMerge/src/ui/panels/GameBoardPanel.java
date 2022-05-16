package ui.panels;

import config.PieceColor;
import meta.PiecePosition;
import pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoardPanel extends JPanel {

    // Game Board config fields
    private final int BOARD_TILE_SIDE       = 50;
    private final int BOARD_TILE_COUNT      = 10;
    private final int BOARD_MIN_PRIMARY_ROW = 0;
    private final int BOARD_MIN_UTILITY_ROW = 1;
    private final int BOARD_MAX_PRIMARY_ROW = 9;
    private final int BOARD_MAX_UTILITY_ROW = 8;

    // Game Board storage fields
    private Piece[][] matrixCollection = new Piece[BOARD_TILE_COUNT][BOARD_TILE_COUNT];
    private Piece selectedPiece;

    private int moveRow;
    private int moveCol;

    // TODO : check if this approche is valid
    private boolean isWhitePieceMove = true;

    public GameBoardPanel() throws Exception {

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

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int row = e.getY() / BOARD_TILE_SIDE;
                int col = e.getX() / BOARD_TILE_SIDE;

                if(isPieceAvailable(row, col)) {

                    selectedPiece               = getPiece(row, col);
                    boolean isPieceSelectable   = (isWhitePieceMove && selectedPiece.isPieceColorWhite()) ||
                                                  (!isWhitePieceMove && selectedPiece.isPieceColorBlack());
                    if(isPieceSelectable) {
                        updateUI();
                    }
                }
                else {
                    // TILE selection
                    if(isPieceSelected()) {

                        try {

                            PiecePosition externalPosition = new PiecePosition(row, col);
                            if(selectedPiece.isMoveValid(externalPosition)) {

                                // TODO: change the piece traversal logic
                                PiecePosition currentPosition = new PiecePosition(selectedPiece.getCurrentPosition());
                                selectedPiece.move(externalPosition);

                                inputBoardTile(externalPosition, selectedPiece);
                                clearBoardTile(currentPosition);

                                // reset board state
                                resetSelectedPiece();

                                // change the player of the curent turn
                                nextTurn();

                                // refresh game board
                                updateUI();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
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

    private void nextTurn() {
        this.isWhitePieceMove = !this.isWhitePieceMove;
    }

    private Piece getPiece(int row, int col) {
        return matrixCollection[row][col];
    }

    private boolean isPieceAvailable(int row, int col) {
        return getPiece(row, col) != null;
    }

    private boolean isPieceSelected() {
        return selectedPiece != null;
    }

    public void paint(Graphics g) {

        for(int row = 0; row < BOARD_TILE_COUNT; row++) {
            for(int col = 0; col < BOARD_TILE_COUNT; col++) {
                render(g, row, col);
            }
        }
    }

    // Main render method
    private void render(Graphics g, int row, int col) {

        // * render game board tiles
        renderTile(g, row, col);

        // * render piece signature
        if(isPieceAvailable(row, col)) {

            try {
                renderPiece(g, row, col);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // helper method
    private void renderTile(Graphics g, int row, int col) {

        // *
        boolean isRowEven = (row % 2 == 0);
        boolean isColEven = (col % 2 == 0);

        boolean isBlack     = (isRowEven && isColEven) ||
                (!isRowEven && !isColEven);

        int x               =  col * BOARD_TILE_SIDE;
        int y               =  row * BOARD_TILE_SIDE;

        if(isPieceSelected() && (selectedPiece.getRow() == row && selectedPiece.getCol() == col)) {

            g.setColor(Color.GREEN);
            g.fillRect(x, y, BOARD_TILE_SIDE, BOARD_TILE_SIDE);
            return;
        }

        Color tileColor = isBlack ? Color.BLACK : Color.WHITE;
        g.setColor(tileColor);
        g.fillRect(x, y, BOARD_TILE_SIDE, BOARD_TILE_SIDE);
    }

    private void renderPiece(Graphics g, int row, int col) throws Exception {

        int x = (col * BOARD_TILE_SIDE) + 15;
        int y = (row * BOARD_TILE_SIDE) + 30;

        Piece currentPiece      = getPiece(row, col);
        String pieceSignature   = currentPiece.getSignature();
        Color currentPieceColor = currentPiece.isPieceColorBlack() ? Color.RED : Color.MAGENTA;

        g.setColor(currentPieceColor);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 23));
        g.drawString(pieceSignature, x, y);
    }
}