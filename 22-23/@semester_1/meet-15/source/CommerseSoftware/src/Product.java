public class Product {

    private String name;
    private int count;
    private double buyPrice;
    private double sellPrice;

    // ИСкам да задължа потребителя да въведе всички полета
    // КОНСТРУКТОР - задължава потребителя да въведе стойности
    // 1. Конструктора задължително е public
    // 2. Конструктора е специален метод (няма връщан тип или void ) -
    // се извиква в класа а не от потребителя
    // 3. Името на конструктора е еквивалентно на името на Класа
    public Product(
            String inputName, int inputCount,
            double inputBuyPrice, double inputSellPrice
    ) {
        setName(inputName);
        setCount(inputCount);
        setBuyPrice(inputBuyPrice);
        setSellPrice(inputSellPrice);
    }

    public static Product createProductForSell(Product original, int sellCount) {
        return new Product(
                original.getName(),
                sellCount,
                original.getBuyPrice(),
                original.getSellPrice()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public int getCount() {
        return count;
    }

    public boolean isCountAvailable() { // не промена стойност за count
        return count != 0;
    }

    public void setCount(int inputCount) {
        count = inputCount;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double inputBuyPrice) {
        buyPrice = inputBuyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double inputSellPrice) {
        sellPrice = inputSellPrice;
    }

    public double getProductPrice() {
        return getCount() * getBuyPrice();
    }

    public void render() {

        String message      =   "Стока " + name;
        String countMessage =   "количество - " + count;
        String priceMessage =   "Покупна цена - "   + buyPrice  +
                " Продажна цена - " +  sellPrice;

        Terminal.output(message);
        Terminal.output(countMessage);
        Terminal.output(priceMessage);
    }
}