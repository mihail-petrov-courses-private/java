package factories;

import config.Game;
import gameBoard.GameBoard;
import gameObject.GameObject;
import gameObject.enums.GameColorEnum;
import gameObject.pieces.*;
import gameObject.tiles.Tile;

public class GameBoardConfigurationFactory {

    private static final int BASE_BOARD_ROW = 10;
    private static final int BASE_BOARD_COL = 10;

    private static int[][] baseBoard = {
            { Game.TILE,Game.W_ROOK,Game.W_KNIGHT,Game.W_BISHOP,Game.W_QUEEN, Game.W_KING,Game.W_BISHOP,Game.W_KNIGHT,Game.W_ROOK,Game.TILE  },
            { Game.TILE,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.W_PAWN,Game.TILE            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE,Game.TILE                            },
            { Game.TILE,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.B_PAWN,Game.TILE            },
            { Game.TILE,Game.B_ROOK,Game.B_KNIGHT,Game.B_BISHOP,Game.B_QUEEN,Game.B_KING,Game.B_BISHOP,Game.B_KNIGHT,Game.B_ROOK,Game.TILE   },
    };

    public static GameObject[][] produceBoard() {

        GameObject[][] resultBoard = new GameObject[BASE_BOARD_ROW][BASE_BOARD_COL];

        for(int row = 0; row < BASE_BOARD_ROW; row++) {
            for(int col = 0; col < BASE_BOARD_COL; col++) {
                resultBoard[row][col] = producePieceElement(row, col);
            }
        }
        return resultBoard;
    }

    public static GameObject[][] produceBoard(String snapshot) {

        GameObject[][] resultBoard  = new GameObject[BASE_BOARD_ROW][BASE_BOARD_COL];
        String[] pieceCollection         =  snapshot.split(",");

        int row = 0;
        int col = 0;
        int rowCounter = 1;
        for(int index = 0; index < pieceCollection.length; index++) {

            int pieceElementId      = Integer.parseInt(pieceCollection[index]);
            resultBoard[row][col]   = producePieceElement(row, col, pieceElementId);

            row         = (rowCounter == BASE_BOARD_ROW) ? (row + 1) : row;
            col         = (rowCounter == BASE_BOARD_ROW) ? 0         : (col + 1);
            rowCounter  = (rowCounter == BASE_BOARD_ROW) ? 1         : (rowCounter + 1);
        }
        return resultBoard;
    }


    public static int[][] produceSnapshot(GameObject[][] board) {

        int[][] snapshotBoard = new int[BASE_BOARD_ROW][BASE_BOARD_COL];

        for(int rowIndex = 0; rowIndex < BASE_BOARD_ROW; rowIndex++) {
            for(int colIndex = 0; colIndex < BASE_BOARD_COL; colIndex++) {
                snapshotBoard[rowIndex][colIndex] = produceSnapshotElement(rowIndex, colIndex, board);
            }
        }

        return snapshotBoard;
    }

    private static GameObject producePieceElement(int row, int col) {

        int pieceId     = baseBoard[row][col];
        return producePieceElement(row, col, pieceId);
    }

    public static GameObject producePieceElement(int row, int col, int pieceId) {

        if(pieceId == Game.TILE) return new Tile(row, col);

        int pieceIndex  = Math.abs(pieceId);
        GameColorEnum color    = (pieceId > 0) ? GameColorEnum.WHITE : GameColorEnum.BLACK;

        if(pieceIndex == Game.PAWN   ) return new Pawn(row, col, color);
        if(pieceIndex == Game.ROOK   ) return new Rook(row, col, color);
        if(pieceIndex == Game.BISHOP ) return new Bishop(row, col, color);
        if(pieceIndex == Game.KNIGHT ) return new Knight(row, col, color);
        if(pieceIndex == Game.QUEEN  ) return new Queen(row, col, color);
        if(pieceIndex == Game.KING   ) return new King(row, col, color);

        return null;
    }

    private static int produceSnapshotElement(int row, int col, GameObject[][] board) {

        GameObject piece     = board[row][col];

        if(piece instanceof Tile    ) return Game.TILE;
        if(piece instanceof Pawn    ) return (piece.getColor() == GameColorEnum.WHITE) ? Game.W_PAWN    : Game.B_PAWN;
        if(piece instanceof Rook    ) return (piece.getColor() == GameColorEnum.WHITE) ? Game.W_ROOK    : Game.B_ROOK;
        if(piece instanceof Bishop  ) return (piece.getColor() == GameColorEnum.WHITE) ? Game.W_BISHOP  : Game.B_BISHOP;
        if(piece instanceof Knight  ) return (piece.getColor() == GameColorEnum.WHITE) ? Game.W_KNIGHT  : Game.B_KNIGHT;
        if(piece instanceof Queen   ) return (piece.getColor() == GameColorEnum.WHITE) ? Game.W_QUEEN   : Game.B_QUEEN;
        if(piece instanceof King    ) return (piece.getColor() == GameColorEnum.WHITE) ? Game.W_KING    : Game.B_KING;

        return -99;

//        if(pieceId == Game.TILE) return new Tile(row, col);
//
//        int pieceIndex  = Math.abs(pieceId);
//        GameColorEnum color    = (pieceId > 0) ? GameColorEnum.WHITE : GameColorEnum.BLACK;
//
//        if(pieceIndex == Game.PAWN   ) return new Pawn(row, col, color);
//        if(pieceIndex == Game.ROOK   ) return new Rook(row, col, color);
//        if(pieceIndex == Game.BISHOP ) return new Bishop(row, col, color);
//        if(pieceIndex == Game.KNIGHT ) return new Knight(row, col, color);
//        if(pieceIndex == Game.QUEEN  ) return new Queen(row, col, color);
//        if(pieceIndex == Game.KING   ) return new King(row, col, color);
//
//        return null;
    }


}
