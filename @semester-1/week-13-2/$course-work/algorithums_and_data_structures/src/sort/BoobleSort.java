package sort;

import java.util.Arrays;

public class BoobleSort {

    public static void run() {

        int[] numericCollection = new int[] {
                1, 5, 7, 8, 6, 7, 4, 2, 0, 0, 0, 0, 5, -6, 1, 1, 6, 3
        };

        int[] copyCollection = numericCollection.clone();
        Arrays.sort(copyCollection);

        int leftElement;
        int rightElement;
        for(int i = 0; i < numericCollection.length - 1; i++) { //

            System.out.println("Main loop : " + i);
            System.out.println("% ");

            for(int j = 0; j < ((numericCollection.length - 1) - i); j++) {

                System.out.println("Inner loop : " + j);
                System.out.println("** ");

                // get comparison element
                leftElement = numericCollection[j];
                rightElement = numericCollection[j + 1];

                // execute comparison criteria
                if(leftElement > rightElement) {

                    int temporalElement = numericCollection[j+1];
                    numericCollection[j+1] = numericCollection[j];
                    numericCollection[j] = temporalElement;
                }
            }
        }

        for(int i = 0; i < numericCollection.length; i++ ) {
            System.out.print(numericCollection[i] + ", ");
        }
    }
}
