import java.util.Scanner;

public class Application {
	
	static int mealMenuIndex = -1;
	
	public static void displayMenu(int serialNumber) {
		
		Console.log("** MENU **");
		Console.log("[1] Meat");
		Console.log("[2] Salat");
		Console.log("[3] Desert");
		
		Console.log("Make your choise: ");
		Console.log("{1} Order new item");
		Console.log("{2} Cancel order request");
		Console.log("{3} Pay the order (finish)");
		Console.log("{4} Remove item from my order request");
		Console.log("{5} Give information regrading my order");
		
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
		// int finalMealPrice	= PaymentProcessor.discount(serialNumber, mealPrice);
		// Console.log("You should pay : " + finalMealPrice + " BGN");		
	}
	
	
	public static void main(String[] args) {
		
		int serialNumber 		= Console.promt("Please enter serial number: ");
		MenuProcessor.orderMenuItem(serialNumber);

		
		
		// displayMenu(serialNumber);
		
		
//		if(mealMenuIndex != -1) { // not equal
//			processMenu(mealMenuIndex, serialNumber);
//		}
//		else {
//			Console.log("Final price 1 BGN");
//		}
	}
}
