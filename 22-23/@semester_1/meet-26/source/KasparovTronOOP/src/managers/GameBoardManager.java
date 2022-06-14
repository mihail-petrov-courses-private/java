package managers;

import factories.GameBoardConfigurationFactory;
import gameBoard.GameBoard;
import gameObject.enums.GameColorEnum;
import util.Terminal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameBoardManager {

    private final String PROGRESS_SNAPSHOT = "game_progress.txt";

    private Scanner inputScanner = new Scanner(System.in);

    private GameBoard board = new GameBoard();

    private GameColorEnum[] playerCollection = {
            GameColorEnum.WHITE, GameColorEnum.BLACK
    };

    private int playerIndex = 0;

    public void startGame() {

        this.board.setActiveColor(GameColorEnum.WHITE);

        while(true) {
            this.board.render();

            Terminal.println("Избери операция");
            Terminal.println("1. Направи ход");
            Terminal.println("2. Съхрани прогреса");
            Terminal.println("3. Зареди прогреса");
            int commandId = inputScanner.nextInt();

            if(commandId == 1) {
                processPlay();
            }

            if(commandId == 2) {
                processSaveFile();
            }

            if(commandId == 3) {
                processLoadFile();
            }
        }
    }

    private void processSaveFile() {

        int[][] snapshotMatrix = this.board.getSnapshot();

        try {
            FileWriter fileManager = new FileWriter(PROGRESS_SNAPSHOT);

            for(int[] row : snapshotMatrix) {
                for(int element : row) {
                    fileManager.write(Integer.toString(element));
                }
            }

            fileManager.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processLoadFile() {

        try {
            FileReader fileManager = new FileReader(PROGRESS_SNAPSHOT);

            int processableCharacter = fileManager.read();
            while(processableCharacter > -1) {

                System.out.println(processableCharacter);
                processableCharacter = fileManager.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processPlay() {
        System.out.println("Селектирайте фигура");
        System.out.println("ред");
        int selectionRow = inputScanner.nextInt();
        System.out.println("колона");
        int selectionCol = inputScanner.nextInt();

        if(this.board.isPiecePlayable(selectionRow, selectionCol)) {
            this.processMovePiece(selectionRow, selectionCol);
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
                this.startNextTurn();
                return;
            }

            System.out.println("Не валидна позиция за преместване");
        }
    }

    private GameColorEnum getNextPlayerColor() {

        try {
            return this.playerCollection[++playerIndex];
        }
        catch (ArrayIndexOutOfBoundsException e) {

            playerIndex = 0;
            return this.playerCollection[playerIndex];
        }

//        int nextIndex               = playerIndex + 1; // 1
//        boolean isPlayerLoopEnded   = nextIndex >= playerCollection.length;
//        playerIndex                 = (isPlayerLoopEnded) ? 0 : nextIndex;
//
//        return this.playerCollection[playerIndex];
    }

    private void startNextTurn() {
        this.board.setActiveColor(this.getNextPlayerColor());
    }
}






















