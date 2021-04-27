package com.netitjava.gameboard.tiles;

import com.netitjava.gameboard.GameBoardObject;

public class GameBoardTile extends GameBoardObject {

	protected int row;
	protected int col;
	
	public GameBoardTile(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String render() {
		return "*";
	}
}
