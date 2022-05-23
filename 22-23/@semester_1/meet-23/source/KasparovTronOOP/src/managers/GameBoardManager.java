package managers;

import factories.GameBoardConfigurationFactory;
import gameObject.GameObject;
import gameObject.pieces.*;
import gameObject.tiles.Tile;

public class GameBoardManager {

    private GameObject[][] board = GameBoardConfigurationFactory.produceBoard();

    public void startGame() {

        for(GameObject[] processableRow : board) {
            for(GameObject piece : processableRow) {

                System.out.printf(" %5s ", piece.getSign());

//                if(piece instanceof Pawn) {
//
//                    Pawn element = (Pawn)piece;
//                    boolean isTrue = piece instanceof Rook;
//
//
//                    System.out.printf(" %5s ", element.getSign());
//                }
//
//                if(piece instanceof Rook) {
//                    Rook element = (Rook)piece;
//                    System.out.printf(" %5s ", element.getSign());
//                }
//
//                if(piece instanceof Bishop) {
//                    Bishop element = (Bishop)piece;
//                    System.out.printf(" %5s ", element.getSign());
//                }
//
//                if(piece instanceof Knight) {
//                    Knight element = (Knight)piece;
//                    System.out.printf(" %5s ", element.getSign());
//                }
//
//                if(piece instanceof Queen) {
//                    Queen element = (Queen)piece;
//                    System.out.printf(" %5s ", element.getSign());
//                }
//
//                if(piece instanceof King) {
//                    King element = (King)piece;
//                    System.out.printf(" %5s ", element.getSign());
//                }
//
//                if(piece instanceof Tile) {
//                    Tile element = (Tile)piece;
//                    System.out.printf(" %5s ", element.getSign());
//                }

            }
            System.out.println();
        }
    }
}
