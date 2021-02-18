import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) {
		
		int serialNumber 		= Console.promt("Please enter serial number: ");
		MenuProcessor.orderMenuItem(serialNumber);
	}
}
