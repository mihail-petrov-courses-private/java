package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import piece.Tile;

public class GameBoard extends JFrame {

	public GameBoard() {
		
		this.setVisible(true);
		this.setSize(640, 640);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				
				Color tileColor = getTileColor(row, col);
				(new Tile(row, col, tileColor)).render(g);		
			}	
		}
	}
	
	private Color getTileColor(int row, int col) {
		
		boolean isRowColEven = (row % 2 == 0) && (col % 2 == 0);
		boolean isRowColOdd  = (row % 2 != 0) && (col % 2 != 0);
		
		if(isRowColEven || isRowColOdd) {
			return Color.BLACK;
		}
		
		return Color.WHITE;
	}
}
