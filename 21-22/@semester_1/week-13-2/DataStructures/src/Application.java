import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javax.print.attribute.SetOfIntegerSyntax;

import lists.CustomQueue;
import lists.CustomStack;

public class Application {

	public static void main(String[] args) {
		
		// Top 10 Data structures
		
		// 1. Array (масив)
		// # специална характеристика - има индекси
		// * търсене 	
		//	- бързо по индекс 
		// 	- бавно по принцип
		
		// * добавяне (нов)
		// - бавно по принцип
		
		// * премахване (съществуващ)
		// - бавно по принцип
		
		// 2. List (списък)
		
		// 2.1 ArrayList (списък реализиран с масив)
		// # специална характеристика - безкраен
		// * търсене 	
		//	- бързо по индекс 
		// 	- бавно по принцип
		
		// * добавяне (нов)
		// - бавно по принцип
		
		// * премахване (съществуващ)
		// - бавно по принцип
		
		// 2.2 LinkedList (свързън списък)
		// # специална характеристика - безкраен
		// * търсене 	 
		// 	- бавно по принцип
		
		// * добавяне (нов)
		// - бързо по принцип
		
		// * премахване (съществуващ)
		// - бързо по принцип
		
		// 2.3 Stack (стек / магазинен автомат)
		// FILO - First In Last Out
		// LIFO - Last In First Out
		Stack<Integer> stackCcollection = new Stack<>();
		// # специална характеристика - посока + безкраен
		// * търсене 	 
		// 	- няма
		
		// * добавяне (нов)
		// - бързо по принцип
		
		// * премахване (само от върха)
		// - бързо по принцип
//		CustomStack<Integer> collection = new CustomStack<>();
//		collection.push(1);
//		collection.push(2);
//		collection.push(3);
//		System.out.println(collection.peek());
//		System.out.println(collection.peek());
//		System.out.println(collection.pop());
//		System.out.println(collection.peek());
//		System.out.println(collection.pop());
//		System.out.println(collection.pop());
//		System.out.println(collection.pop());
//		System.out.println(collection.pop());
//		System.out.println(collection.pop());
//		System.out.println(collection.pop());
		
		// 2.4 Queue (опашка)
		// FIFO
		// # специална характеристика - посока + безкраен
		// * търсене 	 
		// 	- няма
		
		// * добавяне (нов)
		// - бързо по принцип
		
		// * премахване (само от върха)
		// - бързо по принцип		
//		CustomQueue<Integer> customQueue = new CustomQueue<>();
//		customQueue.enqueue(1);
//		customQueue.enqueue(2);
//		customQueue.enqueue(3);
//		customQueue.enqueue(4);
//		customQueue.enqueue(5);
//		
//		System.out.println(customQueue.peek());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
//		System.out.println(customQueue.dequeue());
		
		// 3. HashMap (хеш таблица) [реда на елементите не съществува като концепция]
		// # специална характеристика - супер полезен при търсене
		// * търсене 	 
		// 	- супер бързо
		
		// * добавяне (нов)
		// - бързо по принцип (защото няма значение)
		
		// * премахване (само от върха)
		// - бързо по принцип (защото няма значение)
		
		// HashMap<String, HashMap<String, HashMap<String, String>>> collection = new HashMap<>();
		HashMap<String,String> collection = new HashMap<>();
		collection.put("0886505050", "Mihail Petrov");
		collection.put("0886505050", "Todor Petrov");
		System.out.println(collection.get("0886505050"));
		
		// 4. Set (множество)
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(1);
		
		Object[] numberCollection = hashSet.toArray();
		for(int i = 0; i < numberCollection.length; i++) {
			System.out.println(numberCollection[i]);
		}
	}
}
