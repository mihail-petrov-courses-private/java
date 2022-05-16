package com.netitjava.board;

import com.netitjava.model.RowCol;
import com.netitjava.units.child.Terren;
import com.netitjava.units.parent.Player;
import com.netitjava.units.parent.Powerup;
import com.netitjava.units.parent.Unit;

public class GameBoard {

	private Unit[][] gameBoard;
	private Player playerReference;
	
	private int rowCount;
	private int colCount;
	
	public GameBoard(int rowCount, int colCount) {
		this.rowCount = rowCount;
		this.colCount = colCount;
		this.gameBoard = new Unit[rowCount][colCount];
	}
	
	public void setGameBoardElement(RowCol coordinates, Unit element) {
		this.gameBoard[coordinates.getRow()][coordinates.getCol()] = element;
	}	
	
	public void setGameBoardElement(int row, int col, Unit element) {
		this.gameBoard[row][col] = element;
	}
	
	public Unit getGameBoardElement(RowCol destination) {
		return this.gameBoard[destination.getRow()][destination.getCol()];
	}
	
	public Unit getGameBoardElement(int row, int col) {
		return this.gameBoard[row][col];
	}		

	public Player getPlayer() {
		return this.playerReference;
	}

	public void setPlayer(int row, int col, Player player) {

		this.setGameBoardElement(row, col, player);
		this.playerReference = player;
	}

	public void movePlayer(RowCol destination) {
		
		RowCol currentCoordinates 		= this.playerReference.getRowCol();
		Unit currentDestinationObject 	= this.getGameBoardElement(destination); 
		
		this.teramorf(currentCoordinates);
		
		this.setGameBoardElement(destination	, this.playerReference);
		this.playerReference.move(destination);
		
		if(currentDestinationObject instanceof Powerup) {
			this.playerReference.equipt((Powerup) currentDestinationObject);	
		}
	}

	public int getRowCount() {
		return this.rowCount;
	}

	public int getColCount() {
		return this.colCount;
	}
	
	public String renderUnit(int row, int col) {
		return  this.getGameBoardElement(row, col).render();
	}
	
	public boolean isBreakable(RowCol destination) {
		return this.getGameBoardElement(destination).isBreakable();
	}
	
	public boolean isHittable(RowCol destination) {
		return this.getGameBoardElement(destination).isHittable();
	}	
	
	public void teramorf(RowCol destination) {

		Unit emptySpace 			= new Terren(destination);
		this.setGameBoardElement(destination	, emptySpace);
	}
}
