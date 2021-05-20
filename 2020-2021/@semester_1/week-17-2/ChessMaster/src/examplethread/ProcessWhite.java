package examplethread;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import manager.ScoreManager;

public class ProcessWhite extends Process {

	public ProcessWhite(JPanel instance) {
		super(instance);
	}
		
	@Override
	public void run() {

		JLabel scoreLabel = new JLabel();
		scoreLabel.setFont(new Font("", Font.BOLD, 25));
		this.layoutInstance.add(scoreLabel);		
		
		while(true) {
			scoreLabel.setText("Score label white: " + ScoreManager.getScoreWhite());
		}
	}	
}
