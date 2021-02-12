import java.util.Scanner;

public class Application {
	
	static int mealMenuIndex = -1;
	
	public static void displayMenu(int serialNumber) {
		
		Console.log("Please chose menu item");
		Console.log("[1] Meat");
		Console.log("[2] Salat");
		Console.log("[3] Desert");
		int mealIndex 		= Console.promt("Make your choise : ");
		
		if(mealIndex == 1 || mealIndex == 2 || mealIndex == 3) {
			mealMenuIndex = mealIndex - 1;
		}
		else {
			Console.log("You chose incorect index");
		}
	}
	
	public static void processMenu(int menuIndex, int serialNumber) {

		int priceCollection[] = {10, 7, 4};
		
		int mealPrice 		= priceCollection[menuIndex];
		int finalMealPrice	= SerialNumber.discount(serialNumber, mealPrice);
		
		Console.log("You should pay : " + finalMealPrice + " BGN");		
	}
	
	
	public static void main(String[] args) {
		
		int serialNumber = Console.promt("Please enter serial number: ");
		
		boolean isNormal 		= SerialNumber.isNormal(serialNumber);
		boolean isLagger 		= SerialNumber.isLagger(serialNumber);
		boolean isEarlyAdopter 	= SerialNumber.isEarlyAdopter(serialNumber);
		
		Console.log("Is normal       	: " + isNormal);
		Console.log("Is lagger       	: " + isLagger);
		Console.log("Is early adopter  	: " + isEarlyAdopter);
		Console.log("Is customer a VIP 	: " + SerialNumber.isVIP(serialNumber));
		Console.log("Is customer applicable for extra meal : " + SerialNumber.isApplicableForExtraMeal(serialNumber));
		Console.log(10);
		
		displayMenu(serialNumber);
		if(mealMenuIndex != -1) { // not equal
			processMenu(mealMenuIndex, serialNumber);
		}
		else {
			Console.log("Final price 1 BGN");
		}
	}
}
