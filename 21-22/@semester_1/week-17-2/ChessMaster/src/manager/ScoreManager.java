package manager;

public class ScoreManager {
	
	private static int scoreWhite = 0;
	private static int scoreBlack = 0;
	
	public static int getScoreBlack() {
		return scoreBlack;
	}
	
	public static int getScoreWhite() {
		return scoreWhite;
	}	
	
	public static void setScoreWhite() {
		scoreWhite += 5;
	}
	
	public static void setScoreBlack() {
		scoreBlack += 15;
	}	
}
