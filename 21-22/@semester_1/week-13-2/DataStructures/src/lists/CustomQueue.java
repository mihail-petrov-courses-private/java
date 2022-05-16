package lists;

public class CustomQueue<T> {

	private CustomLinkedList<T> collection;
	// private int top = -1;
	
	public CustomQueue() {
		this.collection = new CustomLinkedList<>();
	}
	
	// add 
	public void enqueue(T element) {
		this.collection.add(element);
	}
	
	public T peek() {
		return this.collection.get(0);
	}
	
	public T dequeue() {
		
		try {
			T element = this.collection.get(0);
			this.collection.remove(0);
			return element;	
		}
		catch(Exception e) {
			return null;
		}
	}
}
