package com.netitjava.units.child;

import com.netitjava.units.parent.Unit;

public class Hq extends Unit  {
	
	public Hq(int row, int col) {

		this.setSimbol("&");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(true);
	}
}
