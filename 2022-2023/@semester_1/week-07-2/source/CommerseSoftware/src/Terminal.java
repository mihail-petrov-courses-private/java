import java.util.Scanner;
import java.util.SplittableRandom;

public class Terminal {

    static Scanner inputScanner = new Scanner(System.in);

    public static int input() {
        return inputScanner.nextInt();
    }

    public static double inputDouble() {
        return inputScanner.nextDouble();
    }

    public static String inputString() {
        return inputScanner.next();
    }

    public static int input(String message) {

        Terminal.output(message);
        return Terminal.input();
    }

    public static double inputDouble(String message) {

        Terminal.output(message);
        return Terminal.inputDouble();
    }

    public static String inputString(String message) {

        Terminal.output(message);
        return Terminal.inputString();
    }

    public static void output(String outputMessage) {
        System.out.println(outputMessage);
    }

    public static void output(double outputMessage) {
        System.out.println(outputMessage);
    }
}
