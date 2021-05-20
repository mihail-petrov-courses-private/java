package game;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import examplethread.ProcessBlack;
import examplethread.ProcessWhite;
import manager.ScoreManager;

public class ScoreBoard extends JPanel {

	private static ScoreBoard layoutInstance;
	
	public ScoreBoard() {
		
		layoutInstance = this;
		
		JLabel scoreLabel = new JLabel();
		
		//scoreLabel.setFont(new Font("", Font.BOLD, 25));
		//this.add(scoreLabel);
		//scoreLabel.setText("Score label : " + ScoreManager.getScore());
		
		(new Thread(new Runnable() {
			
			@Override
			public void run() {

				JLabel scoreLabel = new JLabel();
				scoreLabel.setFont(new Font("", Font.BOLD, 25));
				layoutInstance.add(scoreLabel);		
				
				while(true) {
					scoreLabel.setText("Score label black: " + ScoreManager.getScoreBlack());
				}				
			}
		})).start();
		
		(new Thread(new Runnable() {
			
			@Override
			public void run() {

				JLabel scoreLabel = new JLabel();
				scoreLabel.setFont(new Font("", Font.BOLD, 25));
				layoutInstance.add(scoreLabel);		
				
				while(true) {
					scoreLabel.setText("Score label black: " + ScoreManager.getScoreWhite());
				}				
			}
		})).start();		
		
		
		
		//ProcessBlack blackProcess = new ProcessBlack(this);
		//blackProcess.start();
		
		//ProcessWhite whiteProcess = new ProcessWhite(this);
		//whiteProcess.start();		
	}
}