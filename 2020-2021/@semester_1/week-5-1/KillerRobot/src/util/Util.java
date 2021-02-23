package util;

public class Util {

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}
	
	public static boolean isOdd(int number) {
		return !isEven(number);
	}
}
