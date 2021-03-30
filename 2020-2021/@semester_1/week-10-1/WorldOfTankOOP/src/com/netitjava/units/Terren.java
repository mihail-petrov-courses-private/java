package com.netitjava.units;

public class Terren {

	private int row;
	private int col;
	private String simbol;
	
	public Terren(int row, int col) {

		this.setSimbol(".");
		this.setRow(row);
		this.setCol(col);
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
}
