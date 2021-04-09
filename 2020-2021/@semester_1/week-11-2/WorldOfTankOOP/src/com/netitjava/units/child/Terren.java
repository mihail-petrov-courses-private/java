package com.netitjava.units.child;

import com.netitjava.model.RowCol;
import com.netitjava.units.parent.Unit;

public class Terren extends Unit {

	public Terren(int row, int col) {

		this.setSimbol(".");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(false);
		this.setPassable(true);
	}
	
	public Terren(RowCol coordinates) {

		this.setSimbol(".");
		this.setRow(coordinates.getRow());
		this.setCol(coordinates.getCol());
		this.setBreakable(false);
		this.setPassable(true);		
	}
	
}
