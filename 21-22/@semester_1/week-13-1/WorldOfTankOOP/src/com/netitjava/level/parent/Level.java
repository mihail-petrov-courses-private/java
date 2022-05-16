package com.netitjava.level.parent;

import com.netitjava.board.GameBoard;
import com.netitjava.units.child.Terren;
import com.netitjava.units.parent.Unit;

public abstract class Level {
	
	protected final int GAME_BOARD_SIZE	 	= 10;
	protected final int GAME_BOARD_FIRST_ROW 	= 0; 
	protected final int GAME_BOARD_LAST_ROW	= 9;
	protected GameBoard gameBoard;
	
	public GameBoard bootstrap() {
		
		this.gameBoard = new GameBoard(GAME_BOARD_SIZE, GAME_BOARD_SIZE);
		
		this.generateTerren();
		this.generateBarricade();
		this.generateHq();
		this.generatePlayer();
		this.generateEnemy();	
		this.generatePowerup();
		
		return this.gameBoard;
	}
		
	protected boolean isTerren(Unit element) {
		return element instanceof Terren;
	}	
	
	protected abstract void generateTerren();
	protected abstract void generateBarricade();
	protected abstract void generateHq();
	protected abstract void generatePlayer();
	protected abstract void generateEnemy();
	protected abstract void generatePowerup();
}
