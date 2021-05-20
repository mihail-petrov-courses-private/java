package gameboardobjects.piece;

import java.awt.Graphics;

import gameboardobjects.contracts.GameObjectColorEnum;
import gameboardobjects.contracts.PieceScore;
import gameboardobjects.parents.Piece;

public class Queen extends Piece {

	public Queen(int row, int col, GameObjectColorEnum color) {
		super(row, col, color, PieceScore.QUEEN, "Q");
	}

	@Override
	public boolean isMovePosible(int toRow, int toCol) {
		int rowCoefficient = Math.abs(toRow - this.row);
		int colCoefficient = Math.abs(toCol - this.col);
		
		if((rowCoefficient > 0) && colCoefficient == 0) {
			return true;
		}
		if((colCoefficient > 0) && rowCoefficient == 0) {
			return true;
		}
		if((rowCoefficient == colCoefficient) && ((toRow != this.row) || (toCol != this.col))) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isAttackPosible(int toRow, int toCol) {
		return isMovePosible(toRow, toCol);
	}

}
