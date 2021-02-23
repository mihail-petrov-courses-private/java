package robot;
import java.util.Random;

public class BatlleStrategy {

	private static int numberOfHit = 0;
	
	private static final int HIT_ATACK_COEFICIENT 	= 5;
	private static final int MAX_NUMBER_OF_HIT 		= 4;
	
	public static void incrementSuccessHit() {
		numberOfHit++;
	};
	
	public static boolean hasBattery() {
		return numberOfHit < MAX_NUMBER_OF_HIT;			
	}	
	
	public static void recharge() {
		numberOfHit = 0;
	}	
	
	public static boolean isHitSuccesful(int pixelLength) {
		
//		boolean isEnemyAvailable 	= (pixelLength % 2  == 0);
//		boolean hasBattery 			= (numberOfHit < MAX_NUMBER_OF_HIT);
//		
//		Random randomGenerator = new Random();
//		int randomGeneratorHitIndex = randomGenerator.nextInt(11);
//		
//		boolean isAttackSafeForExecution = randomGeneratorHitIndex != HIT_ATACK_COEFICIENT;		
//		
//		return isEnemyAvailable &&
//				hasBattery && 
//				isAttackSafeForExecution;
		
		return 	isEnemyAvailable(pixelLength) 	&&
				hasBattery() 					&&
				isAttackSafeForExecution();
	}
	
	private static boolean isEnemyAvailable(int pixelLength) {
		return pixelLength % 2  == 0;		
	}
		
	private static boolean isAttackSafeForExecution() {
		
		Random randomGenerator = new Random();
		int randomGeneratorHitIndex = randomGenerator.nextInt(11);
		
		return randomGeneratorHitIndex != HIT_ATACK_COEFICIENT;
	}
}
