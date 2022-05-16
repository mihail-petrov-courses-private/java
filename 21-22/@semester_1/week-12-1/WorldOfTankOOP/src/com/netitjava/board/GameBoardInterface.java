package com.netitjava.board;

import com.netitjava.model.RowCol;
import com.netitjava.units.parent.Player;
import com.netitjava.units.parent.Unit;

public interface GameBoardInterface {

	public void setGameBoardElement(RowCol coordinates, Unit element);
	
	public void setGameBoardElement(int row, int col, Unit element);
	
	public Unit getGameBoardElement(RowCol destination);
	
	public Unit getGameBoardElement(int row, int col);
	
	public Player getPlayer();	
	
	public void setPlayer(int row, int col, Player player);
	
	public void movePlayer(RowCol destination);
	
	public int getRowCount();
	
	public int getColCount();
	
	public String renderUnit(int row, int col);
	
	public void teramorf(RowCol destination);
	
	public boolean isBreakable(RowCol destination);
	
}