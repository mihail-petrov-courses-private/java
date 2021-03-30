package com.netitjava.units;

public class Barricade {

	private int row;
	private int col;
	private String simbol;
	
	private boolean isBreakable;

	public Barricade(int row, int col) {

		this.setSimbol("#");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(false);
	}	
	
	public Barricade(int row, int col, boolean isBreakable) {

		this.setSimbol("#");
		this.setRow(row);
		this.setCol(col);
		this.setBreakable(isBreakable);
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
		return simbol;
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
