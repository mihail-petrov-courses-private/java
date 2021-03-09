import process.Terminal;
import util.Console;

public class Application {

	public static void main(String[] args) {
		
		// int integerLiteral = 123;
		// Integer integerObject = new Integer(123); --> Do not use at all
		
		// Integer integerObject2 = new Integer(123);
		// System.out.print(integerObject + integerObject2);
		
		//int numberOfInputNumber = Console.inputInt("Please enter number of input number:");
		//String stringObject = new String("Hello world");

//			
		// create new array
		// int[] inputNumberCollection = new int[numberOfInputNumber];
//		for(int i = 0; i < numberOfInputNumber; i++) {
//			inputNumberCollection[i] = Console.inputInt("Enter number: ");
//		}
		
		// 10,10,10,52,14785
		String inputLine = Console.inputString("Please enter all of the nymbers separated by comma");
		
		//String newStringLiteral = "Hello world";
		// String newStringObject 	= new String("Hello world");
//		String numberCollection 	= "10,10,10,52,14785";
//		// split
//		String[] colection = numberCollection.split(",");
//		// Console.log("" + colection.length); -> CONCAT AND TRANSFORM
//		Console.log(String.valueOf(colection.length));
//		Console.log(colection[3]);
		
		String[] collection = inputLine.split(",");
		int[] inputNumberCollection = new int[collection.length];
		for(int i = 0; i < collection.length; i++) {
			inputNumberCollection[i] = Integer.parseInt(collection[i]);
		}
		Terminal.start(inputNumberCollection);
		
		
		// Hello World
		// Console.log();
		// System.out.print(inputLine.);
		
	}
}
