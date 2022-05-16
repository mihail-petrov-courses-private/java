package com.netitjava.level.child;

import com.netitjava.level.parent.Level;
import com.netitjava.units.child.EnemyTank;
import com.netitjava.units.child.Hq;
import com.netitjava.units.child.PlayerTank;
import com.netitjava.units.child.Terren;
import com.netitjava.units.child.barricades.BreakableBaricade;
import com.netitjava.units.child.barricades.UnbreakableBaricade;
import com.netitjava.units.child.powerup.UltimatePowerUp;
import com.netitjava.units.parent.Barricade;
import com.netitjava.units.parent.Player;
import com.netitjava.units.parent.Unit;
import com.netitjava.util.Generate;

public class BasicLevel extends Level {
	
	protected void generateTerren() {
		
		for(int row = 0; row < GAME_BOARD_SIZE; row++) {
			for(int col = 0; col < GAME_BOARD_SIZE; col++) {
				this.gameBoard.setGameBoardElement(row, col, new Terren(row, col));
			}
		}				
	}
		
	protected void generateBarricade() {

		final int START_ROW_BARIKADE_ZONE 	= 3; 
		final int END_ROW_BARIKADE_ZONE 	= (GAME_BOARD_SIZE - 3);
		
		for(int row = START_ROW_BARIKADE_ZONE; row < END_ROW_BARIKADE_ZONE; row++) {
			for(int col = 0; col < GAME_BOARD_SIZE; col++) {
				
				if(isBarikadeProcessable()) {
					this.gameBoard.setGameBoardElement(row, col, getBarricade(row, col));
				}
			}
		}
	}		
	
	protected void generateHq() {
		
		int positionIndex 		= Generate.random(GAME_BOARD_SIZE);
		this.gameBoard.setGameBoardElement(GAME_BOARD_LAST_ROW, positionIndex, new Hq(GAME_BOARD_LAST_ROW, positionIndex));
	}	
		
	protected void generatePlayer() {
			
		int positionIndex 	= Generate.random(GAME_BOARD_SIZE);
		Unit element = this.gameBoard.getGameBoardElement(GAME_BOARD_LAST_ROW, positionIndex);
		
		if(isTerren(element)) {
			
			Player entity = new PlayerTank(GAME_BOARD_LAST_ROW, positionIndex);
			this.gameBoard.setPlayer(GAME_BOARD_LAST_ROW, positionIndex, entity);
			return;
		}
		
		generatePlayer();
	}
	
	protected void generateEnemy() {
		
		int positionIndex 	= Generate.random(GAME_BOARD_SIZE);
		Unit element 		= this.gameBoard.getGameBoardElement(GAME_BOARD_LAST_ROW, positionIndex);
		
		if(isTerren(element)) {
			
			Unit entity = new EnemyTank(GAME_BOARD_FIRST_ROW, positionIndex);
			this.gameBoard.setGameBoardElement(GAME_BOARD_FIRST_ROW, positionIndex, entity);
			return;
		}
		
		generateEnemy();
	}
	
	@Override
	protected void generatePowerup() {
		
		final int row = GAME_BOARD_LAST_ROW - 1;
		final int col = 0;
		this.gameBoard.setGameBoardElement(row, 
										   col, 
										   new UltimatePowerUp(row, col));
	}	
	
	private boolean isBarikadeProcessable() {
		
		int processableCoeficient 	= Generate.random(11);
		
		return !(processableCoeficient < 8 && 
			     processableCoeficient > 1);
	}
	
	private Barricade getBarricade(int row, int col) {
		
		int processableCoeficient 	= Generate.random(11);
		
		if(processableCoeficient > 1 && processableCoeficient < 4) {
			return new UnbreakableBaricade(row, col);
		}
		
		return new BreakableBaricade(row, col);
	}
}
