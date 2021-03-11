package models;

import java.util.ArrayList;

public class Event {
	
	private int id;
	private String title;
	private boolean isAccessableForUnderaged;
	
	// private Customer[] customerCollection;
	private ArrayList<Customer> customerCollection;
	// private int customerCollectionIndex;
	
	public Event(int id, String title, boolean isAccessable) {
		
		this.setId(id);
		this.setTitle(title);
		this.setIsAccessableForUnderaged(isAccessable);
		
		// this.customerCollection  		= new Customer[100];
		this.customerCollection 		= new ArrayList<Customer>();
		// this.customerCollectionIndex 	= 0;
	}
	
	public Event(int id, String title) {
		
		this.setId(id);
		this.setTitle(title);
		this.setIsAccessableForUnderaged(true);
	}	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setIsAccessableForUnderaged(boolean isAccessableForUnderaged) {
		this.isAccessableForUnderaged = isAccessableForUnderaged;
	}
	
	public boolean getIsAccessableForUnderaged() {
		return isAccessableForUnderaged;
	}
	
	public void render() {
		
		String message = (this.isAccessableForUnderaged)
							? "$This Party is applicable for every one"
							: "$This party is for adoults only!!!";
		
		System.out.println("Party id	: " + this.id);
		System.out.println("Party name: " + this.title);
		System.out.println(message);
	}
	
	public void listAllCustomer() {
		
		for(Customer customer : this.customerCollection) {
			customer.render();
		}
	}

	public void addCustomer(Customer customerObject) {
		// this.customerCollection[this.customerCollectionIndex++] = customerObject;
		this.customerCollection.add(customerObject);
	}

	public void removeCustomer(int customerId) {
		
		// for(int i = 0; i < this.customerCollection.length; i++) {
		for(int i = 0; i < this.customerCollection.size(); i++) {
			
			if(this.customerCollection.get(i).getId() == customerId) {
				this.customerCollection.remove(i);
				break;
			}
			
			
//			if(this.customerCollection[i] != null && 
//				// this.customerCollection[i].id == customerId
//					this.customerCollection[i].getId() == customerId
//				) {
//				
//				this.customerCollection[i] = null;
//				break;
//			}
		}
	}
}
