package lists;

import interfaces.CustomListInterface;

public class CustomArrayList<T> implements CustomListInterface<T>  {

	private Object[] collection;
	private final int COLLECTION_INIT_SIZE;
	private int index;
	
	public CustomArrayList() {
		
		this.COLLECTION_INIT_SIZE 	= 25;
		this.collection 			= new Object[COLLECTION_INIT_SIZE];
		this.index = 0;
	}
	
	@Override
	public void add(T element) {
		
		// 1. check if array have empty spaces
		// 2. Add element to array
		// 3. move index to next element
		
		// 0 ==> 10
		try {
			this.collection[this.index++] = element;	
		} catch(Exception e) {
			
			Object[] newCollection = new Object[(this.collection.length * 2)];
			for(int i = 0; i < this.collection.length; i++) {
				newCollection[i] = this.collection[i];
			}
			this.collection = newCollection;
			this.collection[this.index++] = element;
		}
	}

	@Override
	public void remove(int index) {
		
		Object[] newCollection = new Object[this.collection.length];
		int newCollectionIndex = 0;
		for(int i = 0; i < this.collection.length; i++ ) {
			
			if(index != i) {
				newCollection[newCollectionIndex++] = this.collection[i];	
			}
		}
		
		this.collection = newCollection;
		this.index--;
		
		// 1 | 2 | 3 | 4 | 5 --> from index
		// 2 | 3 | 4 | 5 | 0
		
		// 1 | 2 | 3 | 4 | 5 --> from index
		// 1 | 3 | 4 | 5 | 0
	}

	@Override
	public T get(int index) {
		return (T)this.collection[index]; // Object
	}

	@Override
	public int size() {
		return this.index;
	}
}
