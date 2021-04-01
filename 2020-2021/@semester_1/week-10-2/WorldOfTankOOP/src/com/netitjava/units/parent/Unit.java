package com.netitjava.units.parent;

public class Unit {

	protected int row;
	protected int col;	
	protected String simbol;
	protected boolean isBreakable;
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getSimbol() {
		return this.simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}
	
	public boolean isBreakable() {
		return isBreakable;
	}

	public void setBreakable(boolean isBreakable) {
		this.isBreakable = isBreakable;
	}
}
