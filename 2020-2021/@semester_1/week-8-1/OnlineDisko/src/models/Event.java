package models;

import java.util.ArrayList;
import java.util.Date;

public class Event {
	
	private int id;
	private String title;
	private boolean isAccessableForUnderaged;
	private ArrayList<Customer> customerCollection;
	private Date insertDate;
	private double price;
	
	public Event(int id, String title, boolean isAccessable, double price) {
		
		this.setId(id);
		this.setTitle(title);
		this.setIsAccessableForUnderaged(isAccessable);
		this.setPrice(price);
		
		// *** 
		this.customerCollection = new ArrayList<Customer>();
		this.insertDate 		= new Date(); 
	}	
	
	public Event(int id, String title, boolean isAccessable) {
		
		this.setId(id);
		this.setTitle(title);
		this.setIsAccessableForUnderaged(isAccessable);
		this.setPrice(0);
		
		// *** 
		this.customerCollection = new ArrayList<Customer>();
		this.insertDate 		= new Date(); 
	}
	
	public Event(int id, String title) {
		
		this.setId(id);
		this.setTitle(title);
		this.setIsAccessableForUnderaged(true);
		this.setPrice(0);
		
		// *** 
		this.customerCollection = new ArrayList<Customer>();
		this.insertDate 		= new Date();		
		
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
		String eventNameDecorator = this.getEventNameDecorator(); 
		
		System.out.println("Party id	: 	" + this.id);
		System.out.println("Party name: 	" + eventNameDecorator + this.getTitle());
		System.out.println(message);
	}
	
	public void listAllCustomer() {
		
		for(Customer customer : this.customerCollection) {
			customer.render();
		}
	}

	public void addCustomer(Customer customerObject) {
				
		if(customerObject.isVIP()) {

			this.customerCollection.add(customerObject);
			return;
		}
		
		if(customerObject.isPaymentProcessable(this.price)) {
			
			customerObject.decreseWallet(this.price);
			this.customerCollection.add(customerObject);	
		}
	}

	public void removeCustomer(int customerId) {
		
		for(int i = 0; i < this.customerCollection.size(); i++) {
			
			if(this.customerCollection.get(i).getId() == customerId) {
				this.customerCollection.remove(i);
				break;
			}
		}
	}
	
	public int getGuestCount() {
		return this.customerCollection.size();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isFree() {
		return this.getPrice() == 0;
	}
	
	public boolean isPayed() {
		return !this.isFree();
	}
	
	public boolean isCustomerPresent(int customerId) {
		
		for(Customer element: this.customerCollection) {
			
			if(element.getId() == customerId) {
				return true;
			}
		}
		
		return false;
	}
	
	private String getEventNameDecorator() {
		
		if(this.isFree()) return "!";
		return "$";
	}
}
