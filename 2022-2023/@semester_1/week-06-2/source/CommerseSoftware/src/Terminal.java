import java.util.Scanner;

public class Terminal {

    public static int input() {

        Scanner inputScanner = new Scanner(System.in);
        return inputScanner.nextInt();
    }

    public static void output(String outputMessage) {
        System.out.println(outputMessage);
    }

    public static void output(double outputMessage) {
        System.out.println(outputMessage);
    }
}
