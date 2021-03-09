public class Event {
	
	public int id;
	public String title;
	public boolean isAccessableForUnderaged;
	
	public Customer[] customerCollection;
	private int customerCollectionIndex = 0;
	
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
		this.customerCollection[this.customerCollectionIndex++] = customerObject;
	}

	public void removeCustomer(int customerId) {
		
		for(int i = 0; i < this.customerCollection.length; i++) {
			
			if(this.customerCollection[i] != null && 
				this.customerCollection[i].id == customerId) {
				
				this.customerCollection[i] = null;
				break;
			}
		}
	}
}
