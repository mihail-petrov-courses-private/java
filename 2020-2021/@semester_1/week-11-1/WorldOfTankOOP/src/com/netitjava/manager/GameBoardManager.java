package com.netitjava.manager;

import com.netitjava.level.child.BasicLevel;
import com.netitjava.level.child.HardLevel;
import com.netitjava.level.manager.LevelManager;
import com.netitjava.level.parent.Level;
import com.netitjava.model.RowCol;
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
	
	private Unit playerReference;
	
	public GameBoardManager() {

		this.gameBoard = new Unit[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
		this.GAME_BOARD_LAST_ROW =  GAME_BOARD_SIZE - 1;
	}
		
	public void start(String dificulty) {

		this.bootstrap(dificulty);
		this.render();
	}
	
	private void startMainGame() {
		
		String actionKey = Console.input("Please enter action: ");
		if(GameKeyManager.isDirectionKey(actionKey)) {
			
			// * is the move valid 		- Player - guest
			// TODO: convert key code into direction
			RowCol distination = ((PlayerTank)this.playerReference).getDestination(actionKey);
			
			// * is the move possible 	- GameBoard - host
		}
	}
	
	
	private void render() {
		
		for(int row = 0; row < this.GAME_BOARD_SIZE; row++) {
			for(int col = 0; col < this.GAME_BOARD_SIZE; col++) {
				Console.log(this.getGameBoardElement(row, col).getSimbol());
			}
			Console.lognl("");
		}
	}	
	
	private void setGameBoardElement(RowCol coordinates, Unit element) {
		this.gameBoard[coordinates.getRow()][coordinates.getCol()] = element;
	}	
	
	private void setGameBoardElement(int row, int col, Unit element) {
		this.gameBoard[row][col] = element;
	}
	
	private Unit getGameBoardElement(RowCol destination) {
		return this.gameBoard[destination.getRow()][destination.getCol()];
	}
	
	private Unit getGameBoardElement(int row, int col) {
		return this.gameBoard[row][col];
	}	
	
	// TODO: implement Level design
	private void bootstrap(String dificulty) {
		
		//TODO: Create dynamic object for storing LevelConfiguration
		Level level 			= LevelManager.bootstrap(dificulty);
		this.gameBoard 			= level.bootstrap();
		this.playerReference 	= level.getPlayer(); 
	}
	
	// TODO: check if the whole destination is passable
	private boolean isMoveValid(RowCol destination) {
		
		try {
			Unit element = this.getGameBoardElement(destination);
			return element.isPassable();
		}
		catch (Exception e) {
			return false;
		}
	}	
}