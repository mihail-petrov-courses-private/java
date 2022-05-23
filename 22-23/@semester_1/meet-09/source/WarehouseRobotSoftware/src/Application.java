import java.util.Random;
import java.util.Scanner;

public class Application {

    // глобални - променливи функционални
    public static Scanner inputScanner    = new Scanner(System.in);
    public static Random randomGenerator  = new Random();
    public static int stepCounter         = 0;
    public static int failedStepCounter   = 0;
    public static int softwareVersion     = 1;

    // глобални - променливи за жизнен цикъл на програмата
    public static boolean isAlive                       = true;
    public static final int PROCESS_INIT_ID             = 1;
    public static final int PROCESS_MOVE_FIRST_ID       = 2;
    public static final int PROCESS_MOVE_SECOND_ID      = 3;
    public static final int PROCESS_TAKE_ID             = 4;
    public static final int PROCESS_HEAL_DEPRESSION_ID  = 5;
    public static final int PROCESS_TURN_OFF_ID         = 6;
    public static int prevProcess                       = PROCESS_INIT_ID;
    public static int currentProcess                    = PROCESS_INIT_ID;

    // глобални - променливи за емоции
    public static boolean isEmotionPositive     = false;
    public static boolean isEmotionNegative     = false;

    public static boolean isEmotionTragedy      = false;
    public static boolean isEmotionProductivity = false;
    public static boolean isEmotionChaos        = false;
    public static boolean isEmotionFriendly     = false;
    public static boolean isEmotionDepression   = false;
    public static boolean hasRegularEmotion     = false;

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

        // isEmotionDepression         =
        // isEmotionTragedy         == false   &&
        // isEmotionProductivity    == false   &&
        // isEmotionChaos           == false   &&
        // isEmotionFriendly        == false

        hasRegularEmotion       =   isEmotionTragedy        ||
                                    isEmotionProductivity   ||
                                    isEmotionChaos          ||
                                    isEmotionFriendly;

        isEmotionDepression = !hasRegularEmotion;

    }

    public static void isRecognized() {

        // разпознай баничката
        int firstRecognitionId  = (randomGenerator.nextInt(6) + 1);
        int secondRecognitionId = (randomGenerator.nextInt(6) + 1);
        int thirdRecognitionId  = (randomGenerator.nextInt(6) + 1);
        int recognitionSum      = firstRecognitionId + secondRecognitionId + thirdRecognitionId;
        isBanizaRecognized      = recognitionSum == stepCounter;
    }

    // Метод - за преминаване към следваща фаза
    public static void goToNextProcess() {

        if(currentProcess == PROCESS_INIT_ID) {
            currentProcess  = (hasRegularEmotion) ? PROCESS_MOVE_FIRST_ID : PROCESS_HEAL_DEPRESSION_ID;
            prevProcess     = PROCESS_INIT_ID;
        }

        if(currentProcess == PROCESS_MOVE_FIRST_ID) {
            currentProcess  = PROCESS_TAKE_ID;
            prevProcess     = PROCESS_MOVE_FIRST_ID;
        }

        if(currentProcess == PROCESS_MOVE_SECOND_ID) {
            currentProcess  = PROCESS_TURN_OFF_ID;
            prevProcess     = PROCESS_MOVE_SECOND_ID;
        }

        if(currentProcess == PROCESS_TAKE_ID) {
            currentProcess  = PROCESS_MOVE_SECOND_ID;
            prevProcess     = PROCESS_TAKE_ID;
        }

        if(currentProcess == PROCESS_HEAL_DEPRESSION_ID) {

            if(prevProcess == PROCESS_INIT_ID) {
                currentProcess = PROCESS_MOVE_FIRST_ID;
            }

            if(prevProcess == PROCESS_TAKE_ID) {
                currentProcess = prevProcess;
            }

            prevProcess = PROCESS_HEAL_DEPRESSION_ID;
        }
    }

    // ПРОЦЕС - СТЪПКА: лечение на депресия
    public static void processHealDepression() {

        final int HAPPY_CHANCE_ID   = 1;
        final int SAD_CHANCE_ID     = 2;

        System.out.println("Робота е в депресия - започнете лечение");

        // Стъпка 1
        // Питаме робота как е
        String questionAnswer       = inputScanner.nextLine();
        boolean isQuestionCorrect   = questionAnswer.equals("Как си");

        if(isQuestionCorrect) {

            int processChanceId     = (randomGenerator.nextInt(2) + 1);
            boolean isRobotHappy    = (processChanceId == HAPPY_CHANCE_ID);
            boolean isRobotSad      = (processChanceId == SAD_CHANCE_ID);

            if(isRobotHappy) {
                String isRobotHappyQuestionAnswer = inputScanner.nextLine();
                boolean isAnswerCorrect           = isRobotHappyQuestionAnswer.equals("Хайде да работим");

                if(isAnswerCorrect) {
                    loadEmotion();
                }
            }

            if(isRobotSad) {

                System.out.println("Не ми се живее");
                System.out.println("Намислих си число, кое число си намислих ");
                int dealNumberId        = (randomGenerator.nextInt(1000) + 1);
                int dealNumberGuessId   = inputScanner.nextInt();
                boolean isDealDone      = dealNumberGuessId >= dealNumberId;

                if(isDealDone) {
                    loadEmotion();
                }
                else {
                    processHealDepression();
                }
            }
        }

    }

    // ПРОЦЕС - СТЪПКА: Инициализиране и стартиране на робота
    public static void processInit() {

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
    }

    // ПРОЦЕС - СТЪПКА: Придвижване на робота
    public static void processMove() {

        final int NECESSARY_NUMBER_OF_STEPS = 3;

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
    }

    // ПРОЦЕС - СТЪПКА: Разпознаване и взимане на баничка
    public static void processRecognizeAndTake() {

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

    // ПРОЦЕС - СТЪПКА: Изключване на робота
    public static void processTurnOff() {

        System.out.println("Сбогом жесток свят");
        isAlive = false;
    }

    public static void main(String[] args) {

        // ЖИЖНЕН ЦИКЪЛ НА РОБОТА - докато - не се е самоунищожил
        while (isAlive) {

            if(currentProcess == PROCESS_INIT_ID) {
                System.out.println("ПРОЦЕС - СТЪПКА : ИНИЦИАЛИЗАЦИЯ");
                System.out.println("===============================");
                processInit();
            }

            if(currentProcess == PROCESS_MOVE_FIRST_ID) {
                System.out.println("ПРОЦЕС - СТЪПКА : ПРИДВИЖВАНЕ ДО ЦЕХА");
                System.out.println("===============================");
                processMove();
            }

            if(currentProcess == PROCESS_MOVE_SECOND_ID) {
                System.out.println("ПРОЦЕС - СТЪПКА : ПРИДВИЖВАНЕ ДО СКЛАДА");
                System.out.println("===============================");
                processMove();
            }

            if(currentProcess == PROCESS_TAKE_ID) {
                System.out.println("ПРОЦЕС - СТЪПКА : РАЗПОЗНАВАНЕ И ВЗИМАНЕ");
                System.out.println("===============================");
                processRecognizeAndTake();
            }

            if(currentProcess == PROCESS_HEAL_DEPRESSION_ID) {
                System.out.println("ПРОЦЕС - СТЪПКА : ЛЕЧЕНИЕ НА ДЕПРЕСИЯ");
                System.out.println("===============================");
                processHealDepression();
            }

            if(currentProcess == PROCESS_TURN_OFF_ID) {
                System.out.println("ПРОЦЕС - СТЪПКА : ИЗКЛЮЧВАНЕ");
                System.out.println("===============================");
                processTurnOff();
            }

            goToNextProcess();
        }
    }
}
