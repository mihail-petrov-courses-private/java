package com.netitjava.units.child;

import com.netitjava.manager.GameKeyManager;
import com.netitjava.model.RowCol;
import com.netitjava.units.parent.Player;
import com.netitjava.units.parent.Unit;

public class PlayerTank extends Player  {
	
	public PlayerTank(int row, int col) {

		this.setSimbol("%");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(true);
		this.setPassable(false);
	}
		
	public void move(int row, int col) {

		this.setRow(row);
		this.setCol(col);
	}	
	
	// TODO: Refactor in direction way
	public RowCol getDestination(String keyCode) {
		
		int destinationRow = this.getDestinationRow(keyCode);
		int destinationCol = this.getDestinationCol(keyCode);
		return new RowCol(destinationRow, destinationCol);
	}
	
	// TODO: Add exception handling
	private int getDestinationRow(String direction) {
		
		if(direction.equals(GameKeyManager.FORWARD	)) return this.getRow() - 1;
		if(direction.equals(GameKeyManager.BACKWARD	)) return this.getRow() + 1;
		return this.getRow();
	}
	
	private int getDestinationCol(String direction) {
		
		if(direction.equals(GameKeyManager.LEFT		)) return this.getCol() - 1;
		if(direction.equals(GameKeyManager.RIGHT	)) return this.getCol() + 1;
		return this.getCol();		
	}	
}
