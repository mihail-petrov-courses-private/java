import commands.Move;
import config.Game;

import java.util.Scanner;

public class GameBoardManager {

    private int activePlayer  = Game.B_PLAYER;

    private int[][] board = {
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

    public void render() {

        String message = (this.activePlayer == Game.W_PLAYER) ? "белите" : "черните";
        System.out.printf("%s са на ход", message);
        System.out.println();

        for (int[] processableRow : this.board) {
            for (int element : processableRow) {
                System.out.printf(" %4s ", this.getElementSign(element));
            }

            System.out.println();
        }
    }

    private String getElementSign(int elementId) {

        // Вариант 2 - един масив
        if(elementId == 0) return "X";

        String[] map    = {"X", "P", "R", "B", "K", "Q", "Kn"};
        String colorId  = (elementId > 0) ? "w" : "b";
        int index       = (elementId > 0) ? elementId : -1 * elementId;
        return colorId + map[index];
    }

    public void gameLoop() {

        Scanner scannerInput = new Scanner(System.in);
        int selectedPieceId = 999;


        while(true) {

            this.render();
            System.out.print("Избери ред ");
            int row = scannerInput.nextInt();
            System.out.print("Избери колона ");
            int col = scannerInput.nextInt();

            // селектиране на фигура
            if(this.isSelectionValid(row, col)) {
                selectedPieceId = Math.abs(this.board[row][col]);
            }
            else {
                System.out.println("Избралисте фигура която не ви принадлежи");
                continue;
            }

            System.out.print("Премести на ред ");
            int toRow = scannerInput.nextInt();
            System.out.print("Премести на колона ");
            int toCol = scannerInput.nextInt();


            if(Move.isMoveValid(this.board, activePlayer, row, col, toRow, toCol)) {
                this.movePiece(row, col, toRow, toCol);
            }
            else {
                System.out.println("Хода е невалиден - опитай пак");
                continue;
            }

            activePlayer = getNextPlayer();
        }
    }

    private int getNextPlayer() {
        return  (this.activePlayer == Game.W_PLAYER) ? Game.B_PLAYER : Game.W_PLAYER;
    }

    private boolean isSelectionValid(int row, int col) {
        int selectedPieceId = this.board[row][col];

        if(selectedPieceId == Game.TILE) return false;

        int selectedPiecePlayerCoefficient  = this.activePlayer * selectedPieceId;
        boolean isPlayerSelectionValid      = selectedPiecePlayerCoefficient > 0;

        // проверка за коректна селекция спрямо играч
        // коефициент 1  => +
        // коефициент -1 => -
        return isPlayerSelectionValid;
    }


    private void movePiece(int row, int col, int toRow, int toCol) {

        int selectedPiece        = this.board[row][col];
        this.board[toRow][toCol] = selectedPiece;
        this.board[row][col]     = Game.TILE;
    }
}
