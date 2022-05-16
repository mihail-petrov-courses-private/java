package com.netitjava.managers;

import java.util.ArrayList;

import com.netitjava.enums.GameColorEnum;
import com.netitjava.enums.PlayerColorEnum;
import com.netitjava.exceptions.PlacementNotCorrectException;
import com.netitjava.exceptions.PlacementNotPosibleException;
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
		
		this.gameBoard = new GameBoardObject[this.ROW_COUNT][this.COL_COUNT];

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
			catch (Exception e) {
				
				
				// TODO: handle exception
			}
		}
	}
	
	private boolean gamePhasePiecePlacementRun(PlayerManager activePlayer) {
		return activePlayer.hasUnplacedPieces() == false;
	}
	
	private void gamePhasePiecePlacement(PlayerManager activePlayer) throws Exception {

//		try {

				Console.log("You have the folowing pieces");
				
				// 1. Select player piece
				ArrayList<Piece> collection = activePlayer.getUnplacedPieceCollection();
				for(int i = 0; i < collection.size(); i++) {
					Console.log("(" + i + ") " + collection.get(i).getPieceName() );
				}
				
				int pieceId 	= Console.promtInt("Which unit you wish to pkace");
				int pieceRow 	= Console.promtInt("Row: ? "); 
				int pieceCol 	= Console.promtInt("Col: ? ");
				
				// get gameBord tile 
				GameBoardTile activeTile = (GameBoardTile) this.gameBoard[pieceRow][pieceCol];
						
				activePlayer.place(pieceId, activeTile);
//			} 
//			catch (PlacementNotCorrectException e) {
//				Console.log(">> Placement is not correct. Yopu must select the right color");
//			}			
//			catch (PlacementNotPosibleException e) {
//				Console.log("%% Placement is not posible. Yopu must select empty tile");
//			} 
//			catch(Exception ex) {
//				Console.log("## Something when wrong");
//			}
	}
	
	private void gamePhaseMainGame() {
		
	}
	
	private PlayerManager getActivePlayer() {
		return this.playerManagerCollection.get(activePlayerIndex);
	}
	
	private GameBoardTile getActiveTile(int row, int col) {
		return (GameBoardTile) this.gameBoard[row][col];
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
				
				GameColorEnum gameTileColor = getGameBordTileColor(row, col); 
				this.gameBoard[row][col] = new GameBoardTile(row, col, gameTileColor);
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
