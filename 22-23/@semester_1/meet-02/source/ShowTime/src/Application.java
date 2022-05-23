public class Application {

    public static void main(String[] args) {

        System.out.println("Време е за шоу");

        // Един въпрос - се състои от:
        // - номер на въпроса - реализирано
        // - текст на въпроса - реализирано
        // - сума на въпроса
        // - валута на сумата
        // - точков актив на текущия въпрос

        // 1. Типове данни - int .
        // пази ЦЯЛО число
        int questionNumber;

        // 1. Типове данни - String .
        // пази ТЕКСТ с произволна дължина
        String questionContent;

        // 1. Типове данни - double
        // пази ДРОБНО число
        double questionPriceAmount;
        String priceCurrency = "BGN";
        int questionPointAmount;

        int initialPriceAmount = 100;

        // 1. Типове данни - boolean
        // пази БУЛЕВА стойност
        // 1 -> ИСТИНА -> TRUE   -> on
        // 0 -> ЛЪЖА   -> FALSE  -> off
        boolean isApplauseTurnOn = true;
        boolean isActive         = true;
        boolean isAvailable      = true;
        boolean hasCredentials   = false;
        boolean isWinner         = false;

        // Задача 1
        int totalNumberOfRounds = 4;
        // лошо име на променлива - не описва стойността
        // - не дава информация какво съдържа
        int firstRound  = 10;
        // - по добри версии на горната променлива
        int firstRoundQuestionCount = 10;
        int countOfFirstRoundQuestions = 10;
        // ----
        int firstRoundQuestionPointAmount = 1;
        int secondRound = 7;
        int secondRoundQuestionPointAmount = 5;
        int thirdRound  = 5;
        int thirdRoundQuestionPointAmount = 10;
        int finalRound  = 1;
        int finalRoundQuestionPointAmount = 50;

        // невалидна декларация на контейнер
        // ползваме само букви от a-z A-Z
        // int 1question;
        questionNumber = 1;
        questionContent = "Как се казва треньора на ФК Левски?";
        questionPriceAmount = initialPriceAmount;
        questionPointAmount = firstRoundQuestionPointAmount;
        System.out.print("Въпрос номер ");
        System.out.println(questionNumber);
        System.out.println(questionContent);
        System.out.print("На стойност ");
        System.out.print(questionPriceAmount);
        System.out.print(priceCurrency);

        questionNumber = 2;
        questionContent = "На колко години е вокалиста на Ахат?";
        questionPriceAmount = 100.5;
        questionPointAmount = secondRoundQuestionPointAmount;
        System.out.print("Въпрос номер ");
        System.out.println(questionNumber);
        System.out.println(questionContent);
        System.out.print("На стойност ");
        System.out.print(questionPriceAmount);
        System.out.print(priceCurrency);
    }
}
