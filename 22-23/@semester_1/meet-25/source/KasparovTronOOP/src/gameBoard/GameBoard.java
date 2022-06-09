package gameBoard;

import config.ColorStyleEnum;
import factories.GameBoardConfigurationFactory;
import gameObject.GameObject;
import gameObject.enums.GameColorEnum;
import gameObject.pieces.Piece;
import gameObject.tiles.Tile;
import util.Terminal;

public class GameBoard {

    private GameObject[][] board = GameBoardConfigurationFactory.produceBoard();

    public void render() {

        int tileCount = 0;
        for(GameObject[] processableRow : board) {
            for(GameObject piece : processableRow) {

                String resultFormat = this.renderGameBoardPlaceholder(piece, tileCount);
                System.out.format(resultFormat, piece.getSign());
                tileCount++;
            }
            System.out.println();
            tileCount++;
        }
        System.out.println("\u001b[0m");
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

    private String renderPieceColor(GameObject piece, int tileCount) {

        return piece.getColor() == GameColorEnum.BLACK
                ? Terminal.yellow(ColorStyleEnum.FOREGROUND)
                : Terminal.black(ColorStyleEnum.FOREGROUND);
    }

    private String renderTileColor(GameObject piece, int tileCount) {

        return (tileCount % 2 == 0)
                ? Terminal.red(ColorStyleEnum.BACKGROUND)
                : Terminal.white(ColorStyleEnum.BACKGROUND);
    }

    private String renderGameBoardPlaceholder(GameObject piece, int tileCount) {

        String pieceColor = this.renderPieceColor(piece, tileCount);
        String tileColor = this.renderTileColor(piece, tileCount);

        return Terminal.colorMix("%3s ", pieceColor, tileColor);
    }
}