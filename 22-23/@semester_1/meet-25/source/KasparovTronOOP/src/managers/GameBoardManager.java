package managers;

import factories.GameBoardConfigurationFactory;
import gameBoard.GameBoard;
import gameObject.GameObject;
import gameObject.pieces.*;
import gameObject.tiles.Tile;

import java.util.Scanner;

public class GameBoardManager {

    private Scanner inputScanner = new Scanner(System.in);

    private GameBoard board = new GameBoard();

    public void startGame() {

        while(true) {
            this.board.render();
            
            System.out.println("Селектирайте фигура");
            System.out.println("ред");
            int selectionRow = inputScanner.nextInt();
            System.out.println("колона");
            int selectionCol = inputScanner.nextInt();

            if(this.board.isPiecePlayable(selectionRow, selectionCol)) {
                this.processMovePiece(selectionRow, selectionCol);
            }
        }
    }

    private void processMovePiece(int selectionRow, int selectionCol) {

        while(true) {

            System.out.println("къде да преместя фигурата");
            System.out.println("на ред");
            int moveRow = inputScanner.nextInt();
            System.out.println("на колона");
            int moveCol = inputScanner.nextInt();
            boolean isMoveSuccessful = this.board.movePiece(selectionRow, selectionCol, moveRow, moveCol);
            if(isMoveSuccessful) {
                System.out.println("Успешен ход !!!!");
                return;
            }

            System.out.println("Не валидна позиция за преместване");
        }
    }
}
