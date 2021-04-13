package com.netitjava;

import com.netitjava.level.factory.LevelFactory;
import com.netitjava.manager.GameBoardManager;
import com.netitjava.util.Console;

public class Application {

	public static String transformNumberDificultyToStringDificulty(int dificultyIndex) {
		
		if(dificultyIndex == 1) return LevelFactory.EASY_LEVEL;
		if(dificultyIndex == 2) return LevelFactory.NORMAL_LEVEL;
		if(dificultyIndex == 3) return LevelFactory.HARD_LEVEL;
		
		return LevelFactory.NORMAL_LEVEL;
	}
	
	
	public static void main(String[] args) {
		
		Console.log("Pleace select game dificulty");
		Console.log("(1) Easy");
		Console.log("(2) Normal");
		Console.log("(3) Hard");
		int dificultyIndex = Console.inputInt();
		String dificultyComand = transformNumberDificultyToStringDificulty(dificultyIndex);
		
		// TODO: remove the string infavor of something else
		(new GameBoardManager()).start(dificultyComand);
		
//		Standrand long initializiation and execute
//		GameBoardManager gameBoard = new GameBoardManager();
//		gameBoard.bootstrap();
		
	}	
}
