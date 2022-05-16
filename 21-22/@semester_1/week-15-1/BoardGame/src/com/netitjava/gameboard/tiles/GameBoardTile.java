package com.netitjava.gameboard.tiles;

import com.netitjava.enums.GameColorEnum;
import com.netitjava.enums.TileColorEnum;
import com.netitjava.gameboard.GameBoardObject;

enum TileState {
	PLACABLE, BLOCKED, PROTECTED, UNPASABLE
}


public class GameBoardTile extends GameBoardObject {
	
	protected int row;
	protected int col;
	protected GameColorEnum color;
	
	protected TileState state;
	
	
	public GameBoardTile(int row, int col, GameColorEnum color) {

		super(row, col);
		this.color = color;
	}

	@Override
	public String render() {
		
		if(state == TileState.BLOCKED) {
			return "&";
		}
		
		if(state == TileState.PLACABLE) {
			return "^";
		}		
		
		
		
		return "*";
	}
	
	public GameColorEnum getColor() {
		return this.color;
	}
	
	
	public void setState(TileState state) {
		this.state = state;
	}
}
