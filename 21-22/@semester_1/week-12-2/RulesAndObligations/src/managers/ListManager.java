package managers;

import interfaces.CustomListInterface;

public class ListManager {

	public void traverse(CustomListInterface list) {
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void add(CustomListInterface list, Object element) {
		list.add(element);
	}
	
	public void remove(CustomListInterface list, int element) {
		list.remove(element);
	}	
}
