package com.netitjava.util;

import java.util.Scanner;

public final class Console {
	
	private Console() {
		
	}
	
	public static void log(String message) {
		System.out.print(message);
	}
	
	public static void logln(String message) {
		System.out.println(message);
	}	

	public static String promtString() {
		
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}	
	
	public static String promtString(String message) {
		
		log(message);
		return promtString();
	}
	
	public static int promtInt() {
		
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}	
	
	public static int promtInt(String message) {
		
		log(message);
		return promtInt();
	}	
	
}