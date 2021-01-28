package managers;

import pieces.Piece;

public class GameBoard {

    Piece[][] matrixCollection = new Piece[10][10];

    public void populate() {

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
