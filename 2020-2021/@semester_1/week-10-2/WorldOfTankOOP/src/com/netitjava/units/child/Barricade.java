package com.netitjava.units.child;

import com.netitjava.units.parent.Unit;

public class Barricade extends Unit {

	public Barricade(int row, int col) {

		this.setSimbol("#");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(false);
	}	
	
	public Barricade(int row, int col, boolean isBreakable) {

		this.setSimbol("#");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(isBreakable);
	}
}
