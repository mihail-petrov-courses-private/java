package com.netitjava.gameboard;

public abstract class GameBoardObject {

	protected int row;
	protected int col;	
	
	public GameBoardObject(int row, int col) {
		this.row = row;
		this.col = col;		
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

	public abstract String render();
}
