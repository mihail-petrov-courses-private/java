import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        System.out.println("Време е за шоу");

        int questionNumber;
        String questionContent;
        double questionPriceAmount;
        String priceCurrency = "BGN";
        int questionPointAmount = 0;

        int playerScoreAmount = 0;

        int initialPriceAmount = 100;

        boolean isApplauseTurnOn = true;
        boolean isActive         = true;
        boolean isAvailable      = true;
        boolean hasCredentials   = false;
        boolean isWinner         = false;

        int totalNumberOfRounds = 4;
        int firstRoundQuestionCount = 10;
        int countOfFirstRoundQuestions = 10;

        int firstRoundQuestionPointAmount = 1;
        int secondRoundQuestionPointAmount = 5;
        int thirdRoundQuestionPointAmount = 10;
        int finalRoundQuestionPointAmount = 50;

        // Количество жокери, в играта
        int hintCount = 3;

        String dayOfTheWeek = "Tursday";
        // Получаваме F ако dayOfTheWeek e Friday
        // в противен случай получаве X

        boolean isMonday    = dayOfTheWeek == "Monday";
        boolean isThuesday  = dayOfTheWeek == "Thuesday";
        boolean isWednesday = dayOfTheWeek == "Wednesday";
        boolean isTursday   = dayOfTheWeek == "Tursday";
        boolean isFriday    = dayOfTheWeek == "Friday";
        String dayOfTheWeekFirstLetter =    isMonday
                                            ? "M"
                                            : isThuesday
                                                ? "Th"
                                                : isWednesday
                                                    ? "W"
                                                    : isTursday
                                                        ? "Tu"
                                                        : isFriday
                                                            ? "F"
                                                            : "X";
        int signatureId     = 1234;
        String checkId      = dayOfTheWeekFirstLetter + signatureId;
        System.out.print("Номера на чека е ");
        System.out.println(checkId);
        String doubleString = 15.5 + "";

        // - лесен
        // -- ако един въпрос е под номер 5 той е лесен
        // - труден въпрос
        // -- ако един въпрос е под над номер 5 той е труден


        questionNumber      = 1;
        questionContent     = "Как се казва треньора на ФК Левски?";
        questionPriceAmount = initialPriceAmount;
        questionPointAmount = firstRoundQuestionPointAmount;
        boolean isQuestionEasy    = questionNumber < 5;
        // String questionType    = isQuestionEasy ? "Лесен въпрос" : "Труден въпрос";
        // String questionType    = (questionNumber > 5) ? "Труден въпрос" : "Лесен въпрос";
        // String questionType    = (questionNumber >= 5) ? "Труден въпрос" : "Лесен въпрос";
        // String questionType    = (hintCount == 0) ? "Труден въпрос" : "Лесен въпрос";
        String questionType       = (hintCount != 3) ? "Труден въпрос" : "Лесен въпрос";
        System.out.print("Въпрос номер ");
        System.out.println(questionNumber);
        System.out.println(questionContent);
        System.out.print("На стойност ");
        System.out.print(questionPriceAmount);
        System.out.print(priceCurrency);
        System.out.print(questionType);


        // Добави стойност към максималното количество точки
        // равна на точките от текущия въпрос
        playerScoreAmount   = (playerScoreAmount + questionPointAmount) + 5;
        System.out.print("Точки събрани до тук : ");
        System.out.print(playerScoreAmount);

        questionNumber      = 2;
        questionContent     = "На колко години е вокалиста на Ахат?";
        questionPriceAmount = 100.5;
        questionPointAmount = secondRoundQuestionPointAmount;
        System.out.print("Въпрос номер");
        System.out.println(questionNumber);
        System.out.println(questionContent);
        System.out.print("На стойност ");
        System.out.print(questionPriceAmount);
        System.out.print(priceCurrency);

        // Добави стойност към максималното количество точки
        // равна на точките от текущия въпрос
        playerScoreAmount   =  questionPointAmount + playerScoreAmount;
        System.out.print("Точки събрани до тук : ");
        System.out.print(playerScoreAmount);


        // за да въвеждам информация ползваме скенер
        // Както System.out.print - рисува
        // скенера - четен
        Scanner customScanner;
        customScanner = new Scanner(System.in);

        System.out.println("*****");
        System.out.println("Моля въведете вашето първо име:");
        String playerFirstName = customScanner.nextLine();
        System.out.println("Моля въведете вашето фамилно име:");
        String playerLastName = customScanner.nextLine();
        System.out.println("Въведете вашата възраст");
        String playerAge = customScanner.nextLine();
        System.out.println("Въведете вашия пол");
        String playerGender = customScanner.nextLine();

        System.out.println("Вие се регистрирахте успешно");
        String fullName = playerFirstName + " " + playerLastName;
        System.out.println(fullName);
        System.out.println("На възраст " + playerAge);
        String genderTitle = (playerGender == "M")
                             ? "мъжки"
                             : (playerGender == "F")
                                ? "женски"
                                : "друг";
        System.out.println("Вашият пол е " + genderTitle);


    }
}
