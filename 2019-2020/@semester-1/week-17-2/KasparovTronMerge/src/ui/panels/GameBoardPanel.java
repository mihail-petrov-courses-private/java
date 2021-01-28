package ui.panels;

import contracts.IUpdatePanelUi;
import meta.PiecePosition;
import pieces.*;
import state.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoardPanel extends JPanel implements IUpdatePanelUi {

    private GameBoard board;

    public GameBoardPanel() {

        this.board = GameBoard.getInstance();

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int row = e.getY() / board.BOARD_TILE_SIDE;
                int col = e.getX() / board.BOARD_TILE_SIDE;

                if(!board.isPieceSelected()) {
                    processSelection(row, col);
                }

                if(board.isPieceSelected()) {
                    processAction(row, col);
                }
            }
        });
    }

    private void processSelection(int row, int col) {

        if(board.isPieceAvailable(row, col)) {
            board.selectPiece(row, col);
        }
    }

    private void processAction(int row, int col) {

        Piece selectedPiece             = board.getSelectedPiece();
        PiecePosition externalPosition  = new PiecePosition(row, col);
        boolean isPieceAttackable       = board.isPieceAvailable(row, col) &&
                                          selectedPiece.isAttackValid(externalPosition);
        boolean isPieceMovable          = !isPieceAttackable;

        // attack scenario
        if(isPieceAttackable) {
            processPieceMovement(selectedPiece, externalPosition);
        }

        if(isPieceMovable) {
            processPieceMovement(selectedPiece, externalPosition);
        }
    }

    private void processPieceMovement(Piece selectedPiece, PiecePosition externalPosition) {

        PiecePosition currentPosition = new PiecePosition(selectedPiece.getCurrentPosition());
        selectedPiece.move(externalPosition);
        board.nextTurn(selectedPiece, externalPosition, currentPosition);

        // refresh game board
        updateUI();
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

    @Override
    public void updatePanelUi() {
        updateUI();
    }
}