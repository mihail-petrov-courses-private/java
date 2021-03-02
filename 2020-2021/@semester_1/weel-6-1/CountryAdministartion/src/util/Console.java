package util;

import java.util.Scanner;

public class Console {
	
	public static void log(String message) {
		System.out.println(message);
	}
	
	public static void log(int message) {
		System.out.println(message);
	}
	
	public static String inputString() { // inputString
		
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}	
	
	public static String inputString(String message) { // inputString_String
		
		log(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
		
	public static int inputInt() {
		
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	public static int inputInt(String message) {
		
		log(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}	
	
}
