package gameboardobjects.parents;

import java.awt.Color;
import java.awt.Graphics;

import gameboardobjects.contracts.GameObjectColorEnum;

public abstract class Piece extends GameBoardObject {

	protected int point;
	
	public Piece(int row, int col, GameObjectColorEnum color, int point) {

		super(row, col, color);	
		this.point 	= point;
		//this.size 	= 50;
	}
		
	public int getScore() {
		return this.point;
	}
	
	protected Color computeGameObjectColor() {
		
		return (this.color == GameObjectColorEnum.BLACK) 
				? Color.RED 
                : Color.ORANGE;   
	}	
	
	
	@Override
	public void render(Graphics g) {
		
		int tileX = this.col * this.size; 
		int tileY = this.row * this.size;
		
		g.setColor(this.computeGameObjectColor());
		g.fillOval(tileX, tileY, this.size, this.size);
	}	
	
	public abstract boolean isMovePosible(int toRow, int toCol);
	
	public abstract boolean isAttackPosible(int toRow, int toCol);
}
