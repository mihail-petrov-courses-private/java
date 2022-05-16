package com.netitjava.manager;

import com.netitjava.board.GameBoard;
import com.netitjava.level.child.BasicLevel;
import com.netitjava.level.factory.LevelFactory;
import com.netitjava.level.parent.Level;
import com.netitjava.model.RowCol;
import com.netitjava.processor.FireProcessor;
import com.netitjava.processor.MoveProcessor;
import com.netitjava.units.*;
import com.netitjava.units.child.EnemyTank;
import com.netitjava.units.child.Hq;
import com.netitjava.units.child.PlayerTank;
import com.netitjava.units.child.Terren;
import com.netitjava.units.parent.Barricade;
import com.netitjava.units.parent.Unit;
import com.netitjava.util.*;


public class GameBoardManager {
	
	private GameBoard gameBoard;	
	public void start(String dificulty) {

		this.bootstrap(dificulty);
		this.render();
		
		this.gameLoop();
	}
	
	private void gameLoop() {
		
		String actionKey = Console.input("Please enter action: ");
		if(GameKeyManager.isDirectionKey(actionKey)) {
			this.gameBoard = (new MoveProcessor()).process(this.gameBoard, actionKey);
		}
		
		if(GameKeyManager.isFireKey(actionKey)) {
			this.gameBoard = (new FireProcessor()).process(this.gameBoard, actionKey);
		}
		
		this.render();
		gameLoop();
	}
	
	private void render() {
		
		for(int row = 0; row < this.gameBoard.getRowCount(); row++) {
			for(int col = 0; col < this.gameBoard.getColCount(); col++) {
				Console.log(this.gameBoard.renderUnit(row, col));
			}
			Console.lognl("");
		}
	}	
	
	private void bootstrap(String dificulty) {
		
		Level level 			= LevelFactory.bootstrap(dificulty);
		this.gameBoard 			= level.bootstrap(); 
	}	
}