package ui.panels;

import meta.PiecePosition;
import pieces.*;
import state.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoardPanel extends JPanel {

    private GameBoard board;

    public GameBoardPanel() {

        this.board = GameBoard.getInstance();

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.print(Thread.currentThread());

                int row = e.getY() / board.BOARD_TILE_SIDE;
                int col = e.getX() / board.BOARD_TILE_SIDE;

                if(board.isPieceAvailable(row, col)) {

                    board.selectPiece(row, col);

                    if(board.isTurnPieceSelected()) {
                        updateUI();
                    }
                }
                else if(board.isPieceSelected()) {

                    Piece selectedPiece             = board.getSelectedPiece();
                    PiecePosition externalPosition  = new PiecePosition(row, col);

                    if(selectedPiece.isMoveValid(externalPosition)) {

                        // TODO: change the piece traversal logic
                        PiecePosition currentPosition = new PiecePosition(selectedPiece.getCurrentPosition());
                        selectedPiece.move(externalPosition);
                        board.nextTurn(selectedPiece, externalPosition, currentPosition);

                        // refresh game board
                        updateUI();
                    }
                }
            }
        });
    }

    public void paint(Graphics g) {

        for(int row = 0; row < this.board.BOARD_TILE_COUNT; row++) {
            for(int col = 0; col < this.board.BOARD_TILE_COUNT; col++) {
                render(g, row, col);
            }
        }
    }

    // Main render method
    private void render(Graphics g, int row, int col) {

        renderTile(g, row, col);

        if(GameBoard.getInstance().isPieceAvailable(row, col)) {
            renderPiece(g, row, col);
        }
    }

    // helper method
    private void renderTile(Graphics g, int row, int col) {

        // *
        boolean isRowEven = (row % 2 == 0);
        boolean isColEven = (col % 2 == 0);

        boolean isBlack     = (isRowEven && isColEven) ||
                (!isRowEven && !isColEven);

        // TODO : Rafactor to include generic board child classes
        int x                       =  col * this.board.BOARD_TILE_SIDE;
        int y                       =  row * this.board.BOARD_TILE_SIDE;
        boolean isTilePieceSelected = this.board.isPieceSelected() &&
                                      this.board.getSelectedPiece().getRow() == row &&
                                      this.board.getSelectedPiece().getCol() == col;
        if(isTilePieceSelected) {

            g.setColor(Color.GREEN);
            g.fillRect(x, y, this.board.BOARD_TILE_SIDE, this.board.BOARD_TILE_SIDE);
            return;
        }

        Color tileColor = isBlack ? Color.BLACK : Color.WHITE;
        g.setColor(tileColor);
        g.fillRect(x, y, this.board.BOARD_TILE_SIDE, this.board.BOARD_TILE_SIDE);
    }

    private void renderPiece(Graphics g, int row, int col) {

        int x = (col * this.board.BOARD_TILE_SIDE) + 15;
        int y = (row * this.board.BOARD_TILE_SIDE) + 30;

        Piece currentPiece      = this.board.getPiece(row, col);
        String pieceSignature   = currentPiece.getSignature();
        Color currentPieceColor = currentPiece.isPieceColorBlack() ? Color.RED : Color.MAGENTA;

        g.setColor(currentPieceColor);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 23));
        g.drawString(pieceSignature, x, y);
    }
}