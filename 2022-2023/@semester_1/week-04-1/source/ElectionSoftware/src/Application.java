import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        final int LOWER_BOUND_POOR = 99;
        final int UPPER_BOUND_POOR = 100_000;
        final int UPPER_BOUND_NORMAL = 999_999;
        final int TAX_EVADER_COEFFICIENT = 3;

        final String PARTY_TITLE_1   = "Партия за прогресивен канибализъм";
        final String PARTY_TITLE_27  = "Замундска вегетарианска партия";
        final String PARTY_TITLE_666 = "Синдикат на вуду-трактористите";
        final String PARTY_TITLE_999 = "Партия на труда, мотиката и наковалнята";

        final int PARTY_ID_1    = 1;
        final int PARTY_ID_27   = 27;
        final int PARTY_ID_666  = 666;
        final int PARTY_ID_999  = 999;

        final String TAX_EVADER_MESSAGE = "Укриваш ли данъци - отговори с Y/N";

        final String ANSWER_YES = "Y";

        boolean isTaxEvader         = true;
        boolean doesVoterWishBonus  = false;

        // Механизъм за събиране на входни данни
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Въведете номера на картата");
        int cardNumber = inputScanner.nextInt();

        // от 99  до 100000
        boolean isVoterPoor = cardNumber    > LOWER_BOUND_POOR
                              && cardNumber < UPPER_BOUND_POOR;
        // от 100000 до 999999
        boolean isVoterNormal = cardNumber >= UPPER_BOUND_POOR
                                && cardNumber <= UPPER_BOUND_NORMAL;

        // над 999999
        boolean isVoterRich = cardNumber > UPPER_BOUND_NORMAL;

        // комбинирани условни конструкции

        if(isVoterPoor) {
            System.out.println("Хайде по-бързо и да те няма");
        }
        else if(isVoterNormal) {
            System.out.println("Радваме се, че нормални хора вече гласуват");
        }
        else if(isVoterRich) {
            System.out.println("Има за нас, има и за вас");
        }

        // провера за вип статус
        boolean isVoterVIP  = (cardNumber % 2 == 0);

        // проверка за укриване на данъци
        boolean isPotentialTaxEvader =  (((cardNumber % 100) / 10) > TAX_EVADER_COEFFICIENT);

        // Фактическо гласуване за партия
        System.out.println("Моля гласувайте за:");
        System.out.println("с 1   - " + PARTY_TITLE_1);
        System.out.println("с 27  - " + PARTY_TITLE_27);
        System.out.println("с 666 - " + PARTY_TITLE_666);
        System.out.println("с 999 - " + PARTY_TITLE_999);
        int partyId = inputScanner.nextInt();

        if(partyId == PARTY_ID_1) {
            System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_1);
        }
        else if(partyId == PARTY_ID_27) {
            System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_27);
        }
        else if(partyId == PARTY_ID_666) {
            System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_666);
        }
        else if(partyId == PARTY_ID_999) {
            System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_999);
        }
        else {
            System.out.println("Не съществува такава партия, вашия вот е невалиден");
        }

        // Проверка за укриване на данъци
        if(isPotentialTaxEvader) {

            System.out.println(TAX_EVADER_MESSAGE);
            String questionAnswer   = inputScanner.next();
            isTaxEvader             = questionAnswer.equals(ANSWER_YES);
            String message          = (isTaxEvader) ? "Браво моето момче" : "Будала";
            System.out.println(message);
        }

        // Проверка за супер честен статус
        boolean isVoterSuperVIP = isVoterVIP && !isTaxEvader;
        if(isVoterSuperVIP) {

            System.out.println("Колега искаш ли баничка Y/N");
            String questionAnswer   = inputScanner.next();
            doesVoterWishBonus      = questionAnswer.equals(ANSWER_YES);
            String message          = (doesVoterWishBonus) ? "Не може" : "Ами, то и без това няма";
            System.out.println(message);
        }

        // Проверка за:
        // - нормалност
        // - желание за баничка
        // - глас за конкретна партия 27
        boolean isVoterSpecial = !doesVoterWishBonus
                                 && isVoterNormal
                                 && (partyId == PARTY_ID_27);

        if(isVoterSpecial) {
            System.out.println("Живота е жесток, дължите данък един банан");
        }
    }
}