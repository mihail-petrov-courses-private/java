package gameboardobjects.tile;

import java.awt.Color;
import java.awt.Graphics;

import gameboardobjects.contracts.GameObjectColorEnum;
import gameboardobjects.parents.GameBoardObject;

public class Tile extends GameBoardObject {

	
	public Tile(int row, int col, GameObjectColorEnum color) {
		super(row, col, color);
	}
		
	public void render(Graphics g) {
	
		int tileX = this.col * this.size; 
		int tileY = this.row * this.size;
		
		g.setColor(this.computeGameObjectColor());
		g.fillRect(tileX, tileY, this.size, this.size);
		
	}
}
