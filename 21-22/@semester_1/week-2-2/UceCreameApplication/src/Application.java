import java.util.Scanner;

class Application {

	public static void main(String[] args) {
		
		// type casting - explicit 
		int numberOfProduct;
		int numberOfProductsForADay 	= (int)10.5 ;
		int manifaturedProductsPerDay 	= 100;
		
		
		
		// type casting - implicit
		double capacityOfIceCreameMaterial = 10;
		
		
		System.out.println(numberOfProductsForADay);
		System.out.println(capacityOfIceCreameMaterial);
		
		double productPrice = 5.57;
		System.out.println(productPrice);
		
		String productTitle = "EXTREME ICE CREAME";
		System.out.println(productTitle);
		
		boolean isProductionOn = true;
		System.out.println(isProductionOn);
		
		
		char serialId 	 = 'A'; // 65
		// String serialId 	= "A";
		int serialNumber = 123;
		
		// this is not a concatenation 
		// * this is sum operation 
		int serialNumberId = serialId +  serialNumber;
		System.out.println(serialNumberId);
		
		String serialIdString = "A";
		int 	serialNumberInt = 123;
		String serialNumberIdString = serialIdString + serialNumberInt;  
		System.out.println(serialNumberIdString);
			
		//String serialIdNumber = serialId + serialNumber;
		//String serialStringExample = (String)10;
		
		// бит 	= 0 / 1
		// байт = 8 бита
		
		// String array
		String[] colorCollection = {
			"RED",		// position 	-> 0 <=> index 
			"GREEN",  	// position 	-> 1 <=> index
			"BLUE"		// position 	-> 2 <=> index
		};
		
		System.out.println(colorCollection[0]);
		
		// Exception try to access unexitsion element
		// System.out.println(colorCollection[3]);
		
		colorCollection[0] = "YELLOW";
		System.out.println(colorCollection[0]);
		
		// Try to compute element out of bound
		//colorCollection[4] = "NEW_ELEMENT";
		
		// colorCollection.length // 3 
		System.out.println("Length of array is " + colorCollection.length);
		
		Scanner scanner = new Scanner(System.in);
		String fenName = scanner.nextLine();
		System.out.println(fenName);
		
	}	
}
