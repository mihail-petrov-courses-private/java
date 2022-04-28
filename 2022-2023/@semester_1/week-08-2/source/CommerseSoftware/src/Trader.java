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
    private int sellIndex;

    // масив, който съхранява всички стоки
    private Product[] productCollection     = new Product[STORAGE_SIZE];
    private Product[] soldProductCollection = new Product[STORAGE_SIZE];


    public void startDay() {

        traderCodeForToday      = generateTraderCode();
        traderBarCodeForToday   = generateBarCode(traderCodeForToday);

        isActive = true;
        buyIndex = 0;

        moneyAmountForToday = Terminal.inputDouble("Въведете капитала си за деня");

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

        if(isStorageCapacityFull()) {
            Terminal.output("Няма място в склада");
            return;
        }

        Product buyProduct = null;
        while(true) {
            // 1. Въвеждам данни за продукта
            String editName         = (buyProduct != null) ? "[" + buyProduct.getName() + "]" : "";
            String productName      = Terminal.inputString("Название на закупената стока " + editName);

            String editCount        = (buyProduct != null) ? "[" + buyProduct.getCount() + "]" : "";
            int productCount        = Terminal.input("Количество на закупената стока " + editCount);

            String editBuyPrice     = (buyProduct != null) ? "[" + buyProduct.getBuyPrice() + "]" : "";
            double productBuyPrice  = Terminal.inputDouble("Цена за покупка " + editBuyPrice);

            String editSellPrice    = (buyProduct != null) ? "[" + buyProduct.getSellPrice() + "]" : "";
            double productSellPrice = Terminal.inputDouble("Цена за продажба " + editSellPrice);

            // 2. Създавам си променлива от тип Product
            if(buyProduct == null) {
                buyProduct = new Product(productName, productCount, productBuyPrice, productSellPrice);
            }
            else {
                buyProduct.setName(productName);
                buyProduct.setCount(productCount);
                buyProduct.setBuyPrice(productBuyPrice);
                buyProduct.setSellPrice(productSellPrice);
            }

            Terminal.output("Информация за продукта");
            Terminal.output("======================");
            buyProduct.render();

            String buyConfirmation  = Terminal.inputString("Съгласни ли сте с направената покупка Y/N/E");
            boolean isConfirmed     = buyConfirmation.equalsIgnoreCase("Y");
            boolean isCancel        = !buyConfirmation.equalsIgnoreCase("E");

            if (isConfirmed) {

                boolean isSaveProductSuccessful = saveProduct(buyProduct);

                if(!isSaveProductSuccessful) {
                    Terminal.output("Нямате достатъчно пари, опитайте се да повторите операцията");
                    continue;
                }
                return;
            }

            if(isCancel) {
                Terminal.output("Операцията е отказана");
                return;
            }
        }
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

    public void sellReport() {

    }

    public void balanceReport() {

        Terminal.output("Текущ баланс");
        Terminal.output("============");
        Terminal.output(moneyAmountForToday);
    }

    // увеличавам стойността на касата
    public void sell(double price) {

        for(int i = 0; i < buyIndex; i++) {

            String productName = productCollection[i].getName();
            Terminal.output("[" + i + "]" + productName);
        }

        int productId           = Terminal.input("Въведете номера на стоката която ще продадете");
        Product selectedProduct = productCollection[productId];
        selectedProduct.render();

        int sellCount                   = Terminal.input("Количество стока което ще продадете");
        boolean isOperationProcessable  = selectedProduct.getCount() >= sellCount;

        if(isOperationProcessable) {

            int resultCount = selectedProduct.getCount() - sellCount;
            selectedProduct.setCount(resultCount);
            double incomeAmount =  selectedProduct.getSellPrice() * sellCount;
            moneyAmountForToday += incomeAmount;

//            Product soldProduct = new Product(
//                    selectedProduct.getName(),
//                    sellCount,
//                    selectedProduct.getBuyPrice(),
//                    selectedProduct.getSellPrice()
//                    );

            Product soldProduct = Product.createProductForSell(selectedProduct, sellCount);

            soldProductCollection[sellIndex++] = soldProduct;
        }
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

       product.render();
        Terminal.output("***");
    }

    private void buyReportSingleItem(int index) {

        Product product     = productCollection[index];
        butReportSingleItem(product);
    }

    private double getTotalBuyPrice(Product inputProduct) {

        double productPrice = inputProduct.getProductPrice();
        double taxAmount    = (productPrice * 20) / 100;
        return productPrice + taxAmount;
    }

    private boolean hasStorageCapacity() {
        return productCollection.length > buyIndex;
    }

    private boolean isStorageCapacityFull() {
        return !hasStorageCapacity();
    }

    private boolean saveProduct(Product product) {

        double totalPrice       = getTotalBuyPrice(product);
        boolean hasEnoughMoney  = (moneyAmountForToday - totalPrice) > 0;

        if(hasEnoughMoney) {
            productCollection[buyIndex++] = product;
            return true;
        }

        return false;
    }

    private static String generateBarCodeSingleNumber(int inputNumber) {

        if(inputNumber == 0) return "*";
        if(inputNumber == 1) return "!";
        if(inputNumber == 2) return "@";
        if(inputNumber == 3) return "#";
        if(inputNumber == 4) return "$";
        if(inputNumber == 5) return "%";
        if(inputNumber == 6) return "^";
        if(inputNumber == 7) return "&";
        if(inputNumber == 8) return "/";
        if(inputNumber == 9) return "+";
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
