package com.netitjava.managers;

import java.util.ArrayList;

import com.netitjava.enums.PlayerColorEnum;
import com.netitjava.gameboard.GameBoardObject;
import com.netitjava.gameboard.pieces.Dworf;
import com.netitjava.gameboard.pieces.Elf;
import com.netitjava.gameboard.pieces.Knight;
import com.netitjava.gameboard.pieces.Piece;
import com.netitjava.gameboard.tiles.GameBoardTile;
import com.netitjava.util.Console;

public class GameManager {

	private GameBoardObject[][] gameBoard;
	private final int ROW_COUNT = 9;
	private final int COL_COUNT = 7;
	
	private ArrayList<PlayerManager> playerManagerCollection;
	private int activePlayerIndex = 0;
		
	public GameManager() {
		
		this.gameBoard = new Piece[this.ROW_COUNT][this.COL_COUNT];
		// input
		this.playerManagerCollection.add(new PlayerManager(PlayerColorEnum.BLACK));
		this.playerManagerCollection.add(new PlayerManager(PlayerColorEnum.RED));
	}
	
	public void startGame() {
		
		this.bootstrap();
		this.render();
		
		PlayerManager activePlayer = this.getActivePlayer();
		String playerName = activePlayer.getName();
		Console.log(playerName + " са на ход:");
		Console.log("Разполагате със следните фигури");
		
		// 1. Select player piece
		ArrayList<Piece> collection = activePlayer.getUnplacedPieceCollection();
		for(int i = 0; i < collection.size(); i++) {
			Console.log("(" + i + ") " + collection.get(i) );
		}
		
		int pieceId 	= Console.promtInt("Коя единица искате да позиционирате");
		int pieceRow 	= Console.promtInt("Най кой ред ? "); 
		int pieceCol 	= Console.promtInt("Най коя колонка ? ");
		activePlayer.place(pieceId, pieceRow, pieceCol);
		
		// Piece piece = activePlayer.getPiece();
	}
	
	private PlayerManager getActivePlayer() {
		return this.playerManagerCollection.get(activePlayerIndex);
	}
	
	private void endTurn() {
		
		activePlayerIndex++;
		
		if(this.playerManagerCollection.size() == activePlayerIndex) {
			activePlayerIndex = 0;	
		}
	}	
	
	
	private void render() {

		for(int row = 0; row < this.ROW_COUNT; row++) {
			for(int col = 0; col < this.COL_COUNT; col++) {
				System.out.print(this.gameBoard[row][col].render());
			}
			System.out.println("");
		}
	}
	
	private void bootstrap() {
		
		for(int row = 0; row < this.ROW_COUNT; row++) {
			for(int col = 0; col < this.COL_COUNT; col++) {
				this.gameBoard[row][col] = new GameBoardTile(row, col);
			}
		}
	}
}
