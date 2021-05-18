package gameboardobjects.piece;

import java.awt.Color;
import java.awt.Graphics;

import gameboardobjects.contracts.GameObjectColorEnum;
import gameboardobjects.contracts.PieceScore;
import gameboardobjects.parents.Piece;

public class Pawn extends Piece {

	public Pawn(int row, int col, GameObjectColorEnum color) {
		super(row, col, color, PieceScore.PAWN, "P");
	}

	@Override
	public boolean isMovePosible(int toRow, int toCol) {
		
		int rowCoefficient = Math.abs(toRow - this.row); // 
		int colCoefficient = Math.abs(toCol - this.col); // 0
		
		return  rowCoefficient == 1 &&
				colCoefficient == 0;
	}

	@Override
	public boolean isAttackPosible(int toRow, int toCol) {

		int rowCoefficient = Math.abs(toRow - this.row); // 
		int colCoefficient = Math.abs(toCol - this.col); // 0
		
		return 	rowCoefficient == 1 &&
				colCoefficient == 1;
	}


}
