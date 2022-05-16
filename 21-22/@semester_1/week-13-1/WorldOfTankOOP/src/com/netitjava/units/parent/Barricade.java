package com.netitjava.units.parent;

public abstract class Barricade extends Unit {

	public Barricade(int row, int col) {

		super(row, col);
		this.setBreakable(false);
	}	
	
	public Barricade(int row, int col, boolean isBreakable) {

		super(row, col);
		this.setBreakable(isBreakable);
		this.setPassable(false);
	}
}
