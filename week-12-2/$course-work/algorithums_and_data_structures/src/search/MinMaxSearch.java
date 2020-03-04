package search;

public class MinMaxSearch {

    public static void run() {

        int[] collection = new int[] {
          1, 5, 7, 8, 6, 7, 4, 2, 0, 0, 0, 0, 5, -6, 1, 1, 6, 3
        };

        int min = collection[0];
        for(int i = 0; i < collection.length; i++) {

            if(collection[i] < min) {
                min = collection[i];
            }
        }

        System.out.println(min);
    }
}
