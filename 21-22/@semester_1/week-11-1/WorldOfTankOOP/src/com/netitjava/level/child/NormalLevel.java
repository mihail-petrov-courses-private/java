package com.netitjava.level.child;

import com.netitjava.level.parent.Level;
import com.netitjava.units.child.PlayerTank;
import com.netitjava.units.child.Terren;
import com.netitjava.units.parent.Unit;
import com.netitjava.util.Generate;

public class NormalLevel extends Level {

	@Override
	public Unit getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	protected void generateTerren() {

		for(int row = 0; row < GAME_BOARD_SIZE; row++) {
			for(int col = 0; col < GAME_BOARD_SIZE; col++) {
				this.setGameBoardElement(row, col, new Terren(row, col));
			}			
		}	
	}

	@Override
	protected void generateBarricade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void generateHq() {
		// TODO Auto-generated method stub
		
	}

	protected void generatePlayer() {
		
		int positionIndex 	= Generate.random(GAME_BOARD_SIZE);
		Unit element 		= getGameBoardElement(GAME_BOARD_LAST_ROW, positionIndex);
		
		if(this.isTerren(element)) {
			setGameBoardElement(	GAME_BOARD_LAST_ROW, 
										positionIndex, 
										new PlayerTank(GAME_BOARD_LAST_ROW, positionIndex));			
			return;
		}
		
		generatePlayer();
	}

	@Override
	protected void generateEnemy() {
		// TODO Auto-generated method stub
		
	}	
}
