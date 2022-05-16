import java.util.ArrayList;

public class CustomerManager {

    static ArrayList<Customer> collection = new ArrayList<Customer>();

    static void addCustomer(Customer newCustomer) {
        collection.add(newCustomer);
    }

    static Customer getCustomer(int index) {
        return collection.get(index);
    }

    static int getAllCustomerCount() {
        return collection.size();
    }
}