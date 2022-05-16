package com.netitjava.level.parent;

import com.netitjava.units.parent.Unit;

public abstract class Level {
	
	protected final int GAME_BOARD_SIZE	 	= 10;
	protected final int GAME_BOARD_FIRST_ROW 	= 0; 
	protected final int GAME_BOARD_LAST_ROW	= 9;
	protected Unit[][] gameBoard;
	
	public Unit[][] bootstrap() {
		
		this.gameBoard = new Unit[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
		
		this.generateTerren();
		this.generateBarricade();
		this.generateHq();
		this.generatePlayer();
		this.generateEnemy();		
		
		return this.gameBoard;
	}
	
	protected void setGameBoardElement(int row, int col, Unit element) {
		this.gameBoard[row][col] = element;
	}
	
	protected Unit getGameBoardElement(int row, int col) {
		return this.gameBoard[row][col];
	}		
		
	protected abstract void generateTerren();
	protected abstract void generateBarricade();
	protected abstract  void generateHq();
	protected abstract  void generatePlayer();
	protected abstract  void generateEnemy();
}
