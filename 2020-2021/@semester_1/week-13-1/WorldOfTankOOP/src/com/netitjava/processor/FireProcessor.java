package com.netitjava.processor;

import com.netitjava.board.GameBoard;
import com.netitjava.manager.GameKeyManager;
import com.netitjava.model.RowCol;
import com.netitjava.util.Console;

public class FireProcessor implements ProcessorInterface {

	@Override
	public GameBoard process(GameBoard gameBoard, String actionKey) {
		
		String directionKey = Console.input("Please enter direction: ");
		
		if(GameKeyManager.isDirectionForward(directionKey)) {
		
			int row = gameBoard.getPlayer().getRow() - 1;
			int col = gameBoard.getPlayer().getCol();
			
			for(; row >= 0; row-- ) {
				if(isProcessed(gameBoard, row, col)) break;
			}
		}
	
		if(GameKeyManager.isDirectionBackword(directionKey)) {
			
			int row = gameBoard.getPlayer().getRow() + 1;
			int col = gameBoard.getPlayer().getCol();
			
			for(; row < gameBoard.getRowCount(); row++ ) {
				if(isProcessed(gameBoard, row, col)) break;
			}
		}
	
		if(GameKeyManager.isDirectionLeft(directionKey)) {
			
			int row = gameBoard.getPlayer().getRow();
			int col = gameBoard.getPlayer().getCol() - 1;
			
			for(; col >= 0; col-- ) {
				if(isProcessed(gameBoard, row, col)) break;
			}
		}
	
		if(GameKeyManager.isDirectionRight(directionKey)) {
			
			int row = gameBoard.getPlayer().getRow();
			int col = gameBoard.getPlayer().getCol() + 1;
			
			for(; col < gameBoard.getColCount(); col++ ) {
				if(isProcessed(gameBoard, row, col)) break;
			}
		}		

		return gameBoard;
	}
	

	private boolean isProcessed(GameBoard gameBoard, int row, int col) {
		
		RowCol destination = new RowCol(row, col);
				
		if(gameBoard.isHittable(destination)) {
		
			if(gameBoard.getPlayer().hasPowerup()) {
				gameBoard.teramorf(destination);
				return true;
			}
			
			if(gameBoard.isBreakable(destination)) {
				gameBoard.teramorf(destination);
				return true;
			}
		}
		
		return false;
	}	
}
