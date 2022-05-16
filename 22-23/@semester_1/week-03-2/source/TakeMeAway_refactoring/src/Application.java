import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // Рефакториране на MAGIC STRING - повторение на код
        // - тези стойности трябва да останат еднакви в рамките на кода
        final int LOWER_BOUND_OF_SPECIAL_NUMBER   = 99;
        final int LOWER_BOUND_OF_REFERENCE_NUMBER = 1_00_000;
        final int UPPER_BOUND_OF_REFERENCE_NUMBER = 9_99_999;

        final String MENU_ITEM_SALAD    = "Салата - 15лв";
        final String MENU_ITEM_MEAT     = "Свинско - 4лв";
        final String MENU_ITEM_CREAM    = "Крем карамел - 2лв";

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

        String customerTypeTitle = "N/A";

        if(isCustomerTypeNormal) {
            customerTypeTitle = "NORMAL";
        }

        if(isCustomerTypeLager) {
            customerTypeTitle = "LAGER";
        }

        if(isCustomerTypeEarlyAdopter) {
            customerTypeTitle = "EARLY ADOPTER";
        }

        System.out.println("Вие сте " + customerTypeTitle);

        // Задача 2
          boolean isCustomerVip = ((customerCardId % 2) == 0);
          String message        = (isCustomerVip)
                                    ? "Вип персона"
                                    : "Обикновен потребител";
          System.out.println(message);

          // Задача 3
        int secondToLast                = ( customerCardId % 100) / 10;
        boolean isApplicableForExtra    = (secondToLast > 3);
        String extraMessage             = (isApplicableForExtra)
                                            ? "Можете да поръчате допълнително"
                                            : "";
        System.out.println(extraMessage);

        // Задача 4
        boolean isCustomerSuperVip = isCustomerVip
                                     &&
                                     isApplicableForExtra;

        // Задача 5
        System.out.println("Меню:");
        System.out.println("1. " + MENU_ITEM_SALAD);
        System.out.println("2. " + MENU_ITEM_MEAT);
        System.out.println("3. " + MENU_ITEM_CREAM);

        System.out.print("Моля направете вашата поръчка");
        int orderId = inputScanner.nextInt();

        boolean isOrderValid =  (orderId == 1)
                                ||
                                (orderId == 2)
                                ||
                                (orderId == 3);

//        String orderMessage = (orderId == 1)
//                                ? MENU_ITEM_SALAD
//                                : (orderId == 2)
//                                    ? MENU_ITEM_MEAT
//                                    : (orderId == 3)
//                                      ? MENU_ITEM_CREAM
//                                        : "";

        String orderMessage = "";
        if(orderId == 1) {
            orderMessage = MENU_ITEM_SALAD;
        }

        if(orderId == 2) {
            orderMessage = MENU_ITEM_MEAT;
        }

        if(orderId == 3) {
            orderMessage = MENU_ITEM_CREAM;
        }



//        orderPrice = (isOrderValid)
//                    ? (orderId == 1)
//                        ? 15
//                        : (orderId == 2)
//                            ? 4
//                            : (orderId == 3)
//                                ? 2
//                                : 1
//                    : 1;

        // Вариант 1
        // Условна конструкция с логически оператори
        if(isOrderValid && orderId == 1) {
            orderPrice = 15;
        }

        if(isOrderValid && orderId == 2) {
            orderPrice = 4;
        }

        if(isOrderValid && orderId == 3) {
            orderPrice = 2;
        }

        if(!isOrderValid) {
            orderPrice = 1;
        }

        // Вариант 2
        // Вложени условни конструкции
        if(isOrderValid) {
            if(orderId == 1) {
                orderPrice = 15;
            }

            if(orderId == 2) {
                orderPrice = 4;
            }

            if(orderId == 3) {
                orderPrice = 2;
            }

            if(isCustomerSuperVip) {
                orderPrice = orderPrice - 1;
            }
        }
        else {
         orderPrice = 1;
        }

        // Ще направя намаление само ако има валидна поръчка
//        orderPrice =  (isOrderValid)
//                    ? (isCustomerSuperVip)
//                        ? (orderPrice - 1)
//                        : orderPrice
//                    : orderPrice;

        String completeOrderMessage = (isOrderValid)
                                        ? "Вие поръчахте " +  orderMessage
                                        : "Невалидна поръчка";

        System.out.println(completeOrderMessage);
        System.out.println("Моля заплатете " + orderPrice + "лв");
    }
}
