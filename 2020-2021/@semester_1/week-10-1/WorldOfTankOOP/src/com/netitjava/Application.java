package com.netitjava;

import com.netitjava.manager.GameBoardManager;

public class Application {
	
	public static void main(String[] args) {
		
		(new GameBoardManager()).start();
		
//		Standrand long initializiation and execute
//		GameBoardManager gameBoard = new GameBoardManager();
//		gameBoard.bootstrap();
		
	}	
}
