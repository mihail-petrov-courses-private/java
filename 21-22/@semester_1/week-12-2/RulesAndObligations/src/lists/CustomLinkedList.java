package lists;

import interfaces.CustomListInterface;

public class CustomLinkedList<T> implements CustomListInterface<T> {

	private CustomLinkedListNode<T> head; 
	private int size;
	
	public CustomLinkedList() {
		// Do noting
	}
	
	@Override
	public void add(T element) {
		
		CustomLinkedListNode<T> newNode = new CustomLinkedListNode<>(element);
		this.size++;
		
		// first element
		if(this.head == null) {
			this.head = newNode;
			return;
		}
		
		CustomLinkedListNode<T> node = this.getLast();
		node.setNext(newNode);
	}

	@Override
	public void remove(int position) {
		
		// 1. Find element to remove
		CustomLinkedListNode<T> parent 			= this.getNode(position - 1);
		CustomLinkedListNode<T> nodeToRemove 	= parent.getNext();
		CustomLinkedListNode<T> child 			= nodeToRemove.getNext();
		
		parent.setNext(child);
		nodeToRemove.setNext(null);
		this.size--;
	}

	@Override
	public T get(int index) {
		return this.getNode(index).getElement();
	}
	

	@Override
	public int size() {
		return this.size;
	}
	
	private CustomLinkedListNode<T> getNode(int index) {
		
		if(index == 0) {
			return this.head;
		}
		
		int traverseIterator = 1;
		CustomLinkedListNode<T> node = this.head;
		while(node.hasNext()) {
			
			node = node.getNext();
			if(traverseIterator == index) {
				return node;
			}
			traverseIterator++;
		}
		
		return null;
	}	
	
	
	private CustomLinkedListNode<T> getLast() {

		CustomLinkedListNode<T> node = this.head;
		while(node.hasNext()) {
			node = node.getNext();
		}
		
		return node;
	}

}
