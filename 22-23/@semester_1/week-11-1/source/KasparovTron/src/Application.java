public class Application {

    public static String generateBarcode(int element) {

        if(element == 0) {
            return "!";
        }

        if(element == 1) {
            return "@";
        }

        if(element == 2) {
            return "#";
        }

        return "*";
    }

    public static String generateBarcodeElement(int element) {
        
        String[] map = {"!", "@", "#"};

        if(element >= map.length) {
            return "*";
        }

        return map[element];
    }

    public static void main(String[] args) {

        // Декларация на масив
        // когато - очакваме да го напълним в последствие
        // int[][] collection = new int[10][10];

        // Инициализиране на масив
        // когато той ни трябва директно
//        int[] collection = {1,2,3,4,5,6,7,8,9};
//        int[][] multyCollectio = {
//                {1, 2, 3 },
//                {4, 5, 6 },
//                {7, 8, 9 }
//        };
//
//        for(int row = 0; row < multyCollectio.length; row++) {
//            int[] currentProcessableRow = multyCollectio[row];
//
//            for(int col = 0; col < currentProcessableRow.length; col++) {
//                System.out.print(currentProcessableRow[col] + " ");
//            }
//            System.out.println();
//        }


        // Работа с множество индекси

//        for(int row = 0; row < multyCollectio.length; row++) {
//
//            for(int col = 0; col < multyCollectio[row].length; col++) {
//                System.out.print(multyCollectio[row][col] + " ");
//            }
//            System.out.println();
//        }

        GameBoardManager gameBoard = new GameBoardManager();
        gameBoard.gameLoop();
    }
}
