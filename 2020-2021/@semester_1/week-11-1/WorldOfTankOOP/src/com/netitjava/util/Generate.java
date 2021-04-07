package com.netitjava.util;

import java.util.Random;

public class Generate {
	
	public static int random(int bound) {
		
		Random randomGenerator 	= new Random();
		return randomGenerator.nextInt(bound);
	}
}
