package gameboardobjects.parents;

import java.awt.Color;
import java.awt.Graphics;

import gameboardobjects.contracts.GameBoardObjectDimention;
import gameboardobjects.contracts.GameObjectColorEnum;

public abstract class GameBoardObject {

	protected int row;
	protected int col;
	protected GameObjectColorEnum color;
	protected int size;
	
	public GameBoardObject(int row, int col, GameObjectColorEnum color) {
		
		this.row 	= row;
		this.col 	= col;
		this.color 	= color;
		this.size 	= GameBoardObjectDimention.SIZE; 
	}
	
	public abstract void render(Graphics g);
	
	
	protected Color computeGameObjectColor() {
		
		return (this.color == GameObjectColorEnum.BLACK) 
				? Color.BLACK 
                : Color.WHITE;
	}
	
	
}
