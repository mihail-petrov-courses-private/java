package com.netitjava.units.child;

import com.netitjava.units.parent.Unit;

public class PlayerTank extends Unit  {
	
	public PlayerTank(int row, int col) {

		this.setSimbol("%");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(true);
	}
}
