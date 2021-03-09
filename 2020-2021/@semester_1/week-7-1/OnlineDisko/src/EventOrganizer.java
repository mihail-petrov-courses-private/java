public class EventOrganizer {
	
	private static int eventId = 1000;
	private static int eventCollectionIndex = 0;
	private static Event[] eventCollection = new Event[100];
	
	private static int customerId = 1000;
	private static int customerCollectionIndex = 0;
	private static Customer[] customerCollection = new Customer[100];
	
	public static void createEvent(String eventTitle) {
		createEvent(eventTitle, true);
	}	
	
	public static void createEvent(String eventTitle, boolean isAccessableForUnderaged) {
		
		// create new object
		Event newEvent 						= new Event();
		newEvent.id							= ++eventId;	
		newEvent.title 						= eventTitle;
		newEvent.isAccessableForUnderaged 	= isAccessableForUnderaged;
		newEvent.customerCollection 		= new Customer[100];
		
		// push object to collection
		eventCollection[eventCollectionIndex++] = newEvent;
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
		
		for(int i = 0; i < eventCollection.length; i++) {
			
			boolean isEventAvailable = isEventAvailable(id, eventCollection[i]);			
			
			if(isEventAvailable) {
				eventCollection[i] = null;
				break; // from loop
				// return; // from method
			}
		}
		
		System.out.println("The requested event is removed succesfuly");
	}
	
	
	public static void updateEvent(int id, String title, boolean isAccessableForUnderaged) {
			
		for(int i = 0; i < eventCollection.length; i++) {
			
			boolean isEventAvailable = isEventAvailable(id, eventCollection[i]);
			
			if(isEventAvailable) {
				eventCollection[i].title 					= title;
				eventCollection[i].isAccessableForUnderaged = isAccessableForUnderaged;
				break; // from loop
				// return; // from method
			}
		}
		
		System.out.println("The requested event is updated succesfuly");
	}
	
	public void addCustomer(String fname, String lname, String gender, int age) {
		
		Customer newCustomer = new Customer();
		newCustomer.id 		= ++customerId;
		newCustomer.fname  	= fname;
		newCustomer.lname  	= lname;
		newCustomer.gender 	= gender;
		newCustomer.age		= age;
		customerCollection[customerCollectionIndex++] = newCustomer; 
	}
	
	public Event findEventById(int eventId) {
		
		for(int i = 0; i < eventCollection.length; i++) {
			
			if(isEventAvailable(eventId, eventCollection[i])) {
				return eventCollection[i];
			}
		}
		
		return null;
	}
	
	public Customer findCustomerById(int eventId) {
		
		for(int i = 0; i < customerCollection.length; i++) {
			
			if(isCustomerAvailable(eventId, customerCollection[i])) {
				return customerCollection[i];
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
				(event.id == id);
	}
	
	private static boolean isCustomerAvailable(int id, Customer customer) {
		
		return	(customer != null) &&
				(customer.id == id);
	}	
}
