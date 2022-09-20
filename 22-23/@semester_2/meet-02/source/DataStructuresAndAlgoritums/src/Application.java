public class Application {

    public static void main(String[] args) {

        int[] collection = {1,8,2,9,3,7 }; // 17
        int index = search(collection, 8);
        System.out.println(index);
        // selectionSort(collection);
        // renderCollection(collection);

//        sortAsc(collection);
//        renderCollection(collection);
//        sortDesc(collection);
//        renderCollection(collection);

//        System.out.println("1.  Sort asc");
//        System.out.println("2.  Sort desc");
//        System.out.println("3.  Find number on position");
//        System.out.println("4.  Shufle numbers");
//        System.out.println("5.  Sum");
//        System.out.println("6.  Find greatest number");
//        System.out.println("7.  Find lowest number");
//        System.out.println("8.  Avrg");
//        System.out.println("9.  Simetrical array");
//        System.out.println("10. Reverse array");
//        System.out.println("11. Display");
//        System.out.println("12. Exit");
    }

    private static void sort(int[] collection, boolean isAsc) {

        int operationCycles = 0;

        for(int leftHandIndex = 0; leftHandIndex < collection.length - 1; leftHandIndex++) {
            for(int rightHandIndex = (leftHandIndex + 1); rightHandIndex < collection.length; rightHandIndex++) {

                int leftHandItem  = collection[leftHandIndex];
                int rightHandItem = collection[rightHandIndex];

                boolean isProcessable = (isAsc)
                        ? (leftHandItem > rightHandItem)
                        : (leftHandItem < rightHandItem);

                if(isProcessable) {
                    collection[leftHandIndex] = rightHandItem;
                    collection[rightHandIndex] = leftHandItem;
                }
                operationCycles++;
            }
        }
    }

    private static void sortAsc(int[] collection) {
        sort(collection, true);
    }

    private static void sortDesc(int[] collection) {
        sort(collection, false);
    }


    private static void selectionSort(int[] collection) {

        for(int i = 0; i < collection.length - 1; i++) {

            int minIndex = i;

            for(int j = i + 1; j < collection.length; j++) {

                if(collection[j] < collection[minIndex]) {
                    minIndex = j;
                }
            }

            // SWAP
            int tempElement      = collection[minIndex];
            collection[minIndex] = collection[i];
            collection[i]        = tempElement;
        }
    }

    private static int linearSearch(int[] collection, int element) {

        for(int i = 0; i < collection.length; i++) {
            if(collection[i] == element) {
                return i;
            }
        }

        return -1;
    }


    private static int binarySearch(int[] collection, int leftEndIndex, int rightEndIndex, int element) {

        if(rightEndIndex < leftEndIndex) {
            return -1;
        }

        // leftEndIndex -> 0
        // rightEndIndex -> 10;

        int medianaIndex = leftEndIndex + (rightEndIndex - leftEndIndex) / 2;
        int root         = collection[medianaIndex];

        if(root == element) {
            return medianaIndex;
        }

        return (root > element)
                ? binarySearch(collection, leftEndIndex, medianaIndex - 1, element)
                : binarySearch(collection, medianaIndex + 1, rightEndIndex, element);
    }

    private static int search(int[] collection, int element) {

        sortAsc(collection);
        return binarySearch(collection, 0, collection.length, element);
    }


    private static void renderCollection(int[] collection) {

        for (int element : collection ) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}


















