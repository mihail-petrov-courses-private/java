public class Trader {

    public static final int OPERATION_START_DAY = 1;
    public static final int OPERATION_BUY       = 2;
    public static final int OPERATION_SELL      = 3;
    public static final int OPERATION_REPORT    = 4;
    public static final int OPERATION_END_DAY   = 5;

    private static final int STORAGE_SIZE        = 5;

    private int accountAmount               = 0;
    private boolean isActive                = false;

    private double moneyAmountForToday      = 0;
    private double productCountForToday     = 0;
    private double priceForKilo             = 0;

    private int traderCodeForToday          = 0;
    private String traderBarCodeForToday;

    // колко пъти сме купили нещо
    private int buyIndex;

    // масив, който съхранява всички имена на стоки
    private Product[] productCollection = new Product[STORAGE_SIZE];

    public void startDay() {

        traderCodeForToday      = generateTraderCode();
        traderBarCodeForToday   = generateBarCode(traderCodeForToday);

        isActive = true;
        buyIndex = 0;

        Terminal.output("Денят е отворен успешно");
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

        if(productCollection.length <= buyIndex) {
            Terminal.output("Няма място в склада");
            return;
        }

        Product buyProduct   = new Product();

        while(true) {

            String editNameMessage          = (buyProduct.name != null) ? ("предишна стойност " + buyProduct.name) : "";
            String inputNameMessage         = "Название на закупената стока - " + editNameMessage;

            String editCountMessage         = (buyProduct.count != 0) ? ("предишна стойност " + buyProduct.count) : "";
            String inputCountMessage        = "Количество на закупената стока - " + editCountMessage;

            String editBuyPriceMessage      = (buyProduct.buyPrice != 0) ? ("предишна стойност " + buyProduct.buyPrice) : "";
            String inputBuyPriceMessage     = "Количество на закупената стока - " + editBuyPriceMessage;

            String editSellPriceMessage     = (buyProduct.sellPrice != 0) ? ("предишна стойност " + buyProduct.sellPrice) : "";
            String inputSellPriceMessage    = "Количество на закупената стока - " + editSellPriceMessage;

            buyProduct.name                 = Terminal.inputString(inputNameMessage);
            buyProduct.count                = Terminal.input(inputCountMessage);
            buyProduct.buyPrice             = Terminal.inputDouble(inputBuyPriceMessage);
            buyProduct.sellPrice            = Terminal.inputDouble(inputSellPriceMessage);

            Terminal.output("Информация за закупен продукт");
            Terminal.output("=============================");
            butReportSingleItem(buyProduct);
            String buyConfirmation =  Terminal.inputString("Съгласни ли сте с направената покупка Y/N/E");

            if(buyConfirmation.equalsIgnoreCase("Y")) {
                productCollection[buyIndex++] = buyProduct;
                return;
            }

            if(!buyConfirmation.equalsIgnoreCase("E")) {
                break;
            }
        }

        Terminal.output("Операцията е отказана");
    }

    public void buyReport() {

        if(buyIndex == 0) {
            Terminal.output("Няма закупени стоки към момента");
            return;
        }

        Terminal.output("Закупени стоки");
        Terminal.output("==============");

        for(int i = 0; i < buyIndex; i++) {
            buyReportSingleItem(i);
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

    private void butReportSingleItem(Product product) {

        String message      =   "Стока " + product.name;
        String countMessage =   "количество - " + product.count;
        String priceMessage =   "Покупна цена - "   +  product.buyPrice  +
                " Продажна цена - " +  product.sellPrice;

        Terminal.output(message);
        Terminal.output(countMessage);
        Terminal.output(priceMessage);
        Terminal.output("***");
    }

    private void buyReportSingleItem(int index) {

        Product product     = productCollection[index];
        butReportSingleItem(product);
    }

    private static String generateBarCodeSingleNumber(int inputNumber) {

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

    private static String generateBarCode(int inputNumber) {

        String barCodeResult = "";
        while(inputNumber > 0) {

            int extractedNumberElement  = inputNumber % 10;
            inputNumber                 /= 10;
            barCodeResult               += generateBarCodeSingleNumber(extractedNumberElement);
        }

        return Util.reverseString(barCodeResult);
    }
}
