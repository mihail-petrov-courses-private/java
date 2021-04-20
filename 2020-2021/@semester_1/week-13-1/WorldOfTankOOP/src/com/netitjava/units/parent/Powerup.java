package com.netitjava.units.parent;

public  abstract class Powerup extends Unit {

	public Powerup(int row, int col) {
		
		super(row, col);
		this.setPassable(true);
	}	
}
