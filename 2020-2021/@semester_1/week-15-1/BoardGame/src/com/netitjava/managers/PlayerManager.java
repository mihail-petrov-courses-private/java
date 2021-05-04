package com.netitjava.managers;

import java.util.ArrayList;

import com.netitjava.enums.GameColorEnum;
import com.netitjava.enums.PlayerColorEnum;
import com.netitjava.enums.TileColorEnum;
import com.netitjava.exceptions.PlacementNotCorrectException;
import com.netitjava.exceptions.PlacementNotPosibleException;
import com.netitjava.gameboard.GameBoard;
import com.netitjava.gameboard.pieces.*;
import com.netitjava.gameboard.tiles.GameBoardTile;

public class PlayerManager {

	private GameColorEnum color;
	private int score;
	private ArrayList<Piece> unplacedPieceCollection;
	private ArrayList<Piece> pieceCollection;
	
	public PlayerManager(GameColorEnum color) {

		this.color = color;
		
		this.pieceCollection 			= new ArrayList<>();
		this.unplacedPieceCollection 	= new ArrayList<>();
		this.unplacedPieceCollection.add(new Knight(-1, -1));
		this.unplacedPieceCollection.add(new Knight(-1, -1));
		this.unplacedPieceCollection.add(new Dworf(-1, -1));
		this.unplacedPieceCollection.add(new Dworf(-1, -1));
		this.unplacedPieceCollection.add(new Elf(-1, -1));
		this.unplacedPieceCollection.add(new Elf(-1, -1));				
	}
	
	public String getName() {

		if(this.color == GameColorEnum.BLACK	) return "@Black";
		if(this.color == GameColorEnum.RED		) return "@Red";
		return "Безцветните";
	}
	
	public ArrayList<Piece> getUnplacedPieceCollection() {
		return this.unplacedPieceCollection;
	}
	
	// TODO 
	public void place(int pieceIndex, GameBoardTile tile) 
			throws PlacementNotCorrectException, PlacementNotPosibleException {
		
		if(tile == null) {
			throw new PlacementNotPosibleException();
		}
		
		int row 					= tile.getRow();
		int col 					= tile.getCol();
		boolean isPlacementCorrect 	= tile.getColor() == this.color;
			
		if(!isPlacementCorrect) {
			throw new PlacementNotCorrectException();
		}
				
		Piece unplacedPiece = this.unplacedPieceCollection.get(pieceIndex);

		if(isPlacementPosible(row, col)) {

			unplacedPiece.move(row, col);
			GameBoard.getInstance().setElement(row, col, unplacedPiece);
			this.removeFromUnplace(pieceIndex);
		}
	}
	
	private void removeFromUnplace(int pieceIndex) {
		this.unplacedPieceCollection.remove(pieceIndex);
	}
	
	public void move() {
		throw new RuntimeException();
	}
	
	
	
	public boolean hasUnplacedPieces() {
		return this.unplacedPieceCollection.size() == 0;
	}
	
	
	private boolean isPlacementPosible(int row, int col) {
		// return false;
		return true;
	}
}
