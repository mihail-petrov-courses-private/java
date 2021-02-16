
public class MenuProcessor {

	public static int finalPrice = 0;
	
	public static final int ORDER_NEW_ITEM 			= 1;
	public static final int CANCEL_ORDER_REQUEST 	= 2;
	public static final int PAY_THE_ORDER_REQUEST 	= 3;
	public static final int ORDER_INFO 				= 5;
	
	public static int getMenuItemPrice(int menuItemIndex) {
		
		if(menuItemIndex == 1) return 5;
		if(menuItemIndex == 2) return 7;
		if(menuItemIndex == 3) return 9;
		return 0;
	}
	
	public static void displayMenu() {
		
		Console.log("** MENU **");
		Console.log("[1] Meat");
		Console.log("[2] Salat");
		Console.log("[3] Desert");
		
		
		if(finalPrice == 0) {
			
			Console.log("Make your choise: ");
			Console.log("{1} Order new item");
			Console.log("{2} Cancel order request");
		}
		
		if(finalPrice > 0) {
			
			Console.log("Make your choise: ");
			Console.log("{1} Order new item");
			Console.log("{2} Cancel order request");
			Console.log("{3} Pay the order (finish)");
			Console.log("{4} Remove item from my order request");
			Console.log("{5} Give information regrading my order");			
		}
	}
	
	public static void orderMenuItem(int serialNumber) {
		
		displayMenu();
		
		int menuChoiseIndex = Console.promt("Please choise: ");
		
		if(menuChoiseIndex == ORDER_NEW_ITEM) {
			
			int menuItemIndex = Console.promt("Please choise menu item : ");
			finalPrice += getMenuItemPrice(menuItemIndex);
			orderMenuItem(serialNumber);
		}
		
		if(menuChoiseIndex == CANCEL_ORDER_REQUEST) {
			Console.log("Have a nice day");
		}
		
		if(menuChoiseIndex == PAY_THE_ORDER_REQUEST) {
			
			Console.log("Final price : " + PaymentProcessor.getPrice(serialNumber, finalPrice));
			Console.log("Have a nice day ");
		}
		
		if(menuChoiseIndex == ORDER_INFO) {
			
			Console.log("Your order request price until now is : ");
			Console.log("Final price  : " + finalPrice);
			Console.log("Final price + dscount : " + PaymentProcessor.getPrice(serialNumber, finalPrice));
			orderMenuItem(serialNumber);
		}
	}
}
