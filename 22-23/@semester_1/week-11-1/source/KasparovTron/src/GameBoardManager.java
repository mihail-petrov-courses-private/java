import java.util.Scanner;

public class GameBoardManager {


    private final int TILE = 0;
    // 1 - пешката
    private final int W_PAWN = 1;
    private final int B_PAWN = -1;
    // 2 - топа
    private final int W_ROOK = 2;
    private final int B_ROOK = -2;
    // 3 - офицера
    private final int W_BISHOP = 3;
    private final int B_BISHOP = -3;
    // 4 - коня
    private final int W_KNIGHT= 4;
    private final int B_KNIGHT= -4;
    // 5 - царица
    private final int W_QUEEN = 5;
    private final int B_QUEEN = -5;
    // 6 - царя
    private final int W_KING = 6;
    private final int B_KING = -6;

    private int[][] board = {
            {TILE,W_ROOK,W_KNIGHT,W_BISHOP,W_QUEEN,W_KING,W_BISHOP,W_KNIGHT,W_ROOK,TILE},
            {TILE,W_PAWN,W_PAWN,W_PAWN,W_PAWN,W_PAWN,W_PAWN,W_PAWN,W_PAWN,TILE},
            {TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE},
            {TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE},
            {TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE},
            {TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE},
            {TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE},
            {TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE,TILE},
            {TILE,B_PAWN,B_PAWN,B_PAWN,B_PAWN,B_PAWN,B_PAWN,B_PAWN,B_PAWN,TILE},
            {TILE,B_ROOK,B_KNIGHT,B_BISHOP,B_QUEEN,B_KING,B_BISHOP,B_KNIGHT,B_ROOK,TILE},
    };

    public GameBoardManager() {

        // първи ред
        // първа колона
        // this.board[0][0] = 0;

        // втори ред
        // втора колона
        // this.board[1][1] = 1;
    }

    public void render() {

        for (int[] processableRow : this.board) {
            for (int element : processableRow) {
                System.out.print(" " + this.getElementSign(element) + " ");
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

        // Вариант 1 - множество от масиви
//        String[] positiveMap = {"X", "wP", "wR", "wB", "wK", "wQ", "wKn"};
//        String[] negativeMap = {"X", "bP", "bR", "bB", "bK", "bQ", "bKn"};
//
//        if(elementId > 0) {
//            return positiveMap[elementId];
//        }
//
//        if(elementId < 0) {
//            return negativeMap[-1 * elementId];
//        }
//
//        return "X";
    }

    public void gameLoop() {

        Scanner scannerInput = new Scanner(System.in);

        while(true) {

            this.render();
            System.out.println("Избери ред");
            int row = scannerInput.nextInt();
            System.out.println("Избери колона");
            int col = scannerInput.nextInt();

            System.out.println("Премести на ред");
            int toRow = scannerInput.nextInt();
            System.out.println("Премести на колона");
            int toCol = scannerInput.nextInt();

            this.movePiece(row, col, toRow, toCol);
        }
    }

    private void movePiece(int row, int col, int toRow, int toCol) {

        int selectedPiece        = this.board[row][col];
        this.board[toRow][toCol] = selectedPiece;
        this.board[row][col]     = TILE;
    }
}
