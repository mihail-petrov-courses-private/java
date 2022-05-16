package util;

import java.util.Scanner;

public class Console {
	
	public static void log(String message) {
		System.out.println(message);
	}	

	public static String promtString() {
		
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}	
	
	public static String promtString(String message) {
		
		// Console.log(message);
		log(message);
		
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
}