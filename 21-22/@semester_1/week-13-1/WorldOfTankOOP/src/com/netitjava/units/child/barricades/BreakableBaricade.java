package com.netitjava.units.child.barricades;

import com.netitjava.units.parent.Barricade;

public class BreakableBaricade extends Barricade {

	public BreakableBaricade(int row, int col) {
		super(row, col, true);
	}

	@Override
	public String render() {
		return "#";
	}
	
}
