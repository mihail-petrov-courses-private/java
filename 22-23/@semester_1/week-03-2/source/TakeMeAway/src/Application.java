import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // Рефакториране на MAGIC STRING - повторение на код
        // - тези стойности трябва да останат еднакви в рамките на кода
        final int LOWER_BOUND_OF_SPECIAL_NUMBER   = 99;
        final int LOWER_BOUND_OF_REFERENCE_NUMBER = 1_00_000;
        final int UPPER_BOUND_OF_REFERENCE_NUMBER = 9_99_999;

        final String MENU_ITEM_SALAD = "Салата - 15лв";
        final String MENU_ITEM_MEAT = "Свинско - 4лв";
        final String MENU_ITEM_CREAM = "Крем карамел - 2лв";

        int orderPrice = 0;

        // Задача 1
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Въведете номера на вашата карта: ");
        // искам да взема число - номер на картана на клиента
        int customerCardId = inputScanner.nextInt();

        boolean isCustomerTypeNormal =  (LOWER_BOUND_OF_REFERENCE_NUMBER <= customerCardId)
                                        &&
                                        (customerCardId <= UPPER_BOUND_OF_REFERENCE_NUMBER);

        boolean isCustomerTypeLager = customerCardId > UPPER_BOUND_OF_REFERENCE_NUMBER;

        boolean isCustomerTypeNotNormal    = !isCustomerTypeNormal;
        boolean isCustomerTypeNotLager     = !isCustomerTypeLager;
        boolean isCardIdSpecial            = LOWER_BOUND_OF_SPECIAL_NUMBER < customerCardId;
        boolean isCustomerTypeEarlyAdopter = isCardIdSpecial
                                             &&
                                             isCustomerTypeNotNormal
                                             &&
                                             isCustomerTypeNotLager;

        String customerTypeTitle = (isCustomerTypeNormal)
                                    ? "NORMAL"
                                    : isCustomerTypeLager
                                        ? "LAGER"
                                        : isCustomerTypeEarlyAdopter
                                            ? "EARLY ADOPTER"
                                            : "N/A";

        System.out.println("Вие сте " + customerTypeTitle);

        // Задача 2
        // Какви са операторите за умнежение и деление
        // -> * -> умножение
        // -> / -> деление
        // -> % -> делене с остатък - връща остатъка от деленето
//        System.out.println("Целочислено делене");
//        System.out.println(10 / 2); // очакваме - 5
//        System.out.println(9.0 / 2);  // очакваме - 4,5
//        double result = 9 / 2.0;
//        System.out.println(result);  // очакваме - 4,5
//
//        System.out.println("Делене по модул - остатък");
//        System.out.println(10 % 2);    // очакваме - 0
//        System.out.println(9 % 2);     // очакваме - 0
//        System.out.println(8 % 2);     // очакваме - 0
//        System.out.println(7 % 3);     // очакваме - 0
//        System.out.println(6 % 2);     // очакваме - 0
//        System.out.println(5 % 2);     // очакваме - 0
//        System.out.println(4 % 2);     // очакваме - 0
//        System.out.println(3 % 2);     // очакваме - 0
//        System.out.println(2 % 2);     // очакваме - 0
//        System.out.println(1 % 2);     // очакваме - 0
          boolean isCustomerVip = ((customerCardId % 2) == 0);
          String message = (isCustomerVip)
                            ? "Вип персона"
                            : "Обикновен потребител";
          System.out.println(message);

          // Задача 3
//          System.out.print("***");
//          System.out.print(44 % 10);
//          // -> / премахвате от края на числото
//          // -> % премахвате от началото на числото
//          System.out.println((1234 % 100) / 10);

        // 123456
        // 56
        int secondToLast                = ( customerCardId % 100) / 10;
        boolean isApplicableForExtra    = (secondToLast > 3);
        String extraMessage             = (isApplicableForExtra)
                                        ? "Можете да поръчате допълнително"
                                        : "";
        System.out.println(extraMessage);

        // Задача 4
        boolean isCustomerSuperVip = isCustomerVip && isApplicableForExtra;

        // Задача 5
        System.out.println("Меню:");
        System.out.println("1. " + MENU_ITEM_SALAD);
        System.out.println("2. " + MENU_ITEM_MEAT);
        System.out.println("3. " + MENU_ITEM_CREAM);

        System.out.print("Моля направете вашата поръчка");
        int orderId = inputScanner.nextInt();

        String orderMessage = (orderId == 1)
                                ? MENU_ITEM_SALAD
                                : (orderId == 2)
                                    ? MENU_ITEM_MEAT
                                    : (orderId == 3)
                                      ? MENU_ITEM_CREAM
                                        : "";

        // Поръчка 1 ИЛИ Поръчка 2 ИЛИ Поръчка 3
        // ЛОГИЧСКО ИЛИ -> ||
        boolean isOrderValid =  (orderId == 1)
                                ||
                                (orderId == 2)
                                ||
                                (orderId == 3);

        // Ще калкулирам цената на стоката, която искам да поръчам
        orderPrice = (isOrderValid)
                    ? (orderId == 1)
                        ? 15
                        : (orderId == 2)
                            ? 4
                            : (orderId == 3)
                                ? 2
                                : 1
                    : 1;

        // Ще направя намаление само ако има валидна поръчка
        orderPrice =  (isOrderValid)
                    ? (isCustomerSuperVip)
                        ? (orderPrice - 1)
                        : orderPrice
                    : orderPrice;

        String completeOrderMessage = (isOrderValid)
                                        ? "Вие поръчахте " +  orderMessage
                                        : "Невалидна поръчка";

        System.out.println(completeOrderMessage);
        System.out.println("Моля заплатете " + orderPrice + "лв");
    }
}
