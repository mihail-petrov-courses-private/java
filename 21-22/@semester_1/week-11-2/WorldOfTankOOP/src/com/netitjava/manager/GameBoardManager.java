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
	
	private PlayerTank playerReference;
	
	public GameBoardManager() {

		this.gameBoard = new Unit[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
		this.GAME_BOARD_LAST_ROW =  GAME_BOARD_SIZE - 1;
	}
		
	public void start(String dificulty) {

		this.bootstrap(dificulty);
		this.render();
		
		this.startMainGame();
	}
	
	private void startMainGame() {
		
		String actionKey = Console.input("Please enter action: ");
		if(GameKeyManager.isDirectionKey(actionKey)) {
			processActionMove(actionKey);
		}
		
		if(GameKeyManager.isFireKey(actionKey)) {
			processActionFire();
		}
		
		this.render();
		startMainGame();
	}
	

	private void processActionFire() {

		String directionKey = Console.input("Please enter direction: ");
					
		if(GameKeyManager.isDirectionForward(directionKey)) {
			
			int row = this.playerReference.getRow() - 1;
			int col = this.playerReference.getCol();
			for(; row >= 0; row-- ) {
				if(this.getGameBoardElement(row, col).isBreakable()) {

					this.processHit(new RowCol(row, col));
					return;
				}
			}
		}
		
		if(GameKeyManager.isDirectionBackword(directionKey)) {
			
			int row = this.playerReference.getRow() + 1;
			int col = this.playerReference.getCol();
			for(; row < GAME_BOARD_SIZE; row++ ) {
				if(this.getGameBoardElement(row, col).isBreakable()) {

					this.processHit(new RowCol(row, col));
					return;
				}
			}
		}
		
		if(GameKeyManager.isDirectionLeft(directionKey)) {
			
			int row = this.playerReference.getRow();
			int col = this.playerReference.getCol() - 1;
			for(; col >= 0; col-- ) {
				if(this.getGameBoardElement(row, col).isBreakable()) {

					this.processHit(new RowCol(row, col));
					return;
				}
			}
		}
		
		if(GameKeyManager.isDirectionRight(directionKey)) {
			
			int row = this.playerReference.getRow();
			int col = this.playerReference.getCol() + 1;
			for(; col < GAME_BOARD_SIZE; col++ ) {
				if(this.getGameBoardElement(row, col).isBreakable()) {

					this.processHit(new RowCol(row, col));
					return;
				}
			}
		}		
	}
	
	private void processActionMove(String actionKey) {

		RowCol destination = this.playerReference.getDestination(actionKey);
		if(this.isMoveValid(destination)) {
							
			this.transformToTerren(this.playerReference.getRowCol());
			this.setGameBoardElement(destination	, this.playerReference);
			this.playerReference.move(destination);
		}
	}	
	
	private void processHit(RowCol coordinates) {
		this.transformToTerren(coordinates);
	}	
	
	private void transformToTerren(RowCol coordinates) {

		Unit emptySpace 		= new Terren(coordinates);
		this.setGameBoardElement(coordinates	, emptySpace);
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
		this.playerReference 	= (PlayerTank) level.getPlayer(); 
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