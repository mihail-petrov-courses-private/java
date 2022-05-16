package com.netitjava.units.child;

import com.netitjava.model.RowCol;
import com.netitjava.units.parent.Unit;

public class Terren extends Unit {

	public Terren(int row, int col) {

		super(row, col);
		this.setBreakable(false);
		this.setPassable(true);
	}
	
	public Terren(RowCol destination) {

		super(destination);
		this.setBreakable(false);
		this.setPassable(true);		
	}

	@Override
	public String render() {
		return ".";
	}
	
}
