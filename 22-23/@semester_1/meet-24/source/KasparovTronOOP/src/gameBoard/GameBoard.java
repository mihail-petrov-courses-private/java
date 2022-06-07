package gameBoard;

import factories.GameBoardConfigurationFactory;
import gameObject.GameObject;
import gameObject.pieces.Piece;
import gameObject.tiles.Tile;

public class GameBoard {

    private GameObject[][] board = GameBoardConfigurationFactory.produceBoard();

    public void render() {
        for(GameObject[] processableRow : board) {
            for(GameObject piece : processableRow) {
                System.out.printf(" %5s ", piece.getSign());
            }
            System.out.println();
        }
    }

    public GameObject getPiece(int selectionRow, int selectionCol) {
        return this.board[selectionRow][selectionCol];
    }

    public boolean isPiecePlayable(int selectionRow, int selectionCol) {

        GameObject selectedPiece = this.getPiece(selectionRow, selectionCol);
        boolean isAvailable      = selectedPiece != null;
        boolean isPiece          = selectedPiece instanceof Piece;

        return isAvailable && isPiece;
    }

    public boolean movePiece(int selectionRow, int selectionCol, int moveRow, int moveCol) {

        if(!this.isPiecePlayable(selectionRow, selectionCol)) {
            return false;
        }

        Piece selectedPiece = (Piece)this.getPiece(selectionRow, selectionCol);

        if(selectedPiece.isDirectionMoveValid(moveRow, moveCol)) {

            selectedPiece.setPosition(moveRow, moveCol);
            this.board[moveRow][moveCol]            = selectedPiece;
            this.board[selectionRow][selectionCol]  = new Tile(selectionRow, selectionCol);

            return true;
        }

        return false;
    }
}
