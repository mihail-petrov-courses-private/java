package com.netitjava.level.child;

import com.netitjava.level.parent.Level;
import com.netitjava.units.child.Terren;

public class HardLevel extends Level {

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

	@Override
	protected void generatePlayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void generateEnemy() {
		// TODO Auto-generated method stub
		
	}

	
}
