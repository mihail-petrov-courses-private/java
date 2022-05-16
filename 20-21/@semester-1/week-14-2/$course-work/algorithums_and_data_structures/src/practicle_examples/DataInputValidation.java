package practicle_examples;

import java.util.EmptyStackException;
import java.util.Stack;

public class DataInputValidation {

    public DataInputValidation() {

        //String expression1 = "(10 + 5) + (20 + 25)";
        // String expression2  = "((10 + 5) + (20 + 25))";
        String expression1  = ")10 + 5( +0 )20 + 25(";

        Stack<String> stackCollection = new Stack<>();

        int countOfOpenningBrackets = 0;
        int countOfClosingBrackets = 0;
        int numberOfOpenedBrackets = 0;

        for(int i = 0; i < expression1.length(); i++) {

            char pointerElement = expression1.charAt(i);

            try {

            if(pointerElement == '(') {
                stackCollection.push("(");
            }

            if(pointerElement == ')') {
                stackCollection.pop();
            }

            }
            catch (EmptyStackException e) {
                System.out.println("Invalid expression");
            }


//            if(pointerElement == '(') {
//                numberOfOpenedBrackets++;
//            }
//
//            if(pointerElement == ')') {
//                numberOfOpenedBrackets--;
//            }

//            if(pointerElement == '(') {
//            countOfOpenningBrackets++;
//            }
//
//            if(pointerElement == ')') {
//                countOfClosingBrackets++;
//            }
        }
//
//        if(countOfOpenningBrackets == countOfClosingBrackets) {
//            System.out.print("Fine");
//        }


        if(stackCollection.isEmpty()) {
            System.out.print("Stack Fine");
        }
        else {
            System.out.println("Invalid expression");
        }

//
//        if(numberOfOpenedBrackets == 0) {
//            System.out.print("Big Fine");
//        }

    }



}
