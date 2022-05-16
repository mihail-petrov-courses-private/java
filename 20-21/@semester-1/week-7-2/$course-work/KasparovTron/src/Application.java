import config.PieceColor;
import managers.GameBoard;
import pieces.Pawn;
import tests.runner.TestRunner;
import tests.test.*;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

// Test if adresses of two objects are equal
//        Pawn p1 = new Pawn(PieceColor.BLACK, 1, 1);
//        Pawn p2 = new Pawn(PieceColor.BLACK, 1, 1);
//
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p1 == p2);
//        System.out.println(p1.equals(p2));
//        System.out.println(p1.power == p2.power);
//

//
//        System.out.println("Welcome to KASPAROV-TRON 101");
//        System.out.println("Type exit to exit");
//        // TestRunner.run();
//
//        Scanner scannerReference = new Scanner(System.in);
//        String input;
//        int playerColor;
//
//        System.out.println("Pleace input your color");
//        System.out.println("1. for white");
//        System.out.println("2. for black");
//        playerColor = scannerReference.nextInt();
//
//        if(playerColor == 1) {
//        System.out.println("You chose WHITE");
//        }
//        else {
//            System.out.println("You chose BLACK");
//        }
//
//        while(true) {
//
//            System.out.println("Input piece coordinates ");
//            input = scannerReference.nextLine();
//            System.out.println("Inputed data " + input);
//
//            // if(input == "exit") {
//            if(input.equals("exit")) {
//                System.out.println("You type exit");
//                break;
//            }
//        }
//
//        System.out.println("See you next time");



        System.out.println("Welcome to KASPAROV-TRON 101");

        Scanner scannerReference = new Scanner(System.in);
        GameBoard.init();
        GameBoard.render();

        int selectRow;
        int selectCol;

        int moveRow;
        int moveCol;


        while(true) {

            System.out.print("Enter piece row : " );
            selectRow = scannerReference.nextInt();

            System.out.print("Enter piece col : " );
            selectCol = scannerReference.nextInt();

            if(GameBoard.isPieceAvailable(selectRow, selectCol)) {
               GameBoard.selectPiece(selectRow, selectCol);
                System.out.print("You have selected : " + GameBoard.selectedPiece.getSignature() );


               // Get move coordinates
                System.out.print("Enter move row : " );
                moveRow = scannerReference.nextInt();

                System.out.print("Enter move col : " );
                moveCol = scannerReference.nextInt();

                if(GameBoard.isMovePossible(moveRow, moveCol)) {
                    GameBoard.move(moveRow, moveCol);
                    GameBoard.render();
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