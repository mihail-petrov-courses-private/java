package com.netitjava.managers;

import java.util.ArrayList;

import com.netitjava.enums.GameColorEnum;
import com.netitjava.enums.PlayerColorEnum;
import com.netitjava.exceptions.PlacementNotCorrectException;
import com.netitjava.exceptions.PlacementNotPosibleException;
import com.netitjava.gameboard.GameBoard;
import com.netitjava.gameboard.GameBoardObject;
import com.netitjava.gameboard.pieces.Dworf;
import com.netitjava.gameboard.pieces.Elf;
import com.netitjava.gameboard.pieces.Knight;
import com.netitjava.gameboard.pieces.Piece;
import com.netitjava.gameboard.tiles.GameBoardTile;
import com.netitjava.util.Console;

public class GameManager {

	// private GameBoardObject[][] gameBoard;
	private final int ROW_COUNT = 7;
	private final int COL_COUNT = 9;
	
	private ArrayList<PlayerManager> playerManagerCollection;
	private int activePlayerIndex = 0;
		
	public GameManager() {

		// input
		this.playerManagerCollection = new ArrayList<PlayerManager>(); 
		this.playerManagerCollection.add(new PlayerManager(GameColorEnum.BLACK));
		this.playerManagerCollection.add(new PlayerManager(GameColorEnum.RED));
	}
	
	public void startGame() {
		
		// 0. Bootstrap main game board
		this.bootstrap();
		this.render();
		
		// Loop 
		while(gamePhasePiecePlacementRun(this.getActivePlayer())) {
			
			try {
			
				Console.log(this.getActivePlayer().getName() + " turn:");		
				this.gamePhasePiecePlacement(this.getActivePlayer());
				this.endTurn();
				this.render();
			}
			catch(ClassCastException e) {
				Console.logln("***");
				Console.logln("You have already placed Piece on the folowing coordinates");
				Console.logln("***");
			}
			catch (Exception e) {
				e.printStackTrace();
				Console.log("Exception in piece placement");
			}
		}
	}
	
	private boolean gamePhasePiecePlacementRun(PlayerManager activePlayer) {
		return activePlayer.hasUnplacedPieces() == false;
	}
	
	private void gamePhasePiecePlacement(PlayerManager activePlayer) throws Exception {

			Console.log("You have the folowing pieces");
			
			// 1. Select player piece
			ArrayList<Piece> collection = activePlayer.getUnplacedPieceCollection();
			for(int i = 0; i < collection.size(); i++) {
				Console.logln("(" + i + ") " + collection.get(i).getPieceName() );
			}
			
			int pieceId 	= Console.promtInt("Which unit you wish to pkace");
			int pieceRow 	= Console.promtInt("Row: ? "); 
			int pieceCol 	= Console.promtInt("Col: ? ");
			
			// get gameBord tile 
			GameBoardTile activeTile = this.getActiveTile(pieceRow, pieceCol);
					
			activePlayer.place(pieceId, activeTile);
	}
	
	private void gamePhaseMainGame() {
		
	}
	
	private PlayerManager getActivePlayer() {
		return this.playerManagerCollection.get(activePlayerIndex);
	}
	
	private GameBoardTile getActiveTile(int row, int col) {
		return (GameBoardTile) GameBoard.getInstance().getElement(row, col);
	}
	
	private void endTurn() {
		
		activePlayerIndex++;
		
		if(this.playerManagerCollection.size() == activePlayerIndex) {
			activePlayerIndex = 0;	
		}
	}	
	
	private void render() {
		GameBoard.getInstance().render();
	}
	
	private void bootstrap() {
		
		for(int row = 0; row < this.ROW_COUNT; row++) {
			for(int col = 0; col < this.COL_COUNT; col++) {
				
				GameColorEnum gameTileColor = getGameBordTileColor(row, col); 
				GameBoard.getInstance().setElement(row, col, new GameBoardTile(row, col, gameTileColor));
			}
		}
	}
	
	
	private GameColorEnum getGameBordTileColor(int row, int col) {

		if(row == 0 || row == 1) {
			return GameColorEnum.RED; 
		}
		
		if(row == 5 || row == 6) {
			return GameColorEnum.BLACK; 
		}			
		
		return GameColorEnum.NEUTRAL;
	}
}
