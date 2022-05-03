package util;

import java.util.Scanner;

public class Terminal {

    private static Scanner inputScanner = new Scanner(System.in);

    public static void output(String data) {
        System.out.println(data);
    }

    public static int inputInt() {
        return inputScanner.nextInt();
    }

    public static int inputInt(String message) {

        output(message);
        return inputInt();
    }

    public static String inputString() {
        return inputScanner.next();
    }

    public static String inputString(String message) {

        output(message);
        return inputScanner.next();
    }

}
