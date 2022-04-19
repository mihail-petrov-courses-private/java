public class Trader {

    public static final int OPERATION_START_DAY = 1;
    public static final int OPERATION_BUY       = 2;
    public static final int OPERATION_SELL      = 3;
    public static final int OPERATION_REPORT    = 4;
    public static final int OPERATION_END_DAY   = 5;

    public int accountAmount        = 0;
    public boolean isActive         = false;

    double moneyAmountForToday      = 0;
    double productCountForToday     = 0;
    double priceForKilo             = 0;

    int traderCodeForToday          = 0;
    String traderBarCodeForToday    = null;

    public static boolean isOperationRestricted(int operationId) {
        return  operationId == Trader.OPERATION_BUY     ||
                operationId == Trader.OPERATION_SELL    ||
                operationId == Trader.OPERATION_REPORT;
    }

    public void startDay() {

        productCountForToday    = Terminal.inputDouble("Въведете количеството риба за деня (в кг.)");
        moneyAmountForToday     = Terminal.inputDouble("Въведете капитала си за деня");
        priceForKilo            = Terminal.inputDouble("Въведете цената за килограм");

        traderCodeForToday      = generateTraderCode();
        traderBarCodeForToday   = generateBarCode(traderCodeForToday);

        Terminal.output("***");
        Terminal.output(traderCodeForToday);
        Terminal.output(traderBarCodeForToday);

        isActive = true;
    }

    public boolean isOperationProcessable() {
        return isActive;
    }

    public boolean isOperationNotProcessable() {
        return !isOperationProcessable();
    }

    // намалявам стойността на касата
    public void buy(double price) {
        accountAmount -= price;
    }

    // увеличавам стойността на касата
    public void sell(double price) {
        accountAmount += price;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public static int generateTraderCode() {

        final int LOWER_BOUND_FOR_TRADER_CODE = 10_000;
        final int UPPER_BOUND_FOR_TRADER_CODE = 99_999;

        return RandomGenerator.number(
                LOWER_BOUND_FOR_TRADER_CODE,
                UPPER_BOUND_FOR_TRADER_CODE
        );
    }

    /*
    54691564654654654654564
    %$^+!
    | цифра  | символ  |
    |---     |---      |
    | 0      | *       |
    | 1      | !       |
    | 2      | @       |
    | 3      | #       |
    | 4      | $       |
    | 5      | %       |
    | 6      | ^       |
    | 7      | &       |
    | 8      | /       |
    | 9      | +       |
     */
    public static String generateBarCodeSingleNumber(int inputNumber) {

        if(inputNumber == 0) {
            return  "*";
        }

        if(inputNumber == 1) {
            return "!";
        }

        if(inputNumber == 2) {
            return  "@";
        }

        if(inputNumber == 3) {
            return  "#";
        }

        if(inputNumber == 4) {
            return "$";
        }

        if(inputNumber == 5) {
            return  "%";
        }

        if(inputNumber == 6) {
            return  "^";
        }

        if(inputNumber == 7) {
            return  "&";
        }

        if(inputNumber == 8) {
            return  "/";
        }

        if(inputNumber == 9) {
            return  "+";
        }

        return null;
    }

    public static String generateBarCode(int inputNumber) {

        String barCodeResult = "";
        while(inputNumber > 0) {

            int extractedNumberElement  = inputNumber % 10;
            inputNumber                 /= 10;
            barCodeResult               += generateBarCodeSingleNumber(extractedNumberElement);
        }

        return reverseStringWithFor(barCodeResult);
    }

    // -> ABCDE
    // -> EDCBA
    public static String reverseString(String inputString) {

        // Колко букви имам в низа ?
        int numberOfLettersInInputString    = inputString.length(); // 5
        int numberOfIterations              = 0;
        int charPointer                     =  numberOfLettersInInputString - 1;
        String resultString                 = "";

        // inputString.charAt(0); // A
        // inputString.charAt(4); // E

        while(numberOfIterations < numberOfLettersInInputString) {

            char letter =  inputString.charAt(charPointer);
            resultString += letter;

            // увеличавам стойността на numberOfIterations
            numberOfIterations++;
            charPointer--;
        }

        return resultString;
    }

    // -> ABCDE
    // -> EDCBA
    public static String reverseStringWithFor(String inputString) {

        // Колко букви имам в низа ?
        int numberOfLettersInInputString    = inputString.length(); // 5
        // int numberOfIterations              = 0;
        int charPointer                     =  numberOfLettersInInputString - 1;
        String resultString                 = "";

        // inputString.charAt(0); // A
        // inputString.charAt(4); // E

//        while(numberOfIterations < numberOfLettersInInputString) {
//
//            char letter =  inputString.charAt(charPointer);
//            resultString += letter;
//
//            // увеличавам стойността на numberOfIterations
//            numberOfIterations++;
//            charPointer--;
//        }

        // 3 различни групи код за управление на цикъла:
        // 1 - инициализация на брояч;
        // --> по традиция основния брояч се назовава с i
        // --> по традиция подпомагащия брояч се назовава с j
        // 2 - проверка на условие; (до кога ще въртим цикъла)
        // 3 - управление на стъпката на брояча.
        for(int i = 0, j = inputString.length() - 1; i < inputString.length(); i++, j--) {
            char letter =  inputString.charAt(j);
            resultString += letter;
        }

        // ***
        for(int i = inputString.length() - 1; i >= 0; i--) {

            char letter =  inputString.charAt(i);
            resultString += letter;
        }

        return resultString;
    }

}
