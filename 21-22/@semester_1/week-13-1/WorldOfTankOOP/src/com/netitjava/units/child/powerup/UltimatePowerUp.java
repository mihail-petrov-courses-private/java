package com.netitjava.units.child.powerup;

import com.netitjava.units.parent.Powerup;

public class UltimatePowerUp extends Powerup {

	public UltimatePowerUp(int row, int col) {
		super(row, col);
	}

	@Override
	public String render() {
		return "!";
	}
}
