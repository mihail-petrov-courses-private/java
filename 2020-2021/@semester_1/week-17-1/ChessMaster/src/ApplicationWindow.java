import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import game.GameBoard;

public class ApplicationWindow extends JFrame {

	public ApplicationWindow() {
		
		JPanel scorePanel = new JPanel();
		this.add(scorePanel);		
		
		GameBoard gameBoard = new GameBoard();
		this.add(gameBoard);
		
		
		
		
		
		this.setVisible(true);
		this.setSize(840, 840);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
}
