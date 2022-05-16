package util;

import java.util.Scanner;

public class Console {

	public static void log(String message) {
		System.out.println(message);
	}

	public static int promptInt() {
		
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}	
	
	public static int promptInt(String message) {
		
		log(message);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
}
