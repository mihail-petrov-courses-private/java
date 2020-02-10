import managers.GameBoardManager;
import meta.PiecePosition;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        //TestRunner.run();



        System.out.println("Welcome to KASPAROV-TRON 101");

        Scanner scannerReference = new Scanner(System.in);
        GameBoardManager.init();
        GameBoardManager.render();

        int selectRow;
        int selectCol;

        int moveRow;
        int moveCol;
        PiecePosition selectPosition;
        PiecePosition movePosition;

        while(true) {

            System.out.print("Enter piece row : " );
            selectRow = scannerReference.nextInt();

            System.out.print("Enter piece col : " );
            selectCol = scannerReference.nextInt();
            selectPosition = new PiecePosition(selectRow, selectCol);

            // if(GameBoardManager.isPieceAvailable(selectRow, selectCol)) {
            if(GameBoardManager.isPieceAvailable(selectPosition)) {
               // GameBoardManager.selectPiece(selectRow, selectCol);
                GameBoardManager.pickPiece(selectPosition);
                System.out.println("You have selected : " + GameBoardManager.selectedPiece.getSignature() );

                // Get move coordinates
                System.out.print("Enter move row : " );
                moveRow = scannerReference.nextInt();

                System.out.print("Enter move col : " );
                moveCol = scannerReference.nextInt();
                movePosition = new PiecePosition(moveRow, moveCol);

                // if(GameBoardManager.isMovePossible(moveRow, moveCol)) {
                if(GameBoardManager.isMovePossible(movePosition)) {
                    // GameBoardManager.move(moveRow, moveCol);
                    GameBoardManager.move(movePosition);
                    GameBoardManager.render();
                }
                else {
                    System.out.print("This move is not possible!! Try again next time" );
                }
            }
            else {
                System.out.print("No figure on this Tile!! Try again next time" );
            }
        }
   }
}