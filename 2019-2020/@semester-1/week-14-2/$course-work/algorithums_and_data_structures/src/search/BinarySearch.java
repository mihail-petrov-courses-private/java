package search;

import java.util.Arrays;

public class BinarySearch {

    public static boolean doesExists(int[] collection, int serchableElement) {

        Arrays.sort(collection);

        int startIndex  = 0;
        int endIndex    = (collection.length - 1);

        // while startIndex <= endIndex
        while(startIndex <= endIndex) {

            // middle by whole collection length
            // int middleElement = (collection.length / 2);
            // int middleElement =((endIndex - startIndex) / 2);
            int middleElement = startIndex + ((endIndex - startIndex) / 2);

            if(collection[middleElement] == serchableElement) {
                return true;
            }

            // 4 > 23
            if(collection[middleElement] > serchableElement) {
                endIndex = middleElement - 1;
            }

            // 4 < 23
            if(collection[middleElement] < serchableElement) {
                startIndex = middleElement + 1; // 4
            }
        }

        return false;
    }
}
