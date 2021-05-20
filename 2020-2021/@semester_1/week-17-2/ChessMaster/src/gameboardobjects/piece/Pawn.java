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
		
		if((this.color == GameObjectColorEnum.BLACK) && this.row == 6) {
			switch(rowCoefficient) {
			case 1:
				return  rowCoefficient == 1 &&
						colCoefficient == 0;
			case 2:
				return  rowCoefficient == 2 &&
						colCoefficient == 0;
			}
		}
		
		if((this.color == GameObjectColorEnum.WHITE) && this.row == 1) {
			switch(rowCoefficient) {
			case 1:
				return  rowCoefficient == 1 &&
						colCoefficient == 0;
			case 2:
				return  rowCoefficient == 2 &&
						colCoefficient == 0;
			}
		}
		
		if((this.color == GameObjectColorEnum.BLACK) && (toRow < this.row)) {
			return  rowCoefficient == 1 &&
					colCoefficient == 0;
		}
		
		if((this.color == GameObjectColorEnum.WHITE) && (toRow > this.row)) {
			return  rowCoefficient == 1 &&
					colCoefficient == 0;
		}
		
		return  false;
	}

	@Override
	public boolean isAttackPosible(int toRow, int toCol) {

		int rowCoefficient = Math.abs(toRow - this.row); // 
		int colCoefficient = Math.abs(toCol - this.col); // 0
		
		return 	rowCoefficient == 1 &&
				colCoefficient == 1;
	}


}
