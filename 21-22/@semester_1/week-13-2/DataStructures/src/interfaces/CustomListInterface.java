package interfaces;

public interface CustomListInterface<T> {

	void add(T element);
	
	void remove(int position);
	
	T get(int index);
	
	int size();
}
