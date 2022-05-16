import java.util.Arrays;

public class Application {
	
	public static int slowSearch(int[] collection, int element) {
		
		for(int i = 0; i < collection.length; i++) {
			
			if(collection[i] == element) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	public static int binarySearch(int[] collection, int element) {
		
		Arrays.sort(collection);
		int leftSideIndex = 0;
		int rightSideIndex = collection.length - 1;
		
		while(leftSideIndex <= rightSideIndex) {
		
			int middleIndex  = (leftSideIndex + rightSideIndex) / 2;
			int pivotElement = collection[middleIndex]; 
			
			if(pivotElement == element) {
				return middleIndex;
			}
			
			// right side calculation
			if(pivotElement < element) {
				leftSideIndex = middleIndex + 1;
			}
			else {
				rightSideIndex = middleIndex - 1;
			}
		}
		
		
		return -1;
	}
	
	
	public static int[] selectionSort(int[] collection) {
		
		for(int outerIndex = 0; outerIndex < collection.length - 1; outerIndex++ ) {
			
			// 1,5,8, 10, 66, 99
			// min index - > 0
			// min value -> 1 
			int currentMinimalElementIndex = outerIndex;
			for(int innerIndex = outerIndex + 1; innerIndex < collection.length; innerIndex++) {
				
				if(collection[innerIndex] < collection[currentMinimalElementIndex]) {
					currentMinimalElementIndex = innerIndex; 
				}
			}
			
			int minElement 							= collection[currentMinimalElementIndex];
			collection[currentMinimalElementIndex] 	= collection[outerIndex];
			collection[outerIndex] 					= minElement; 
		}
		
		return collection;
	}
	
	
	// booble sort
	public static int[] boobleSort(int[] collection) {
		
		int outerLoopIteration = 0;
		int innerLoopIteration = 0;
		
		boolean hasSwap = false;
		
		
		
		// Outer loop
		for(int outerIndex = 0;  outerIndex < (collection.length - 1); outerIndex++ ) {
			
			int innerLoopLimit = (collection.length - outerIndex - 1);
			hasSwap = false;
			for(int innerIndex = 0; innerIndex < innerLoopLimit; innerIndex++ ) {
				
				int firstElement 	= collection[innerIndex];
				int secondElement 	= collection[innerIndex + 1];
				
				if(firstElement > secondElement ) {
					
					// preservation of left component data
					collection[innerIndex] = secondElement;
					collection[innerIndex + 1] = firstElement;
					hasSwap = true;
				}
				innerLoopIteration++;
			}
			
			
			if(hasSwap == false) {
				break;
			}
			
			
			outerLoopIteration++;
		}
		
		System.out.println("OL " + outerLoopIteration);
		System.out.println("IL " + innerLoopIteration);
		
		return collection;
	}
	
	public static void main(String[] args) {
		
		int[] collection = {
			66, 1, 8, 100, 99, 5, 178
		};
		
		// collection = selectionSort(collection);
		
		// build in sort method
		// Arrays.sort(collection);
		
		
		int index = binarySearch(collection, 178);
		System.out.println("Index -> " + index);
		
		
//		for(int i = 0; i < collection.length; i++) {
//			System.out.println(collection[i]);
//		}
		
		
	}
}
