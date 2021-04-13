package com.netitjava.units.parent;

import com.netitjava.model.RowCol;

public class Unit {

	protected int row;
	protected int col;	
	protected String simbol;
	protected boolean isBreakable;
	protected boolean isPassable;
	
	public RowCol getRowCol() {
		return new RowCol(this.getRow(), this.getCol());
	}
	
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

	public boolean isPassable() {
		return isPassable;
	}

	public void setPassable(boolean isPassable) {
		this.isPassable = isPassable;
	}
	
	public boolean isHittable() {
		return !this.isPassable();
	}
}
