package com.netitjava.units.child;

import com.netitjava.units.parent.Unit;

public class EnemyTank extends Unit  {

	public EnemyTank(int row, int col) {
		
		super(row, col);
		this.setBreakable(true);
		this.setPassable(false);
	}

	@Override
	public String render() {
		return "$";
	}
	
}
