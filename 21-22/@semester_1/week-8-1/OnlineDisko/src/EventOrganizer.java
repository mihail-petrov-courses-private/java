import java.util.ArrayList;
import java.util.HashMap;

import models.Customer;
import models.Event;

public class EventOrganizer {
	
	private static int eventId = 1000;
	private static ArrayList<Event> eventCollection = new ArrayList<Event>();
	
	private static int customerId = 1000;
	private static ArrayList<Customer> customerCollection = new ArrayList<Customer>();
	
	// register 
	// ID(customer ) - (event register counter)
	private static HashMap<Integer, Integer> eventVisistedRegister = new HashMap<>();
	
	private static boolean IS_CREATE_NEW_EVENT_POSIBLE = true;
	
	public static void turnCreateEventOn() {
		IS_CREATE_NEW_EVENT_POSIBLE = true;
	}
	
	public static void turnCreateEventOff() {
		IS_CREATE_NEW_EVENT_POSIBLE = false;
	}
	
	public static void toggleCreateEvent() {
		IS_CREATE_NEW_EVENT_POSIBLE = !IS_CREATE_NEW_EVENT_POSIBLE; 
	}
	
	public static void createEvent(String eventTitle) {
		createEvent(eventTitle, true);
	}	
	
	public static void createEvent(String eventTitle, boolean isAccessableForUnderaged) {
		
		if(!IS_CREATE_NEW_EVENT_POSIBLE) {
			System.out.println("Добавяне на ново събитие е невъзможно");
			return;
		}
		
		Event newEvent = new Event((++eventId), eventTitle, isAccessableForUnderaged);
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
			if(eventObject != null) {
				eventObject.render();
				System.out.println("%%%");	
			}
			
		}
	}
	
	public static void removeEvent(int id) {
		
		for(int i = 0; i < eventCollection.size(); i++) {
						
			boolean isEventAvailable = isEventAvailable(id, eventCollection.get(i));
				
			if(isEventAvailable) {
			
				eventCollection.remove(i);
				break;
			}
		}
		
		System.out.println("The requested event is removed succesfuly");
	}
	
	
	public static void updateEvent(int id, String title, boolean isAccessableForUnderaged) {
			
		for(int i = 0; i < eventCollection.size(); i++) {
			
			boolean isEventAvailable = isEventAvailable(id, eventCollection.get(i));
			
			if(isEventAvailable) {
				
				Event element = eventCollection.get(i);
				element.setTitle(title);
				element.setIsAccessableForUnderaged(isAccessableForUnderaged);
				eventCollection.set(i, element);
				break;
			}
		}
		
		System.out.println("The requested event is updated succesfuly");
	}
	
	public void addCustomer(String fname, String lname, String gender, int age, double wallet) {
		
		Customer newCustomer = new Customer((++customerId), fname, lname, gender, age, wallet);
		customerCollection.add(newCustomer); 
	}
	
	public Event findEventById(int eventId) {
		
		for(int i = 0; i < eventCollection.size(); i++) {
			
			if(isEventAvailable(eventId, eventCollection.get(i))) {
				return eventCollection.get(i);
			}			
		}
		
		return null;
	}
	
	public Customer findCustomerById(int eventId) {
		
		
		for(int i = 0; i < customerCollection.size(); i++) {
			
			
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
		this.processEventVisitedRegister(customerObject);
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
	
	
	public Event getMaxGuestEvent() {
		
		int guestCount = 0;
		Event maxGuestCountEvent = null;
		
		for(Event element : eventCollection) {
			if(guestCount > element.getGuestCount() )
			{
				guestCount = element.getGuestCount();
				maxGuestCountEvent = element;
			}
		}
		
		return maxGuestCountEvent;
	}
	
	public static  void displayAllEventsPermitedForUnderagedCustomer() {
		
		for(Event element : eventCollection) {
			if(element.getIsAccessableForUnderaged() == true) {
				System.out.print(element.getTitle());
			}
		}
	}
	
	public static void groupAllEvents() {
		
		for(Event element : eventCollection) {
			String groupFlag = (element.getIsAccessableForUnderaged() == true) ? "#" : "*";
			System.out.print(groupFlag + element.getTitle());
		}
	}	
	
	
	public  static ArrayList<Event> filterEventCollection(String eventName) {
		
		ArrayList<Event> filterEventCollection = new ArrayList<>();
		for(Event element: eventCollection) {
			if(element.getTitle().equals(eventName)) {
				filterEventCollection.add(element);
			}
		}
		
		return filterEventCollection; 
	}
	
	public  static ArrayList<Event> filterEventCollection(boolean  isPermitedForUnderaged) {

		ArrayList<Event> filterEventCollection = new ArrayList<>();
		for(Event element: eventCollection) {
			if(element.getIsAccessableForUnderaged() == isPermitedForUnderaged) {
				filterEventCollection.add(element);
			}
		}
		
		return filterEventCollection;
	}	
	
	public  static ArrayList<Event> filterEventCollection(String eventName, boolean  isPermitedForUnderaged) {

		ArrayList<Event> filterEventCollection = new ArrayList<>();
		for(Event element: eventCollection) {
			
			boolean hasAvailableName = element.getTitle().equals(eventName);
			boolean hasAvailablePermition = element.getIsAccessableForUnderaged() == isPermitedForUnderaged;
			boolean isFilterable =  hasAvailableName &&
									hasAvailablePermition;
			
			if(isFilterable) {
				filterEventCollection.add(element);
			}
		}
		
		return filterEventCollection;
	}		
	
	private static boolean isEventAvailable(int id, Event event) {
		
		return	(event != null) &&
				(event.getId() == id);
	}
	
	private static boolean isCustomerAvailable(int id, Customer customer) {
		
		return	(customer != null) &&
				(customer.getId() == id);
	}
	
	private void processEventVisitedRegister(Customer customerObject) {
		
		// increment visited events
		int currentValue = eventVisistedRegister.get(customerObject.getId()); 
		eventVisistedRegister.put(customerId, currentValue + 1);
		
		if(this.isCustomerPromotableToVIP()) {
			customerObject.setVIPStatus();
			eventVisistedRegister.put(customerId, 0);
		}
	}
		
	private boolean isCustomerPromotableToVIP() {
		
		int eventPresentCounter = 0;
		for(Event element : eventCollection) {
			
			if(eventPresentCounter == 5) {
				return true;
			}			
			
			if(element.isCustomerPresent(customerId)) {
				eventPresentCounter++;
			}
		}
		
		return false;
	}
	
}
