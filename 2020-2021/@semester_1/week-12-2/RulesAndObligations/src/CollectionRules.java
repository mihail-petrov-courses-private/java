import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import interfaces.CustomListInterface;
import lists.CustomArrayList;
import lists.CustomLinkedList;
import lists.CustomLinkedListNode;
import managers.ListManager;
import model.Stock;

public class CollectionRules {

	public static void main(String[] args) {
	
		
		// List<Integer> collection = new ArrayList<Integer>();
		// ArrayList collection = new ArrayList();
		// LinkedList<E>
		
		// CustomListInterface<Stock> collection = new CustomArrayList<Stock>();
		CustomListInterface<Stock> collection = new CustomLinkedList<Stock>();
		
//		System.out.println("$ Add action");
//		collection.add(0);
//		collection.add(1);
//		collection.add(2);
//		collection.add(3);
//		collection.add(4);
//		collection.add(5);
//		
//		for(int i = 0; i < collection.size(); i++) {
//			System.out.println(collection.get(i));
//		}
//		
//		System.out.println("$ Remove action");
//		collection.remove(2);
//		collection.remove(2);
//		
//		for(int i = 0; i < collection.size(); i++) {
//			System.out.println(collection.get(i));
//		}		
		
		
		ListManager listManager = new ListManager();
		System.out.println("$ Add action");
		listManager.add(collection, new Stock("Apple"			, "APL", 10));
		listManager.add(collection, new Stock("Google"			, "GGL", 5));
		listManager.add(collection, new Stock("Microsoft"		, "MSS", 7));
		listManager.add(collection, new Stock("Tesla"			, "TES", 7));
		listManager.add(collection, new Stock("Netflix"			, "NEF", 7));
		listManager.add(collection, new Stock("ET Chicho Mitko"	, "ETC", 7));
		
		listManager.traverse(collection);
		
		System.out.println("$ Remove action");
		listManager.remove(collection, 2);
		listManager.traverse(collection);		
		
	}
}
