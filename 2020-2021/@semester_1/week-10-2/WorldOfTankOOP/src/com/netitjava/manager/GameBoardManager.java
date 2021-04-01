package com.netitjava.manager;

import com.netitjava.level.child.BasicLevel;
import com.netitjava.level.child.HardLevel;
import com.netitjava.level.parent.Level;
import com.netitjava.units.*;
import com.netitjava.units.child.Barricade;
import com.netitjava.units.child.EnemyTank;
import com.netitjava.units.child.Hq;
import com.netitjava.units.child.PlayerTank;
import com.netitjava.units.child.Terren;
import com.netitjava.units.parent.Unit;
import com.netitjava.util.*;

public class GameBoardManager {
	
	private final int GAME_BOARD_SIZE	 	= 10;
	private final int GAME_BOARD_FIRST_ROW 	= 0; 
	private final int GAME_BOARD_LAST_ROW;
	private Unit[][] gameBoard;
	
	public GameBoardManager() {

		this.gameBoard = new Unit[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
		this.GAME_BOARD_LAST_ROW =  GAME_BOARD_SIZE - 1;
	}
		
	public void start() {

		this.bootstrap();
		this.render();
	}
	
	private void render() {
		
		for(int row = 0; row < this.GAME_BOARD_SIZE; row++) {
			for(int col = 0; col < this.GAME_BOARD_SIZE; col++) {
				Console.log(this.getGameBoardElement(row, col).getSimbol());
			}
			Console.lognl("");
		}
	}	
		
	private void setGameBoardElement(int row, int col, Unit element) {
		this.gameBoard[row][col] = element;
	}
	
	private Unit getGameBoardElement(int row, int col) {
		return this.gameBoard[row][col];
	}
	
	// TODO: implement Level design
	private void bootstrap() {
		// this.gameBoard = BasicLevel.bootstrap();
		
		// SimpleLevel level 	= new SimpleLevel();
		Level level = new HardLevel();
		this.gameBoard = level.bootstrap();
	}
	
}