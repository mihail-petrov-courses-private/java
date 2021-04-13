package com.netitjava.processor;

import com.netitjava.board.GameBoardInterface;
import com.netitjava.manager.GameKeyManager;
import com.netitjava.model.RowCol;
import com.netitjava.util.Console;

public class FireProcessor implements ProcessorInterface {

	@Override
	public GameBoardInterface process(GameBoardInterface gameBoard, String actionKey) {
		
		String directionKey = Console.input("Please enter direction: ");
		
		if(GameKeyManager.isDirectionForward(directionKey)) {
		
			int row = gameBoard.getPlayer().getRow() - 1;
			int col = gameBoard.getPlayer().getCol();
			RowCol destination = new RowCol(row, col);
			
			for(; row >= 0; row-- ) {
				if(gameBoard.isBreakable(destination)) {
	
					gameBoard.teramorf(destination);
					return gameBoard;
				}
			}
		}
	
		if(GameKeyManager.isDirectionBackword(directionKey)) {
			
			int row = gameBoard.getPlayer().getRow() + 1;
			int col = gameBoard.getPlayer().getCol();
			RowCol destination = new RowCol(row, col);		
			
			for(; row < gameBoard.getRowCount(); row++ ) {
				if(gameBoard.isBreakable(destination)) {
					
					gameBoard.teramorf(destination);
					return gameBoard;
				}
			}
		}
	
		if(GameKeyManager.isDirectionLeft(directionKey)) {
			
			int row = gameBoard.getPlayer().getRow();
			int col = gameBoard.getPlayer().getCol() - 1;
			RowCol destination = new RowCol(row, col);		
			
			for(; col >= 0; col-- ) {
				if(gameBoard.isBreakable(destination)) {
					
					gameBoard.teramorf(destination);
					return gameBoard;
				}
			}
		}
	
		if(GameKeyManager.isDirectionRight(directionKey)) {
			
			int row = gameBoard.getPlayer().getRow();
			int col = gameBoard.getPlayer().getCol() + 1;
			RowCol destination = new RowCol(row, col);		
			
			for(; col < gameBoard.getColCount(); col++ ) {
				if(gameBoard.isBreakable(destination)) {
					
					gameBoard.teramorf(destination);
					return gameBoard;
				}
			}
		}		

		return gameBoard;
	}	
}
