package com.netitjava.manager;

public class GameKeyManager {

	public static final String FORWARD 		= "w";
	public static final String BACKWARD 	= "s";
	public static final String LEFT 		= "a";
	public static final String RIGHT 		= "d";
	public static final String FIRE 		= "f";
	
	public static boolean isDirectionKey(String keyCodeParameter) {
		
		return 	process(keyCodeParameter).equals(FORWARD) 	||
				process(keyCodeParameter).equals(LEFT) 	||
				process(keyCodeParameter).equals(BACKWARD) ||
				process(keyCodeParameter).equals(RIGHT);
	}
	
	public static boolean isFireKey(String keyCodeParameter) {
		
		return 	process(keyCodeParameter).equals(FIRE);
	}
	
	private static String process(String keyCodeParameter) {
		return keyCodeParameter.toLowerCase(); 
	}
}
