package com.netitjava.manager;

import com.netitjava.units.*;
import com.netitjava.util.*;

public class GameBoardManager {
	
	private final int GAME_BOARD_SIZE	 	= 10;
	private final int GAME_BOARD_FIRST_ROW 	= 0; 
	private final int GAME_BOARD_LAST_ROW;
	private Object[][] gameBoard;
	
	public GameBoardManager() {

		this.gameBoard = new Object[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
		this.GAME_BOARD_LAST_ROW =  GAME_BOARD_SIZE - 1;
	}
		
	public void start() {

		this.bootstrap();
		this.render();
	}
	
	private void render() {
		
		for(int row = 0; row < this.GAME_BOARD_SIZE; row++) {
			for(int col = 0; col < this.GAME_BOARD_SIZE; col++) {
				
				if(gameBoard[row][col] instanceof Terren) {
					Console.log(((Terren) this.gameBoard[row][col]).getSimbol());
				}
				
				if(gameBoard[row][col] instanceof Barricade) {
					Console.log(((Barricade) this.gameBoard[row][col]).getSimbol());
				}
				
				if(gameBoard[row][col] instanceof Hq) {
					Console.log(((Hq) this.gameBoard[row][col]).getSimbol());
				}
				
				if(gameBoard[row][col] instanceof PlayerTank) {
					Console.log(((PlayerTank) this.gameBoard[row][col]).getSimbol());
				}				
				
				if(gameBoard[row][col] instanceof EnemyTank) {
					Console.log(((EnemyTank) this.gameBoard[row][col]).getSimbol());
				}								
			}
			Console.lognl("");
		}
	}	
		
	private void setGameBoardElement(int row, int col, Object element) {
		this.gameBoard[row][col] = element;
	}
	
	private Object getGameBoardElement(int row, int col) {
		return this.gameBoard[row][col];
	}
	
	private void generateTerren() {
		
		for(int row = 0; row < GAME_BOARD_SIZE; row++) {
			for(int col = 0; col < GAME_BOARD_SIZE; col++) {
				this.setGameBoardElement(row, col, new Terren(row, col));
			}
		}				
	}
	
	private static boolean isBarikadeProcessable() {
		
		int processableCoeficient 	= Generate.random(11);
		
		return !(processableCoeficient < 8 && 
			   processableCoeficient > 1);
	}	
	
	private void generateBarricade() {

		final int START_ROW_BARIKADE_ZONE 	= 3; 
		final int END_ROW_BARIKADE_ZONE 	= (GAME_BOARD_SIZE - 3);
		
		for(int row = START_ROW_BARIKADE_ZONE; row < END_ROW_BARIKADE_ZONE; row++) {
			for(int col = 0; col < GAME_BOARD_SIZE; col++) {
				
				if(isBarikadeProcessable()) {
					this.setGameBoardElement(row, col, new Barricade(row, col));
				}
			}
		}
	}	
	
	private void generateHq() {
		
		int positionIndex 		= Generate.random(this.GAME_BOARD_SIZE);
		this.setGameBoardElement(	this.GAME_BOARD_LAST_ROW, 
									positionIndex, 
									new Hq(this.GAME_BOARD_LAST_ROW, positionIndex));
	}	
	
	private boolean isTerren(Object element) {
		return element instanceof Terren;
	}
	
	
	private void generatePlayer() {
			
		int positionIndex 	= Generate.random(this.GAME_BOARD_SIZE);
		Object element 		= this.getGameBoardElement(this.GAME_BOARD_LAST_ROW, positionIndex);
		
		if(this.isTerren(element)) {
			this.setGameBoardElement(	this.GAME_BOARD_LAST_ROW, 
										positionIndex, 
										new PlayerTank(this.GAME_BOARD_LAST_ROW, positionIndex));			
			return;
		}
		
		this.generatePlayer();
	}		
	
	private void generateEnemy() {
		
		int positionIndex 	= Generate.random(this.GAME_BOARD_SIZE);
		Object element 		= this.getGameBoardElement(this.GAME_BOARD_LAST_ROW, positionIndex);
		
		if(this.isTerren(element)) {
			this.setGameBoardElement(	this.GAME_BOARD_FIRST_ROW, 
										positionIndex, 
										new EnemyTank(this.GAME_BOARD_FIRST_ROW, positionIndex));			
			return;
		}
		
		this.generateEnemy();
	}
	
	// TODO: implement Level design
	private void bootstrap() {

		this.generateTerren();
		this.generateBarricade();
		this.generateHq();
		this.generatePlayer();
		
		this.generateEnemy();
		this.generateEnemy();
		this.generateEnemy();
	}
	
}