package com.netitjava.units.child.barricades;

import com.netitjava.units.parent.Barricade;

public class UnbreakableBaricade extends Barricade {

	public UnbreakableBaricade(int row, int col) {
		super(row, col, false);
	}

	@Override
	public String render() {
		return "*";
	}
}
