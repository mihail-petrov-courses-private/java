package com.netitjava.units.parent;

import com.netitjava.model.RowCol;

public abstract class Unit {

	protected int row;
	protected int col;	
	protected String simbol;
	protected boolean isBreakable;
	protected boolean isPassable;
	
	public Unit(int row, int col) {

		this.setRow(row);
		this.setCol(col);
	}
	
	public Unit(RowCol destination) {

		this.setRow(destination.getRow());
		this.setCol(destination.getCol());
	}	
	
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
	
	
	
	
	public abstract String render();
}
