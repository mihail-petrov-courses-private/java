
public class MenuProcessor {

	private static final int TASK_ORDER__NEW_ITEM 		= 1;
	private static final int TASK_CANCEL__ORDER_REQUEST = 2;
	private static final int TASK_PAY__ORDER_REQUEST 	= 3;
	private static final int TASK_INFO__ORDER_REQUEST 	= 5;
	private static final int TASK_INFO__ORDER_LIST 		= 7;
	
	private static int finalPrice = 0;
	
	// 
	private static int orderId	= 0; 
//	private static int orderId1 = 0;
//	private static int orderId2 = 0;
//	private static int orderId3 = 0;
//	private static int orderId4 = 0;
//	private static int orderId5 = 0;
	
	// shorthand
	//private static int[] orderCollection = {1,2,3,4,5,6};
	
	// empty array
	// private static int[] orderCollection;
	
	// initialisation of empty array
	private static int[] orderCollection = new int[5];

	// 
	
	public static void orderMenuItem(int serialNumber) {
	
		displayMenu();
		
		int menuChoiseIndex = Console.promt("Please choise: ");
		
		if(menuChoiseIndex == TASK_ORDER__NEW_ITEM) {
			taskOrderNewItem(serialNumber);
		}
		
		if(menuChoiseIndex == TASK_CANCEL__ORDER_REQUEST) {
			taskCancelOrderRequest();
		}
		
		if(menuChoiseIndex == TASK_PAY__ORDER_REQUEST) {
			taskPayOrderRequest(serialNumber);
		}
		
		if(menuChoiseIndex == TASK_INFO__ORDER_REQUEST) {
			taskInfoOrderRequest(serialNumber);
		}
		
		if(menuChoiseIndex == TASK_INFO__ORDER_LIST) {
			taskInfoOrderList(serialNumber);
		}
	}	
	
	private static int getMenuItemPrice(int menuItemIndex) {
		
		if(menuItemIndex == 1) return 5;
		if(menuItemIndex == 2) return 7;
		if(menuItemIndex == 3) return 9;
		return 0;
	}
	
	private static String getMenuItem(int menuItemIndex) {
		
		if(menuItemIndex == 1) return "Meat";
		if(menuItemIndex == 2) return "Salat";
		if(menuItemIndex == 3) return "Dessert";
		
		return "NO_MENU_ITEM_FOUND";
	}
	
	
	private static void displayMenu() {
		
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
			Console.log("{6} Give information regrading ingredints of item: ");
			Console.log("{7} Give information regrading choosen items: ");
		}
	}
	
	private static void changeId(int menuItemIndex) {
		
//		if(orderId == 1) {
//			orderId1 = menuItemIndex;
//			orderId = orderId + 1;
//		}
//		
//		else if(orderId == 2) {
//			orderId2 = menuItemIndex;
//			orderId = orderId + 1;
//		}		
//		else if(orderId == 3) {
//			orderId3 = menuItemIndex;
//			orderId = orderId + 1;
//		}			
//		else if(orderId == 4) {
//			orderId4 = menuItemIndex;
//			orderId = orderId + 1;
//		}			
//		else if(orderId == 5) {
//			orderId5 = menuItemIndex;
//			orderId = orderId + 1;
//		}
		
		// 5 > 0
		if(orderCollection.length > orderId) {
			
			orderCollection[orderId] = menuItemIndex;
			orderId = orderId + 1;	
		}
	}

	private static void taskOrderNewItem(int serialNumber) {
		
		int menuItemIndex = Console.promt("Please choise menu item : ");
		finalPrice += getMenuItemPrice(menuItemIndex);
		changeId(menuItemIndex);
		
		orderMenuItem(serialNumber);
	}	
	
	private static void taskCancelOrderRequest() {
		Console.log("Have a nice day");
	}	
	
	private static void taskPayOrderRequest(int serialNumber) {
		
		Console.log("Final price : " + PaymentProcessor.getPrice(serialNumber, finalPrice));
		Console.log("Have a nice day ");
	}	

	private static void taskInfoOrderRequest(int serialNumber) {
		
		Console.log("Your order request price until now is : ");
		Console.log("Final price  : " + finalPrice);
		Console.log("Final price + dscount : " + PaymentProcessor.getPrice(serialNumber, finalPrice));
		orderMenuItem(serialNumber);
	}
	
	private static void taskInfoOrderList(int serialNumber) {
		
		// -> 0 (first index)
		// -> collection.length - 1 (last index)
		
		// FOR
		int i = 0;
		
		for(;i < orderCollection.length; ) {
			
			Console.log( "Index " + i );
			Console.log(getMenuItem(orderCollection[i])); // 0 / 1 / 2
			
			// increment after the loop end
			// i = i + 1;
			// i += 1;
			i++;
		}
		
	
//		for(int i = 0; i < orderCollection.length; i++) {
//			
//			Console.log( "Index " + i );
//			Console.log(getMenuItem(orderCollection[i])); // 0 / 1 / 2
//		}

		// Endless loop
//		for(int i = 0; i < orderCollection.length; i--) {
//			
//			// Console.log( "Index " + i );
//			// Console.log(getMenuItem(orderCollection[i])); // 0 / 1 / 2
//		}
		
//		int i = 0;
//		while(i < orderCollection.length) {
//			
//			i++;
//		}
//		
		
		
		
//		if(orderCollection[0] != 0) Console.log(getMenuItem(orderCollection[0]));
//		if(orderCollection[1] != 0) Console.log(getMenuItem(orderCollection[1]));
//		if(orderCollection[2] != 0) Console.log(getMenuItem(orderCollection[2]));
//		if(orderCollection[3] != 0) Console.log(getMenuItem(orderCollection[3]));
//		if(orderCollection[4] != 0) Console.log(getMenuItem(orderCollection[4]));
	}
	
}
