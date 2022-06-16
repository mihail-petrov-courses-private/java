package database;

public class DataTransformator {

    public static String matrixTransform(int[][] matrix) {

        String result = "";
        for(int[] row : matrix) {
            for(int element : row) {
                result += element + ",";
            }
        }

        return result;
    }


}
