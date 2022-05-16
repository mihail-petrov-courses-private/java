package com.netitjava.units.child;

import com.netitjava.units.parent.Unit;

public class EnemyTank extends Unit  {

	public EnemyTank(int row, int col) {

		this.setSimbol("$");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(true);
	}
}
