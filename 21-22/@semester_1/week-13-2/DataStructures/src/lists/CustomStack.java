package lists;

public class CustomStack<T> {

	private CustomLinkedList<T> collection;
	private int top;
	
	public CustomStack() {

		this.collection = new CustomLinkedList<>();
		this.top = -1;
	}
		
	public void push(T element) {

		this.collection.add(element);
		this.top++;
	}
	
	public T pop() {
		
		if(this.top == -1) {
			return null;
		}
		
		T element = this.collection.get(this.top);
		this.collection.remove(this.top);
		this.top--;
		
		return element;
	}	
	
	public T peek() {
		
		try {
			return this.collection.get(this.top);	
		}
		catch(Exception e) {
			return null;
		}
	}	
}
