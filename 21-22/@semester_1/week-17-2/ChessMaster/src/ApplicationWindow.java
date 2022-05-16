import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import game.GameBoard;
import game.ScoreBoard;

public class ApplicationWindow extends JFrame {

	public ApplicationWindow() {
		
		JPanel panelPlaceholder = new JPanel();
		panelPlaceholder.setLayout(new GridLayout(0, 2));

		GameBoard gameBoard = new GameBoard();
		panelPlaceholder.add(gameBoard);		
		
		ScoreBoard scoreBoard = new ScoreBoard();
		panelPlaceholder.add(scoreBoard);		
		
		this.add(panelPlaceholder);
		this.setVisible(true);
		this.setSize(840, 840);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
}
