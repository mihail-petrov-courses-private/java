public class Trader {

    public static final int OPERATION_START_DAY = 1;
    public static final int OPERATION_BUY       = 2;
    public static final int OPERATION_SELL      = 3;
    public static final int OPERATION_REPORT    = 4;
    public static final int OPERATION_END_DAY   = 5;

    public static final int STORAGE_SIZE        = 5;

    public int accountAmount        = 0;
    public boolean isActive         = false;

    double moneyAmountForToday      = 0;
    double productCountForToday     = 0;
    double priceForKilo             = 0;

    int traderCodeForToday          = 0;
    String traderBarCodeForToday    = null;

    // колко пъти сме купили нещо
    int buyIndex                    = 0;

    // масив, който съхранява всички имена на стоки
    String[] productNameCollection      = new String[STORAGE_SIZE];
    int[] productCountCollection        = new int[STORAGE_SIZE];
    double[] productPriceBuyCollection  = new double[STORAGE_SIZE];
    double[] productPriceSellCollection = new double[STORAGE_SIZE];

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

        isActive = true;
        buyIndex = 0;
    }

    public void endDay() {
        isActive = false;
    }

    public boolean isDayStarted() {
        return isActive;
    }

    public boolean isDayClosed() {
        return !isDayStarted();
    }

    public boolean isOperationProcessable() {
        return isActive;
    }

    public boolean isOperationNotProcessable() {
        return !isOperationProcessable();
    }

    // намалявам стойността на касата
    public void buy() {

        // Ще проверя дали имам място в склада за още покупки
        // размера на масива - .length
        if(productNameCollection.length <= buyIndex) {
            Terminal.output("Няма място в склада");
            return;
        }

        // Показно - трите операции последователно
//        String productName      = Terminal.inputString("Название на закупената стока - ");
//        productNameCollection[buyIndex] = productName;
//        buyIndex++;

        productNameCollection[buyIndex]      = Terminal.inputString("Название на закупената стока - ");
        productCountCollection[buyIndex]     = Terminal.input("количество на закупената стока");
        productPriceBuyCollection[buyIndex]  = Terminal.inputDouble("Покупна цена");
        productPriceSellCollection[buyIndex] = Terminal.inputDouble("Продажна цена цена");
        buyIndex++;
    }

    public void buyReport() {

        Terminal.output("Закупени стоки");
        Terminal.output("==============");
        // 1 = инициализираме брояч
        // 2 = условие на цикъла - до кога ще въртим
        // 3 = стъпка - увеличаваме или намаляваме
        for(int i = 0; i < buyIndex; i++) {

            String message      =   "Стока " + (i + 1) + " " + productNameCollection[i];
            String countMessage =   "количество - " + productCountCollection[i];
            String priceMessage =   "Покупна цена - "               +
                                    productPriceBuyCollection[i]    +
                                    " Продажна цена - "             +
                                    productPriceSellCollection[i];

            Terminal.output(message);
            Terminal.output(countMessage);
            Terminal.output(priceMessage);
            Terminal.output("***");
        }
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

        return Util.reverseString(barCodeResult);
    }
}
