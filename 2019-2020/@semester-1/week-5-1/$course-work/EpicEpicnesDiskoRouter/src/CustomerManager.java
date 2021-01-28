import java.util.ArrayList;

public class CustomerManager {

    static ArrayList<Customer> collection = new ArrayList<Customer>();
    static Customer[] customerCollectionWithArray = new Customer[100];
    static int index = 0;

    static void getNumberOfCustomers() {
        System.out.println("Number of customers is : " + customerCollectionWithArray.length);
    }

    static void addCustomerToArray(Customer newCustomer) {

        customerCollectionWithArray[index] = newCustomer;
        index++;
    }


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