package com.netitjava.gameboard;

import com.netitjava.util.Console;

// Singleton
public class GameBoard {

	private static GameBoard internalInstance = null;
	
	private final int ROW_COUNT = 7;
	private final int COL_COUNT = 9;	
	private GameBoardObject[][] collection = null;
	
	private  GameBoard() {
		collection = new GameBoardObject[ROW_COUNT][COL_COUNT];	
	}
	
	public static GameBoard getInstance() {
		
		if(internalInstance == null) {
			internalInstance = new GameBoard();
		}
		
		return internalInstance;
	}
	
	public GameBoardObject getElement(int row, int col) {
		return collection[row][col];
	}	

	public void render() {

		for(int row = 0; row < ROW_COUNT; row++) {
			for(int col = 0; col < COL_COUNT; col++) {
				Console.log(collection[row][col].render());
			}
			Console.logln("");
		}
	}	
	
	
	public void setElement(int row, int col, GameBoardObject element) {
		collection[row][col] = element;
	}
}
