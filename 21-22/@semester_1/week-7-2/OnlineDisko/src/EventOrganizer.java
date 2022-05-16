import java.util.ArrayList;

import models.Customer;
import models.Event;

public class EventOrganizer {
	
	private static int eventId = 1000;
	// private static int eventCollectionIndex = 0;
	// private static Event[] eventCollection = new Event[100];
	private static ArrayList<Event> eventCollection = new ArrayList<Event>();
	
	private static int customerId = 1000;
	//private static int customerCollectionIndex = 0;
	//private static Customer[] customerCollection = new Customer[100];
	private static ArrayList<Customer> customerCollection = new ArrayList<Customer>();
	
	public static void createEvent(String eventTitle) {
		createEvent(eventTitle, true);
	}	
	
	public static void createEvent(String eventTitle, boolean isAccessableForUnderaged) {
		
		Event newEvent = new Event((++eventId), eventTitle, isAccessableForUnderaged);

		// eventCollection[eventCollectionIndex++] = newEvent;
		eventCollection.add(newEvent);
	}
	
	// API -> Application programable interface
	public static void createPartyForAdoult(String title) {
		createEvent(title, false);
	}
	
	public static void createPartyForAll(String title) {
		createEvent(title, true);
	}
	
	public static void listAllEvents() {
		
		for(Event eventObject : eventCollection) {
			
			// TODO: How to optimize this process
			//if(eventObject == null) break;
			
			if(eventObject != null) {
				eventObject.render();
				System.out.println("%%%");	
			}
			
		}
	}
	
	public static void removeEvent(int id) {
		
		// for(int i = 0; i < eventCollection.length; i++) {
		for(int i = 0; i < eventCollection.size(); i++) {
			
			// boolean isEventAvailable = isEventAvailable(id, eventCollection[i]);			
			boolean isEventAvailable = isEventAvailable(id, eventCollection.get(i));
				
			if(isEventAvailable) {
				// eventCollection[i] = null;
				// eventCollection.set(i, null);
				eventCollection.remove(i);
				break; // from loop
				// return; // from method
			}
		}
		
		System.out.println("The requested event is removed succesfuly");
	}
	
	
	public static void updateEvent(int id, String title, boolean isAccessableForUnderaged) {
			
		// for(int i = 0; i < eventCollection.length; i++) {
		for(int i = 0; i < eventCollection.size(); i++) {
			
			// boolean isEventAvailable = isEventAvailable(id, eventCollection[i]);
			boolean isEventAvailable = isEventAvailable(id, eventCollection.get(i));
			
			if(isEventAvailable) {
				
				// Example 1: using object reference
				Event element = eventCollection.get(i);
				element.setTitle(title);
				element.setIsAccessableForUnderaged(isAccessableForUnderaged);
				eventCollection.set(i, element);
				
				// Example 2: using collection reference				
				// eventCollection.get(i).setTitle(title);
				// eventCollection.get(i).setIsAccessableForUnderaged(isAccessableForUnderaged);
				
				
				// eventCollection[i].title 					= title;
				// eventCollection[i].setTitle(title);
				// eventCollection.get(i).setTitle(title);
				
				
				// eventCollection[i].isAccessableForUnderaged = isAccessableForUnderaged;
				// eventCollection[i].setIsAccessableForUnderaged(isAccessableForUnderaged);
				break; // from loop
				// return; // from method
			}
		}
		
		System.out.println("The requested event is updated succesfuly");
	}
	
	public void addCustomer(String fname, String lname, String gender, int age) {
		
		Customer newCustomer = new Customer((++customerId), fname, lname, gender, age);
		customerCollection.add(newCustomer);
		//customerCollection[customerCollectionIndex++] = newCustomer; 
	}
	
	public Event findEventById(int eventId) {
		
		//for(int i = 0; i < eventCollection.length; i++) {
		for(int i = 0; i < eventCollection.size(); i++) {
			
//			if(isEventAvailable(eventId, eventCollection[i])) {
//				return eventCollection[i];
//			}
			
			if(isEventAvailable(eventId, eventCollection.get(i))) {
				return eventCollection.get(i);
			}			
		}
		
		return null;
	}
	
	public Customer findCustomerById(int eventId) {
		
		// for(int i = 0; i < customerCollection.length; i++) {
		for(int i = 0; i < customerCollection.size(); i++) {
			
//			if(isCustomerAvailable(eventId, customerCollection[i])) {
//				return customerCollection[i];
//			}
			
			if(isCustomerAvailable(eventId, customerCollection.get(i))) {
				return customerCollection.get(i);
			}
		}
		
		return null;
	}	
	
	public void addCustomerToEvent(int eventId, int customerId) {
		
		// find event
		Event eventObject = findEventById(eventId);
		
		// find customer
		Customer customerObject = findCustomerById(customerId);
		
		eventObject.addCustomer(customerObject);
		
	}
	
	
	public void listCustomerForEvent(int eventId) {
		
		Event eventObject = findEventById(eventId);
		
		if(eventObject != null) {
			eventObject.listAllCustomer();	
		}
		else {
			System.out.println("This event does not exists");	
		}
	}
	
	public void removeCustomerFromEvent(int eventId, int customerId) {
		
		Event eventObject = findEventById(eventId);
		
		if(eventObject != null) {
			eventObject.removeCustomer(customerId);	
		}
		else {
			System.out.println("This event does not exists");	
		}
	}	

	private static boolean isEventAvailable(int id, Event event) {
		
		return	(event != null) &&
				// (event.id == id);
				(event.getId() == id);
	}
	
	private static boolean isCustomerAvailable(int id, Customer customer) {
		
		return	(customer != null) &&
				// (customer.id == id);
				(customer.getId() == id);
	}	
}
