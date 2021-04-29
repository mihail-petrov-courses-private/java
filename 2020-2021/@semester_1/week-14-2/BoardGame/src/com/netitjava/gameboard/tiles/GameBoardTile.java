package com.netitjava.gameboard.tiles;

import com.netitjava.enums.GameColorEnum;
import com.netitjava.enums.TileColorEnum;
import com.netitjava.gameboard.GameBoardObject;

public class GameBoardTile extends GameBoardObject {

	protected int row;
	protected int col;
	protected GameColorEnum color;
	
	public GameBoardTile(int row, int col, GameColorEnum color) {
		super(row, col);
	}

	@Override
	public String render() {
		return "*";
	}
	
	public GameColorEnum getColor() {
		return this.color;
	}
	
	
}
