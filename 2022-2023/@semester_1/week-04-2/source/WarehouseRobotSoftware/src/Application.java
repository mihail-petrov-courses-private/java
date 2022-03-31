import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // Пространство за променливи с най-дълъг живот
        Scanner inputScanner    = new Scanner(System.in);
        Random randomGenerator  = new Random();
        int stepCounter         = 0;

        // TODO: Адресираме емоцията - ДЕПРЕСИЯ
        // TODO: Какво да правим когато стигнем режим на самоунищожение

        // Стъпка 1: Инициализиране и стартиране на робота
        int processInitId           = (randomGenerator.nextInt(10) + 1);
        boolean isEmotionEven       = (processInitId % 2 == 0);
        boolean isEmotionOdd        = !isEmotionEven;

        int emotionSignId           = (randomGenerator.nextInt(100) + 1);
        // 60 - 80 AND % 3 == 0
        boolean isEmotionPositive   = (emotionSignId >= 60)
                                        && (emotionSignId <= 80)
                                        && (emotionSignId % 3 == 0);
        // 55 - 55 AND % 5 == 0
        boolean isEmotionNegative   = (emotionSignId >= 5)
                                        && (emotionSignId <= 55)
                                        && (emotionSignId % 5 == 0);

        boolean isEmotionTragedy        = isEmotionEven && isEmotionNegative;
        boolean isEmotionProductivity   = isEmotionEven && isEmotionPositive;
        boolean isEmotionChaos          = isEmotionOdd  && isEmotionNegative;
        boolean isEmotionFriendly       = isEmotionOdd  && isEmotionPositive;

        // Стъпка 1.1: Извеждане на съобщение на база на емоция
        if(isEmotionTragedy) {
            System.out.println("Сега стана страшно");
        }
        else if(isEmotionProductivity) {
            System.out.println("Работа, работа, работа");
        }
        else if(isEmotionChaos) {
            System.out.println("Време е да унищожим всички човеци");
        }
        else if(isEmotionFriendly) {
            System.out.println("Прекрасен ден птичките пеят");
        }
        else {
            System.out.println("Трудно е да си робот :(");
        }



        // Стъпка 2: Изчисляване на успешни и неуспешни крачки
        int moveId                  = (randomGenerator.nextInt(100) + 1);
        boolean isMoveSuccessful    = false;
        if(isEmotionTragedy) { // 1  - 10
            isMoveSuccessful = (moveId <= 10);
        }

        if(isEmotionProductivity) {
            isMoveSuccessful = (moveId >= 2);
        }

        if(isEmotionChaos) {
            isMoveSuccessful = (moveId <= 15);
        }

        if(isEmotionFriendly) {
            isMoveSuccessful = (moveId <= 65);
        }

        // Стъпка 2.1 - успешна или не успешна крачка
        if(isMoveSuccessful) {

            // @ стандартен запис
            // stepCounter = stepCounter + 1;

            // @ комбиниран запис
            // stepCounter += 1;

            // @ оператор за инкрементиране на стойности с 1
            stepCounter++;
            System.out.println("Стъпка " + stepCounter);
        }
        else {
            System.out.println("Въведете окуражително съобщение");
            String message          = inputScanner.nextLine();
            boolean inTragedy       = isEmotionTragedy      && message.equals("Животът не струва.");
            boolean inProductivity  = isEmotionProductivity && message.equals("Разбий ги!");
            boolean inChaos         = isEmotionChaos        && message.equals("Невежеството е благодат.");
            boolean inFriendly      = isEmotionFriendly     && message.equals("Давай, ти си!");
            boolean isSuccessful    = inTragedy || inProductivity || inChaos || inFriendly;

            if(isSuccessful) {
                stepCounter++;
                System.out.println("Стъпка " + stepCounter);
            }
            else {
                System.out.println("Режим самоунищожение");
            }
        }

        // Стъпка 3: Разпознаване на баничка

    }
}
