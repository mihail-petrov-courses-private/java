import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // Рефакториране на MAGIC STRING - повторение на код
        // - тези стойности трябва да останат еднакви в рамките на кода
        // final int lowerBoundOfSpecialNumber   = 99;
        final int LOWER_BOUND_OF_SPECIAL_NUMBER   = 99;
        // final int lowerBoundOfReferenceNumber = 1_00_000;
        final int LOWER_BOUND_OF_REFERENCE_NUMBER = 1_00_000;
        // final int upperBoundOfReferenceNumber = 9_99_999;
        final int UPPER_BOUND_OF_REFERENCE_NUMBER = 9_99_999;

        // Задача 1
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Въведете номера на вашата карта: ");
        // искам да взема число - номер на картана на клиента
        int customerCardId = inputScanner.nextInt();
        // проверка на типа на клиента
        // нормален клиент - между 100000 и 999999
        // boolean isCustomerTypeNormal = (100000 < customerCardId < 9999999);
        // номера на картата му е по-голям или равен от 100000
        // и
        // номера на картата му е по-малък или равен от 999999
        boolean isCustomerTypeNormal =  (LOWER_BOUND_OF_REFERENCE_NUMBER <= customerCardId)
                                        &&
                                        (customerCardId <= UPPER_BOUND_OF_REFERENCE_NUMBER);

        // изостанал клиенти - повече от 9_99_999
        boolean isCustomerTypeLager = customerCardId > UPPER_BOUND_OF_REFERENCE_NUMBER;

        // иновативен клиент - между 99 и 1_00_000
//        boolean isCustomerTypeEarlyAdopter = (99 < customerCardId)
//                                             &&
//                                             (customerCardId < LOWER_BOUND_OF_REFERENCE_NUMBER);

        // номера на картата му е по-голям от две цифри
        // и
        // той НЕ е НОРМАЛЕН клиент
        // и
        // той НЕ е ИЗОСТАНАЛ клиент
        boolean isCustomerTypeNotNormal    = !isCustomerTypeNormal;
        boolean isCustomerTypeNotLager     = !isCustomerTypeLager;
        boolean isCardIdSpecial            = LOWER_BOUND_OF_SPECIAL_NUMBER < customerCardId;
        boolean isCustomerTypeEarlyAdopter = isCardIdSpecial
                                             &&
                                             isCustomerTypeNotNormal
                                             &&
                                             isCustomerTypeNotLager;

        // - НОРМАЛЕН
        // - СПЕЦИАЛЕН
        // - ИЗОСТАНАЛ
        // - грешка

        String customerTypeTitle = (isCustomerTypeNormal)
                                    ? "NORMAL"
                                    : isCustomerTypeLager
                                        ? "LAGER"
                                        : isCustomerTypeEarlyAdopter
                                            ? "EARLY ADOPTER"
                                            : "N/A";

        System.out.println("Вие сте " + customerTypeTitle);
    }
}
