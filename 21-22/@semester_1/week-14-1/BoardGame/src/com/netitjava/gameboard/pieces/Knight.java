package com.netitjava.gameboard.pieces;

public class Knight extends Piece {

	public Knight() {
		super(-1, -1, 8, 3, 15, 1, 1);
	}	
	
	public Knight(int row, int col) {
		super(row, col, 8, 3, 15, 1, 1);
	}

	@Override
	public boolean isMovePossible(int row, int col) {
		return false;
		
	}

	@Override
	public void isAttackPossible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isHealPossible() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String render() {
		return "%";
	}
	

	@Override
	public String getPieceName() {
		return "Рицър";
	}	
}
