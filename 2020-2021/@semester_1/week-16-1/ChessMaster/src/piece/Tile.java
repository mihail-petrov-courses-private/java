package piece;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {

	private int row;
	private int col;
	private Color color;
	private int size;
	
	public Tile(int row, int col, Color color) {

		this.row 	= row;
		this.col 	= col;
		this.color  = color;
		this.size 	= 80;
	}
		
	public void render(Graphics g) {
	
		int tileX = this.col * this.size; 
		int tileY = this.row * this.size;
		
		g.setColor(this.color);
		g.fillRect(tileX, tileY, this.size, this.size);
	}
}
