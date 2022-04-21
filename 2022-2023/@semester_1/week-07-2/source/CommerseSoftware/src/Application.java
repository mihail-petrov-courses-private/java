import java.util.Scanner;

public class Application {

    public static int processRenderOperationMenu() {

        Terminal.output("Търговски операции");
        Terminal.output("======================");
        Terminal.output("1. Стартиране на деня");
        Terminal.output("2. Покупка");
        Terminal.output("3. Продажба");
        Terminal.output("4. Справки");
        Terminal.output("5. Приключване на деня");

        return Terminal.input();
    }

    public static void processStartDay(Trader traderManager) {

        if(traderManager.isDayClosed()) {
            traderManager.startDay();
            return;
        }

        Terminal.output("Деня вече е стартиран");
    }

    public static void processEndDay(Trader traderManager) {

        if(traderManager.isDayClosed()) {
            Terminal.output("Деня вече е затворен");
            return;
        }

        traderManager.endDay();
    }

    public static void processBuy(Trader traderManager) {

        if(traderManager.isOperationNotProcessable()) {
            Terminal.output("Деня не е отворен");
            return;
        }

        traderManager.buy();
    }

    public static void processSell(Trader traderManager) {

        if(traderManager.isOperationNotProcessable()) {
            Terminal.output("Деня не е отворен");
            return;
        }

        traderManager.sell(15);
    }

    public static void processReport(Trader traderManager) {
        traderManager.buyReport();
    }

    public static void main(String[] args) {

        Trader traderManager    = new Trader();

        while(true) {

            int operationId = processRenderOperationMenu();

            if(operationId == Trader.OPERATION_START_DAY) {
                processStartDay(traderManager);
            }

            if(operationId == Trader.OPERATION_BUY) {

                // Къде да пазя данните за тези стоки ?
                // Какво копувам
                // Какво количество от него копувам
                // Колко струва
                // За колко ще го продам

                processBuy(traderManager);
            }

            if(operationId == Trader.OPERATION_SELL) {
                processSell(traderManager);
            }

            if(operationId == Trader.OPERATION_REPORT) {
                processReport(traderManager);
            }

            if(operationId == Trader.OPERATION_END_DAY) {
                processEndDay(traderManager);
            }
        }
    }
}