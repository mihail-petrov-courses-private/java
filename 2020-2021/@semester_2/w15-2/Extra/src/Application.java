import java.util.ArrayList;
import java.util.function.Consumer;

public class Application {
	
	public static void main(String[] args) {
		
		// Version 1
		// #
		ArrayList<Integer> collection = new ArrayList<>();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		
		CollectionProcessor processor = new CollectionProcessor();
		collection.forEach(processor);
		
		// Version 2
		// #
		ArrayList<Integer> collectionWithAnonimusClass = new ArrayList<>();
		collectionWithAnonimusClass.add(10);
		collectionWithAnonimusClass.add(20);
		collectionWithAnonimusClass.add(30);
		
		collectionWithAnonimusClass.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("Anonimus Selector -> " + t );
			}
		});
		
		// Version 3
		// #
		ArrayList<Integer> collectionWithLambda = new ArrayList<>();
		collectionWithLambda.add(100);
		collectionWithLambda.add(200);
		collectionWithLambda.add(300);		
		
		collectionWithLambda.forEach( (Integer element) -> {
			System.out.println("Lambda Selector ->" + element);
		});
		
		collectionWithLambda.forEach( (Integer element) ->  
			System.out.println("Lambda Selector ->" + element)
		);
		
		// Example 
		System.out.println("@@@@");
		ArrayList<Integer> oddEven = new ArrayList<>();
		oddEven.add(1);
		oddEven.add(2);
		oddEven.add(3);
		oddEven.add(4);
		
		oddEven.removeIf((Integer element) -> {
			return element % 2 == 0;
		});
		
		oddEven.removeIf((Integer element) -> element % 2 == 0);
		
		oddEven.forEach((Integer element)  -> System.out.println(element));
	}
}

