import config.PieceColor;
import managers.GameBoardManager;
import meta.PiecePosition;
import pieces.IHealable;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;
import tests.runner.TestRunner;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        PiecePosition newPiecePositionCooordinates = new PiecePosition(10, 10);
        System.out.println(newPiecePositionCooordinates.getRow());
        System.out.println(newPiecePositionCooordinates.getCol());


        // TestRunner.run();



//        System.out.println("Welcome to KASPAROV-TRON 101");
//
//        Scanner scannerReference = new Scanner(System.in);
//        GameBoardManager.init();
//        GameBoardManager.render();
//
//        int selectRow;
//        int selectCol;
//
//        int moveRow;
//        int moveCol;
//
//        while(true) {
//
//            System.out.print("Enter piece row : " );
//            selectRow = scannerReference.nextInt();
//
//            System.out.print("Enter piece col : " );
//            selectCol = scannerReference.nextInt();
//
//            if(GameBoardManager.isPieceAvailable(selectRow, selectCol)) {
//               GameBoardManager.selectPiece(selectRow, selectCol);
//                System.out.println("You have selected : " + GameBoardManager.selectedPiece.getSignature() );
//
//
//               // Get move coordinates
//                System.out.print("Enter move row : " );
//                moveRow = scannerReference.nextInt();
//
//                System.out.print("Enter move col : " );
//                moveCol = scannerReference.nextInt();
//
//                if(GameBoardManager.isMovePossible(moveRow, moveCol)) {
//                    GameBoardManager.move(moveRow, moveCol);
//                    GameBoardManager.render();
//                }
//                else {
//                    System.out.print("This move is not possible!! Try again next time" );
//                }
//            }
//            else {
//                System.out.print("No figure on this Tile!! Try again next time" );
//            }
//        }
   }


}