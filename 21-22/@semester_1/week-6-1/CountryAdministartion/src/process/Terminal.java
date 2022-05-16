package process;

import java.util.Random;

import util.Console;

public class Terminal {
	
	public static void start(int[] collection) {
		
		Console.log("Welcome to TERMINAL OS");
		Console.log("Please select you operation :");
		Console.log("1.  sort asc");
		Console.log("2.  sort desc");
		Console.log("3.  search for specific position");
		Console.log("4.  shuffle collection of inputs");
		Console.log("5.  summ all of the inmput");
		Console.log("6.  find max");
		Console.log("7.  find min ");
		Console.log("8.  find avg");
		Console.log("9.  find simetrical");
		Console.log("10. reverse");
		Console.log("11. Display all numbers");
		Console.log("12. Exit");
		
		int commandIndex = Console.inputInt();
		
		if(commandIndex == 1) {
			displayCollection(sortArray(collection));
			start(collection);
		}
		
		if(commandIndex == 2) {
			displayCollection(sortArrayDesc(collection));
			start(collection);
		}
		
		if(commandIndex == 3) {
			
			int serchableNumber = Console.inputInt("Please enter serachable number : ");
			int position = searchArray(collection, serchableNumber);
			String message = (position == -1) 
							 ? "No position found" 
							 : "Position is : " + position;
			Console.log(message);
			start(collection);
		}
		
		if(commandIndex == 4) {
			displayCollection(shuffleArray(collection));
			start(collection);
		}
		
		if(commandIndex == 5) {
			Console.log("Sum of all input is : " + getSum(collection));
			start(collection);
		}		
		
		if(commandIndex == 6) {
			Console.log("Max number is : " + getMax(collection));
			start(collection);
		}
		
		if(commandIndex == 7) {
			Console.log("Min number is : " + getMin(collection));
			start(collection);
		}		
		
		if(commandIndex == 8) {
			Console.log("Avrg sum is : " + getAvrg(collection));
			start(collection);
		}
		
		if(commandIndex == 9) {
			Console.log("Is array symetrical : " + isArraySimetrical(collection));
			start(collection);
		}
		
		if(commandIndex == 10) {
			displayCollection(reverseArray(collection));
			start(collection);
		}
		
		if(commandIndex == 11) {
			displayCollection(collection);
			start(collection);
		}
		
		if(commandIndex == 12) {
			Console.log("Exit .... ");
		}
	}
	
	private static int searchArray(int[] collection, int serchableNumber) {
		
		for(int i = 0; i < collection.length; i++) {
			
			if(collection[i] == serchableNumber) {
				return i;
			}
		}
		
		return -1;
	}
	
	private static int[] copy(int[] collection) {
		
		int[] copyCollection = new int[collection.length];
		for(int i = 0; i < collection.length; i++) {
			copyCollection[i] = collection[i];
		}
		
		return copyCollection;
	}	
	
	private static int[] shuffleArray(int[] collection) {
		
		int[] newCollection = copy(collection);
		
		for(int i = 0; i < newCollection.length; i++) {
			
			Random randomGenerator = new Random();
			int randomIndex = randomGenerator.nextInt(collection.length - 1);
			
			int tmpValue 		= newCollection[i]; 
			newCollection[i] 	= newCollection[randomIndex];
			newCollection[randomIndex] = tmpValue; 
		}
		
		return newCollection;
	}
	
	private static int[] sortArray(int[] collection) {
		
		int[] newCollection = copy(collection);
		
		for(int i = 0; i < collection.length; i++) {
			int minElement 			= collection[i];
			int minElementIndex 	= i;
			for(int j = (i + 1); j < collection.length; j++) {
				
				// find new minimal element
				if(collection[j] < minElement) {
					minElement 		= collection[j];
					minElementIndex = j; // 6 
				}
			}
			
			int tmpElement 		= newCollection[i]; 
			newCollection[i] 	= newCollection[minElementIndex];
			newCollection[minElementIndex] = tmpElement;
		}
		
		return newCollection;
	}
	
	private static int[] sortArrayDesc(int[] collection) {
		
		int[] newCollection = copy(collection);
		
		for(int i = 0; i < collection.length; i++) {
			int maxElement 			= collection[i];
			int maxElementIndex 	= i;
			for(int j = (i + 1); j < collection.length; j++) {
				
				// find new minimal element
				if(collection[j] > maxElement) {
					maxElement 		= collection[j];
					maxElementIndex = j; // 6 
				}
			}
			
			int tmpElement 		= newCollection[i]; 
			newCollection[i] 	= newCollection[maxElementIndex];
			newCollection[maxElementIndex] = tmpElement;
		}
		
		return newCollection;
	}	
	
	private static int getMin(int[] collection) {
		
		int[] newCollection = sortArray(collection);
		return newCollection[0];
	}
	
	private static int getMax(int[] collection) {
		
		int[] newCollection = sortArray(collection);
		return newCollection[newCollection.length - 1];		
	}
	
	private static int getSum(int[] collection) {
		
		int collectionSum = 0;
		for(int i = 0; i < collection.length; i++) {
			collectionSum += collection[i];
		}
		
		return collectionSum; 
	}
	
	private static int getAvrg(int[] collection) {
		return getSum(collection) / collection.length;
	}
	
	private static boolean isArraySimetrical(int[] collection) {
		
		for(int i = 0, 
				j = (collection.length - 1)
				;
				(i < j || i == j)
				; 
				i++, 
				j--) {
			
			if(collection[i] != collection[j]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int[] reverseArray(int[] collection) {
		
		int[] copyCollection = new int[collection.length];
		
		int copyIndex = 0;
		for(int i = (collection.length - 1); i != 0; i-- ) {
			copyCollection[copyIndex] = collection[i];
			copyIndex++;
		}
		
		return copyCollection; 
	}
	
	private static void displayCollection(int[] collection) {
		
		for(int i = 0; i < collection.length; i++) {
			Console.log(collection[i]);
		}
	}
	
	
}

