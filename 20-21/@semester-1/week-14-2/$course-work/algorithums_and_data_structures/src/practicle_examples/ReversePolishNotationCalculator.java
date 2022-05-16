package practicle_examples;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReversePolishNotationCalculator {

    private static boolean isOperator(String input) {

        ArrayList<String> operatorListArray = new ArrayList<>();
        operatorListArray.add("+");
        operatorListArray.add("-");
        operatorListArray.add("*");
        operatorListArray.add("/");
        return operatorListArray.contains(input);

//        if(input.equals("+")) return true;
//        if(input.equals("-")) return true;
//        if(input.equals("*")) return true;
//        if(input.equals("/")) return true;
//        return false;
    }

    private static String calculate(String operator, String leftOperant, String rightOperat ) {

        int leftNumber = Integer.parseInt(leftOperant);
        int rightNumber = Integer.parseInt(rightOperat);

        if(operator.equals("+")) {
            return String.valueOf((leftNumber + rightNumber));
        }

        if(operator.equals("-")) {
            return String.valueOf((leftNumber - rightNumber));
        }

        if(operator.equals("*")) {
            return String.valueOf((leftNumber * rightNumber));
        }

        if(operator.equals("/")) {
            return String.valueOf((leftNumber / rightNumber));
        }

        //String msg = ("Operator" + operator  + "is not available");
        throw new WrongCalculationOperatorException();
        //throw new ArithmeticException();
        //throw new RuntimeException();
    }

    public static int calculate(String input) {

        Stack<String> elementStack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {

            String element = String.valueOf(input.charAt(i));

            if(isOperator(element)) {

                // calculate stack elements
                String leftOperat   = elementStack.pop();
                String rightOperant = elementStack.pop();
                String result = calculate(element, leftOperat, rightOperant);
                elementStack.push(result);
            }
            else {
                elementStack.push(element);
            }
        }

        return Integer.parseInt(elementStack.pop());
    }
}
