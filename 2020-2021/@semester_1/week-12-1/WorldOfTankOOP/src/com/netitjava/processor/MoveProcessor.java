package com.netitjava.processor;

import com.netitjava.board.GameBoardInterface;
import com.netitjava.model.RowCol;
import com.netitjava.units.child.PlayerTank;

public class MoveProcessor implements ProcessorInterface {

	public GameBoardInterface process(GameBoardInterface gameBoard, String actionKey) {
		
		RowCol destination = gameBoard.getPlayer().getDestination(actionKey);
		if(this.isMoveValid(destination, gameBoard)) {
			gameBoard.movePlayer(destination);
		}
		
		return gameBoard;
	}
	
	private boolean isMoveValid(RowCol destination, GameBoardInterface gameBoard) {
		
		try {
			return gameBoard.getGameBoardElement(destination).isPassable();
		}
		catch (Exception e) {
			return false;
		}
	}
}
