package com.netitjava.units.parent;

import com.netitjava.model.RowCol;

public abstract class Player extends Unit {

	protected Powerup equiptedPowerup;
	
	public Player(int row, int col) {
		super(row, col);
	}

	public void move(RowCol cordinates) {

		this.setRow(cordinates.getRow());
		this.setCol(cordinates.getCol());
	}	
	
	public void equipt(Powerup powerup) {
		this.equiptedPowerup = powerup;
	}
	
	public boolean hasPowerup() {
		return this.equiptedPowerup != null;
	}
	
	public abstract RowCol getDestination(String keyCode);
}
