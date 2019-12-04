import java.util.Scanner;

class MobileFoodStation {

    public static void main(String[] args) {

        // #1
        System.out.print("** THIS IS FOOD BOT **");

        Scanner scannerInstance = new Scanner(System.in);
        int serialNumberInput = scannerInstance.nextInt();
        System.out.println("Serial number : " + serialNumberInput);

        // serial number > 2 digits
        // 99 - 100
        // 9  - 10
        // if serial number > 99
        boolean isEarlyAdopter = serialNumberInput > 99 && serialNumberInput < 100000;

        // serial number > 6 digits
        // if serial number > 999999
        boolean isLagger = serialNumberInput > 999999;

        // serial number == 6 digits
        // 100000 - 999999
        // if serial number >= 100000 AND serial number <= 999999
        boolean isOver100000  = serialNumberInput >= 100000; // true or false
        boolean isBelow999999 = serialNumberInput <= 999999; // true or false

        // true  -> 1
        // false -> 0
        // Are you hungry -> 0 / 1
        // Are you democrat OR socialist
        //   --> Are you democrat  -> 1
        //   --> Are you socialist -> 0
        //   --> 1 + 0 => 1 TRUE

        // Are you hungry or tursty
        // --> Are you hungry -> 1
        // --> Are you tursty -> 1
        // --> 1 + 1 => 2 TRUE

        // --> Are you hungry -> 1
        // --> Are you tursty -> 0
        // --> 1 + 0 => 1 TRUE

        // --> Are you hungry -> 0
        // --> Are you tursty -> 0
        // --> 0 + 0 => 0 FALSE

        // Rain AND sunny
        // --> Rain --> 1
        // --> Sunny --> 1
        // --> 1 * 1 => 1

        // --> Rain --> 0
        // --> Sunny --> 1
        // --> 0 * 1 => 0

        boolean isNormal = isOver100000 && isBelow999999;
        // && -> AND
        // || -> OR

        System.out.println("Is user EARLY_ADOPTER : " + isEarlyAdopter);
        System.out.println("Is user LAGGER : " + isLagger);
        System.out.println("Is user NORMAL : " + isNormal);

        // TEST INPUT
        // INPUT 12222222222
        // 2 - 6
        // int
        // 2000000000000000000000000000000
        // double


        // 105468 / 10 => 10546.8
        // 105468 / 100 => 1054.68
        // 105468 % 10  => 8
        int serialNumberRemainingPart = serialNumberInput % 10; // 8
        System.out.println("Remaining part : " + serialNumberRemainingPart);
        // 2 4 6 8 10
        // 2 / 2 = 1
        // 3 / 2 = 1.5
        // 4 / 2 = 2
        // 5 / 2 = 2.5
        // 6 / 2 = 3
        // 2 % 2 == 0
        // 3 % 2 != 0

        boolean isEven  = ((serialNumberRemainingPart % 2) == 0);
        boolean isVip   = (isEven == true);


        // 105468 / 10 => 10546.8
        // int
        int serialNumberWithoutLastDigit = ((serialNumberInput / 10) % 10);
        System.out.println("Remaining serialNumber : " + serialNumberWithoutLastDigit);
        // System.out.println(serialNumberWithoutLastDigit % 10);
        // ((serialNumberInput / 10) % 10)
        // ((serialNumberInput % 100) % 10)
        // serialNumberInput % 100 => 68 % 10 => 8

        boolean canOrderSecondDish = (serialNumberWithoutLastDigit > 3);

        boolean isSuperVip = isVip && canOrderSecondDish;
        boolean isMediumVip = isVip || canOrderSecondDish;

        final String ITEM_A = "Burger";
        final String ITEM_B = "Supe";
        final String ITEM_C = "Meat";

        System.out.println("1:" + ITEM_A);
        System.out.println("2:" + ITEM_B);
        System.out.println("3:" + ITEM_C);

        int itemIndex = scannerInstance.nextInt();

        // if itemIndex == 1 => ITEM_A
        // if itemIndex == 2 => ITEM_B
        // if itemIndex == 3 => ITEM_C
        //  true ? if true : if false

        // (itemIndex == 1) ? ITEM_A : ITEM_B

        // Anty-pattern
        String itemOrder = (itemIndex == 1) ?
                            ITEM_A :
                (
                    (itemIndex == 2) ?
                    ITEM_B :
                            (
                                (itemIndex == 3) ?
                                        ITEM_C :
                                        "No ITEM"
                            )
                );

        System.out.println("You order : " + itemOrder);

        String itemOrderFromIf = "No Item";
        double itemPrice = 0;

        if(itemIndex == 1) { // true
            itemOrderFromIf = ITEM_A;
            itemPrice = 10;
        }
        else { // false

            if(itemIndex == 2) {
                itemOrderFromIf = ITEM_B;
                itemPrice = 5;
            }
            else {
                if(itemIndex == 3) {
                    itemOrderFromIf = ITEM_C;
                    itemPrice = 12;
                }
                else {
                    itemOrderFromIf = " I am vegan Baby";
                    itemPrice = 1;
                }
            }
        }

        System.out.println("IF Evaluation : ");
        System.out.println(itemOrderFromIf);

    }
}
