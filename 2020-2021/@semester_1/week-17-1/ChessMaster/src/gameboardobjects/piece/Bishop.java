package gameboardobjects.piece;

import java.awt.Graphics;

import gameboardobjects.contracts.GameObjectColorEnum;
import gameboardobjects.parents.Piece;

public class Bishop extends Piece {

	public Bishop(int row, int col, GameObjectColorEnum color) {
		super(row, col, color, 10, "B");
	}

	@Override
	public boolean isMovePosible(int toRow, int toCol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAttackPosible(int toRow, int toCol) {
		// TODO Auto-generated method stub
		return false;
	}
}
