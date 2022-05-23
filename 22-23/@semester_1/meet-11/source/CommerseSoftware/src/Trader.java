public class Trader {

    public static final int OPERATION_START_DAY = 1;
    public static final int OPERATION_BUY       = 2;
    public static final int OPERATION_SELL      = 3;
    public static final int OPERATION_REPORT    = 4;
    public static final int OPERATION_END_DAY   = 5;

    public int accountAmount    = 0;
    public boolean isActive     = false;

    public static boolean isOperationRestricted(int operationId) {
        return  operationId == Trader.OPERATION_BUY     ||
                operationId == Trader.OPERATION_SELL    ||
                operationId == Trader.OPERATION_REPORT;
    }

    public void startDay() {
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
}
