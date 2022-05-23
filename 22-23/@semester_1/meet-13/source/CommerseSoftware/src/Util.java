public class Util {

    public static String reverseString(String inputString) {

        // Колко букви имам в низа ?
        int numberOfLettersInInputString    = inputString.length(); // 5
        int numberOfIterations              = 0;
        int charPointer                     =  numberOfLettersInInputString - 1;
        String resultString                 = "";

        while(numberOfIterations < numberOfLettersInInputString) {

            char letter =  inputString.charAt(charPointer);
            resultString += letter;

            // увеличавам стойността на numberOfIterations
            numberOfIterations++;
            charPointer--;
        }

        return resultString;
    }

    // -> ABCDE
    // -> EDCBA
    public static String reverseStringWithFor(String inputString) {

        // Колко букви имам в низа ?
        int numberOfLettersInInputString    = inputString.length(); // 5
        // int numberOfIterations              = 0;
        int charPointer                     =  numberOfLettersInInputString - 1;
        String resultString                 = "";

        // 3 различни групи код за управление на цикъла:
        // 1 - инициализация на брояч;
        // --> по традиция основния брояч се назовава с i
        // --> по традиция подпомагащия брояч се назовава с j
        // 2 - проверка на условие; (до кога ще въртим цикъла)
        // 3 - управление на стъпката на брояча.
        for(int i = 0, j = inputString.length() - 1; i < inputString.length(); i++, j--) {
            char letter =  inputString.charAt(j);
            resultString += letter;
        }

        // ***
        for(int i = inputString.length() - 1; i >= 0; i--) {

            char letter =  inputString.charAt(i);
            resultString += letter;
        }

        return resultString;
    }
}

