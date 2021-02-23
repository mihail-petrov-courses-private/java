import java.util.*;

//import robot.BatlleStrategy;
//import robot.Navigation;
import robot.*;

import util.Console;
import util.Util;

public class Application {
	
	
	public static void displayRobotMessage() {
		
		for(int i = 10; i > 0; i--) {
			
			String message = Util.isEven(i) ? 
							 ("I am a Robotttt " + i) : 
							 ("" + i);
			
			Console.log(message);
		}
	}
	
	
	public static boolean hasElectricity() {
		
		Random randomGenerator = new Random();
		int coeficientHigh 	= randomGenerator.nextInt();
		int coeficientLow 	= randomGenerator.nextInt();
		
		if(coeficientHigh > coeficientLow) return true;
		if(coeficientHigh < coeficientLow) return false;
		
		return hasElectricity();
	}
	
	public static void targetDisplay() {
		
		int numberOfPixes = Console.promptInt("Enter number of pixels : ");
		
		if(BatlleStrategy.isHitSuccesful(numberOfPixes)) {
			
			displayRobotMessage();
			BatlleStrategy.incrementSuccessHit();
		}
		
		if(BatlleStrategy.hasBattery()) {
			targetDisplay();	
		}
		
		if(hasElectricity()) {
			BatlleStrategy.recharge();
			targetDisplay();
		}
		
		Console.log("!!!! No electricity the robot stop its movement !!!! ");
	}
	
	public static void navigationDisplay() {
		
		Console.log("Please identify the object infront of you: ");
		Console.log("[1] Wall ");
		Console.log("[2] Chair ");
		Console.log("[3] Noting ");
		
		int obstecleIndex = Console.promptInt("Enter object index");
		Console.log(Navigation.getDirection(obstecleIndex));
	}
	
	public static void main(String[] args) {
		
		// *
		navigationDisplay();
		
		// *
		targetDisplay();
	}
}
