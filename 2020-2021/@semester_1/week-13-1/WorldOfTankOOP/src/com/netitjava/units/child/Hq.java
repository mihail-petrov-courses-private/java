package com.netitjava.units.child;

import com.netitjava.units.parent.Unit;

public class Hq extends Unit  {
	
	public Hq(int row, int col) {
		
		super(row, col);
		this.setBreakable(true);
		this.setPassable(false);
	}
	
	public String render() {
		return "&";
	}
}
