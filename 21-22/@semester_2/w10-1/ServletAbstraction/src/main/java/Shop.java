
// shop/sell
public class Shop extends AppController {

	@Override
	public void index() { // GET
		System.out.println("Shop COntroller init");
	}
	
	public void display() {
		
	}
	
	public void sell() { // POST
		System.out.println("Sell operation in action");
	}
}
