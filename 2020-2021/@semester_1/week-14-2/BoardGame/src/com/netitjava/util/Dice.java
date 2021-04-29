package com.netitjava.util;

import java.util.Random;

public final class Dice {
	
	private Dice() {
		
	}
	
	public static int six() {
		return throow(6);
	}
	
	private static int throow(int upperBound) {
	
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(upperBound) + 1;
	}

}
