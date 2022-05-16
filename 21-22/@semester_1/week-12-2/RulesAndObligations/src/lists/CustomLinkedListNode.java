package lists;

public class CustomLinkedListNode<T> {

	private CustomLinkedListNode<T> next;
	private T element;
	
	public CustomLinkedListNode(T element) {
		this.element = element;
	}
	
	public boolean hasNext() {
		return this.next != null;
	}
	
	public CustomLinkedListNode<T> getNext() {
		return this.next;
	}
	
	public void setNext(CustomLinkedListNode<T> element) {
		this.next = element;
	}	
	

	public T getElement() {
		return this.element;
	}
}
