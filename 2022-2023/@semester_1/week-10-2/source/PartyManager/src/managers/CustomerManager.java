package managers;

import types.Customer;
import util.Terminal;

public class CustomerManager {

    private static final int COLLECTION_SIZE = 10;
    private static Customer[] customerCollection   = new Customer[COLLECTION_SIZE];
    private static int customerCollectionIndex     = 0;

    public static boolean hasRegisteredCustomers() {
        return customerCollectionIndex > 0;
    }

    public static Customer createCustomer(String firstName, String lastName, String gender, int age) {

        Customer newCustomer = new Customer(firstName, lastName, gender, age);
        customerCollection[customerCollectionIndex++] = newCustomer;

        return newCustomer;
    }

    public static void listAllCustomers() {

        for(Customer customer : customerCollection) {
            Terminal.outputObject(customer);
        }
    }

    public static Customer getCustomerById(int selectedCustomerId) {

        for(Customer customer : customerCollection) {
            if(customer.getId() == selectedCustomerId) {
                return customer;
            }
        }
        return null;
    }

    public static int getCustomerIndexById(int selectedCustomerId) {

        for(int i = 0; i < customerCollection.length; i++) {

            Customer selectedCustomer   =   customerCollection[i];
            boolean isMatchingId        =   selectedCustomer != null &&
                                            selectedCustomer.getId() == selectedCustomerId;

            if(isMatchingId) {
                return i;
            }
        }

        return -1;
    }
}
