package practicle_examples;

import java.util.*;

// Post fix record
public class DataInputCalculatorBuilder {

    private String dataInput;
    // private ArrayList<String> numberList;
    private StringBuilder numberList;
    private Stack<String> operatorStack;

    public DataInputCalculatorBuilder(String expression) {

        this.dataInput = expression;
        // this.numberList = new ArrayList<>();
        this.numberList = new StringBuilder();
        this.operatorStack = new Stack<>();
    }

    private int getOperatorPriority(String operator) {

        HashMap<String, String> hp = new HashMap<>();

        if(operator.equals("+") ) return 1;
        if(operator.equals("-")) return 1;
        if(operator.equals("*")) return 2;
        if(operator.equals("/")) return 2;
        return 0;
    }

    private void addOperatorToOperatorStack(String operator) {

        // 0.
        if(this.operatorStack.isEmpty()) {

            this.operatorStack.push(operator);
            return;
        }

        // 1. Peek current element
        String topElement = this.operatorStack.peek();

        // 2. Compare
        int oldOperatorPriority = this.getOperatorPriority(topElement);
        int newOperatorPriority = this.getOperatorPriority(operator);

        if(oldOperatorPriority >= newOperatorPriority) {

            topElement = this.operatorStack.pop();
            //this.numberList.add(topElement);
            this.numberList.append(topElement);
        }

        this.operatorStack.push(operator);
    }

    // 5 + 6 + 7
    public String parse() {

        String element;
        for(int i = 0; i < this.dataInput.length(); i++) {

            // get current atom
            element = String.valueOf(this.dataInput.charAt(i));

            // 3. Braket ( and )
            if(element.equals("(") ) {
               operatorStack.push("(");
               continue;
            }

            if(element.equals(")")) {

                // direct pops
//                String currentOperator;
//                while(!(currentOperator = operatorStack.pop()).equals("(")) {
//                    numberList.add(currentOperator);
//                }

                // Peek and pop
                while(!operatorStack.peek().equals("(")) {

                    String operatorElement = operatorStack.pop();
                    //numberList.add(operatorElement);
                    numberList.append(operatorElement);
                }
                operatorStack.pop();
                continue;
            }

            // 1. Number
            if(this.getOperatorPriority(element) == 0) {

                //numberList.add(element);
                numberList.append(element);
                continue;
            }

            // 2. Operator
            addOperatorToOperatorStack(element);
        }

        for(int j = 0; j < this.operatorStack.size(); j++) {
            //numberList.add(this.operatorStack.pop());
            numberList.append(this.operatorStack.pop());
        }

        while(!this.operatorStack.isEmpty()) {
            //numberList.add(this.operatorStack.pop());
            numberList.append(this.operatorStack.pop());
        }

 //       StringBuilder sb = new StringBuilder();
        //String resultExpression = "";
//        for(int i = 0; i < this.numberList.size(); i++) {
//            sb.append(this.numberList.get(i));
//        }

        // return this.numberList.toString();
        // return resultExpression;
        return numberList.toString();
    }

    // * add    - 1
    // * sub    - 2
    // * multy  - 3
    // * div    - 4
}