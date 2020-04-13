package practicle_examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

// Post fix record
public class DataInputCalculatorBuilder {

    private String dataInput;
    private ArrayList<String> numberList;
    private Stack<String> operatorStack;

    public DataInputCalculatorBuilder(String expression) {

        this.dataInput = expression;
        this.numberList = new ArrayList<>();
        this.operatorStack = new Stack<>();
    }

    private int getOperatorPriority(String operator) {

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

        if(oldOperatorPriority == newOperatorPriority) {

            // 3. Pop old operator
            topElement = this.operatorStack.pop();
            this.numberList.add(topElement);

            // 4. Push new operator
            this.operatorStack.push(operator);
        }
    }

    // 5 + 6 + 7
    public String parse() {

        String element;
        for(int i = 0; i < this.dataInput.length(); i++) {

            // get current atom
            element = String.valueOf(this.dataInput.charAt(i));

            // 3. Braket ( and )
            if(element == "(") {
                // TODO
            }

            if(element == ")") {
                // TODO
            }

            // 1. Number
            if(this.getOperatorPriority(element) == 0) {

                numberList.add(element);
                continue;
            }

            // 2. Operator
            addOperatorToOperatorStack(element);
        }

        for(int j = 0; j < this.operatorStack.size(); j++) {
            numberList.add(this.operatorStack.pop());
        }

        while(!this.operatorStack.isEmpty()) {
            numberList.add(this.operatorStack.pop());
        }

        return this.numberList.toString();
    }

    // * add    - 1
    // * sub    - 2
    // * multy  - 3
    // * div    - 4
}