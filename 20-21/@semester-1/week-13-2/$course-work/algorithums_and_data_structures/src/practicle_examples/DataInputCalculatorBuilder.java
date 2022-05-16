package practicle_examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

// Post fix record
public class DataInputCalculatorBuilder {

    private String dataInput;

    public DataInputCalculatorBuilder(String expression) {
        this.dataInput = expression;
    }

    private int getOperatorPriority(String operator) {

        // if(operator == "+") return 1;
        if(operator.equals("+") ) return 1;
        // if(operator == "-") return 2;
        if(operator.equals("-")) return 2;
        // if(operator == "*") return 3;
        if(operator.equals("*")) return 3;
        // if(operator == "/") return 4;
        if(operator.equals("/")) return 4;

        return 0;
    }

    private boolean isNumber(String element) {
        return this.getOperatorPriority(element) == 0;
    }


    private ArrayList<String> sortOperatorList(ArrayList<String> collection) {

        // 1. Convert from operator to number
        // 2. Sort
        // 3. Convert from number to operator

        ArrayList<Integer> newCollection = new ArrayList<>();
        for(int i = 0; i < collection.size(); i++) {

            int priority = this.getOperatorPriority(collection.get(i));
            newCollection.add(priority);
        }

            newCollection.sort(new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {

                    if(o1 > o2) return 1;
                    if(o1 < o2) return -1;

                    return 0;
                }
            });


        return null;
    }

    public String parse() {

        Stack<String> bracketStack      = new Stack<>();
        ArrayList<String> numberList    = new ArrayList<>();
        ArrayList<String> operatorList  = new ArrayList<>();

        for(int i = 0; i < this.dataInput.length(); i++) {
            String element = String.valueOf(this.dataInput.charAt(i));

            if(this.isNumber(element)) {

                if(element.equals("(")) {
                    bracketStack.push("(");
                }
                // move operator for BRACKETS case
                else if(element.equals(")")) {

                    bracketStack.pop();
                    if(bracketStack.isEmpty()) {
                        // move operator from operator list to number list
                        String operatorElement = operatorList.get(operatorList.size() - 1);
                        numberList.add(operatorElement);
                    }
                }
                else {
                    numberList.add(element);
                }
            } else {
                operatorList.add(element);
            }
        }

        return numberList.toString()  + operatorList.toString();
    }

    // * add    - 1
    // * sub    - 2
    // * multy  - 3
    // * div    - 4
}