package managers;

import pieces.Piece;

public class GameBoard {

    // regular array
    // int[] collect = new int[10];

    // Game board multy dimentianal array for
    // storing game board pieces
    Piece[][] matrixCollection = new Piece[10][10];

    public void populate() {

//        matrixCollection[0][0] = 10;
//        matrixCollection[1][1] = 11;
//        matrixCollection[2][2] = 12;
//        matrixCollection[3][3] = 13;
    };

    public void render() {

        for(int i = 0; i < matrixCollection.length; i++) { // 1

            for(int j = 0; j < matrixCollection.length; j++) {
                System.out.print(matrixCollection[i][j] + " ");
            }
            System.out.println();
        }
    }
}
