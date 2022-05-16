import java.util.Random;
import java.util.Scanner;

public class Application {

    // Пространство за променливи с най-дълъг живот
    public static Scanner inputScanner    = new Scanner(System.in);
    public static Random randomGenerator  = new Random();
    public static int stepCounter         = 0;
    public static int failedStepCounter   = 0;
    public static int softwareVersion     = 1;

    // глобални - променливи за емоции
    public static boolean isEmotionPositive     = false;
    public static boolean isEmotionNegative     = false;

    public static boolean isEmotionTragedy      = false;
    public static boolean isEmotionProductivity = false;
    public static boolean isEmotionChaos        = false;
    public static boolean isEmotionFriendly     = false;

    public static boolean isBanizaRecognized    = false;

    public static void loadEmotion() {

        int processInitId           = (randomGenerator.nextInt(10) + 1);
        boolean isEmotionEven       = (processInitId % 2 == 0);
        boolean isEmotionOdd        = !isEmotionEven;

        int emotionSignId           = (randomGenerator.nextInt(100) + 1);
        // 60 - 80 AND % 3 == 0
        isEmotionPositive   = (emotionSignId >= 60)
                                && (emotionSignId <= 80);
        // && (emotionSignId % 3 == 0);

        isEmotionNegative   = (emotionSignId >= 5)
                                && (emotionSignId <= 55);
        //&& (emotionSignId % 5 == 0);

        isEmotionTragedy        = isEmotionEven && isEmotionNegative;
        isEmotionProductivity   = isEmotionEven && isEmotionPositive;
        isEmotionChaos          = isEmotionOdd  && isEmotionNegative;
        isEmotionFriendly       = isEmotionOdd  && isEmotionPositive;
    }

    public static void isRecognized() {

        // разпознай баничката
        int firstRecognitionId  = (randomGenerator.nextInt(6) + 1);
        int secondRecognitionId = (randomGenerator.nextInt(6) + 1);
        int thirdRecognitionId  = (randomGenerator.nextInt(6) + 1);
        int recognitionSum      = firstRecognitionId + secondRecognitionId + thirdRecognitionId;
        isBanizaRecognized      = recognitionSum == stepCounter;
    }

    public static void main(String[] args) {

        final int NECESSARY_NUMBER_OF_STEPS = 3;

        // TODO: Адресираме емоцията - ДЕПРЕСИЯ
        // TODO: Какво да правим когато стигнем режим на самоунищожение

        // Стъпка 1: Инициализиране и стартиране на робота
        // ****
        loadEmotion();

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
        // ****
        while(stepCounter < NECESSARY_NUMBER_OF_STEPS) {

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
                    failedStepCounter++;
                    System.out.println("Стъпка " + stepCounter);
                }
                else {
                    System.out.println("Режим самоунищожение");
                }
            }
        }

        // Стъпка 3: Разпознаване на баничка
        // ****
        while(isEmotionNegative) {
            loadEmotion();
        }

        while(!isBanizaRecognized) {
            isRecognized();
            System.out.println("Опит за разпознаване");
        }

        System.out.println("Баничката е разпозната успешно");

        // Стъпка 4: Взимане на баничка
        // ****
        int takeCoefficientId           = (randomGenerator.nextInt(69) + 1);
        int tokeCoefficientSum          = takeCoefficientId + failedStepCounter;
        boolean isSoftwareUpToDate      = tokeCoefficientSum <= 10;
        boolean isSoftwareOutDated      = !isSoftwareUpToDate;

        if(isSoftwareOutDated) {
            softwareVersion++;
            System.out.println("Вие успешно актуализирахте версията на софтуер Doors в момента сте с " + softwareVersion);
        }

    }
}
