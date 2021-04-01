package com.netitjava.units.child;

import com.netitjava.units.parent.Unit;

public class Terren extends Unit {

	public Terren(int row, int col) {

		this.setSimbol(".");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(false);
	}
}
