package com.netitjava.processor;

import com.netitjava.board.GameBoard;
import com.netitjava.model.RowCol;

public class MoveProcessor implements ProcessorInterface {

	public GameBoard process(GameBoard gameBoard, String actionKey) {
		
		RowCol destination = gameBoard.getPlayer().getDestination(actionKey);
		if(this.isMoveValid(destination, gameBoard)) {
			gameBoard.movePlayer(destination);
		}
		
		return gameBoard;
	}
	
	private boolean isMoveValid(RowCol destination, GameBoard gameBoard) {
		
		try {
			return gameBoard.getGameBoardElement(destination).isPassable();
		}
		catch (Exception e) {
			return false;
		}
	}
}
