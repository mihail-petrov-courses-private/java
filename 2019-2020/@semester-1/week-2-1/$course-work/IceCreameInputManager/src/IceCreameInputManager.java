import java.util.Scanner;

class IceCreameInputManager {

    public static void main(String[] args) {

        // String inputOperatorName;
        System.out.println("ICE CREAME MANAGER");
        System.out.println("WELCOME TO THE SYSTEM");

        // instance
        // number
        // boolean
        // String
        // 10 / 10.5 / "Hello" / true / new Instance
        // Scanner scannerInstance = new Scanner(System.in);
        // int inputNumber = scannerInstance.nextInt();
        // System.out.println(inputNumber);

        // Scanner demo for input operator name
        // Scanner scannerInstance  =  new Scanner(System.in);
        // inputOperatorName = scannerInstance.nextLine();

        // System.out.print("Hi ");
        // System.out.print(inputOperatorName);


        // $$String concatenation demo
        // $$concatenate <=> append <=> слепване
        // String currency = "USD";
        // String amount ="10$";
        // String delimiter = "-";

        // example for variable identificator operation
        // String amountCurrencyDisplay = currency + delimiter + amount;

        // example for mixing variable  with literal value
        // String amountCurrencyDisplay = currency + "--" + amount;
        // int intAmount = 10;
        //String amountCurrencyDisplay = currency + delimiter + intAmount;
        // System.out.print(amountCurrencyDisplay);

        // String originalAmount = "10";
        // String chargeAmount = "10";
        // String totalAMount = originalAmount + chargeAmount;
        // System.out.print(totalAMount);

        // demo for number sum
        // int originalAmountInt = 10;
        // int chargeAmountInt = 10;
        // int totalAmountInt = originalAmountInt + chargeAmountInt;
        // System.out.print(totalAmountInt);

        /*
        // Multiple amount commented with BLOCK COMMENT
        int originalAmountInt = 10;
        int chargeAmountInt = 10;
        int insuranceAmount = 10;
        int extraAmount = 10;
        int tipAmount = 10;
        int totalAmountInt =    originalAmountInt +
                                chargeAmountInt +
                                insuranceAmount +
                                extraAmount +
                                tipAmount;

        System.out.print(totalAmountInt);
        */

        Scanner scannerInstance = new Scanner(System.in);

        System.out.print("What is your name : ");
        String inputOperatorName = scannerInstance.nextLine();
        String inputSystemMessage = "Hi " + inputOperatorName;

        System.out.println(inputSystemMessage);

        System.out.print("Enter the amount of ICE CREAMES for today : ");

        // convert String to integer from the console
        int iceCreameManufactureCountForToday = scannerInstance.nextInt();
        System.out.println("ICE CREAME count :  " + iceCreameManufactureCountForToday );

        // add              +
        // substract        -
        // multiplication   *
        // divide           /

        //int addAmount   = 10 + 10;    // 20
        //int subAmount   = 10 - 10;    // 0;
        //int multyAmount = 10 * 10;  // 100
        //int divAmount   = 10 / 10;    // 1

        //System.out.println("Add : " + addAmount);
        //System.out.println("Sub : " + subAmount);
        //System.out.println("Multy : " + multyAmount);
        //System.out.println("Div : " + divAmount);

        // int orderOfExecutionAmount = 10 + 10 * 10;
        // System.out.println("Order of execution" + orderOfExecutionAmount); // 110

         //int orderOfExecutionAmount = (10 + 10) * 10;
         //System.out.println("Order of execution with Brackets" + orderOfExecutionAmount); // 200

        final int BRANCH_COUNT = 10;
        int iceCreameDividedByBrancheCount = iceCreameManufactureCountForToday / BRANCH_COUNT;
        System.out.println("Count for every single branch : " + iceCreameDividedByBrancheCount);

        // final int intVariableFinalNoInitialisation;
        // intVariableFinalNoInitialisation = 10;
        // System.out.println(intVariableFinalNoInitialisation);

        System.out.println("Count for of ICE CREAMES from yesterday : ");
        int iceCreameManifactiredFromYesterday = scannerInstance.nextInt();

        // >
        // <
        // ==
        // >=
        // <=


        // 10 > 20 -- > no (false)
        // 10 < 20 --> yes (true)
        // boolean is10GreatherThan20 = 10 > 20;

        boolean isManufacturedAmountGreaterThanYesterday = iceCreameManufactureCountForToday > iceCreameManifactiredFromYesterday;
        System.out.println("Is Today better than yesterday : "  + isManufacturedAmountGreaterThanYesterday);

        // ? :
        // String specialOperator = (true) ? "Result is True" : "Result is False";
        // String specialOperator = (iceCreameManufactureCountForToday > iceCreameManifactiredFromYesterday) ? "Result is True" : "Result is False";

        // invalid operation
        // String specialOperator = "Hello world" ? "True" : "False";
        // String specialOperator = true ? 10 : "False";
        // System.out.print(specialOperator);

        String manufacturerMessage = isManufacturedAmountGreaterThanYesterday ? "Good job :) " : "Low capacity :( ";
        System.out.print(manufacturerMessage);
    }
}
