import java.util.ArrayList;

public class DiskoRouter {

    public static void main(String[] args) {

        // 1. Customer dossier module
        int numberVariable = 10;
        Customer customerReference = new Customer("Mihail",
                "Petrov",
                27,
                "A256874563");

        System.out.println(customerReference.getFullName());

        Customer newVisitor = new Customer("Ivan", "Dimitrov", 10, "A88542365");

        newVisitor.numberOfVisits = 0;
        newVisitor.permitionToStay = "B";
        System.out.println(newVisitor.getFullName());
        System.out.println(newVisitor.getAge());

        CustomerManager.addCustomer(new Customer("B1", "BB1", 19, "AAABBCC11"));
        CustomerManager.addCustomer(new Customer("C1", "CC1", 20, "AAABBCC15"));
        System.out.println(CustomerManager.getAllCustomerCount());


        Customer activeCustomer;

        for (int i = 0; i < CustomerManager.getAllCustomerCount(); i++) {

            System.out.println("*");
            activeCustomer = CustomerManager.getCustomer(i);
            System.out.println(activeCustomer.getFullName());
            System.out.println(CustomerManager.getCustomer(i).getFullName());
        }

        //
        CollectionExample collectionReference = new CollectionExample();
        collectionReference.exampleArray();
        collectionReference.exampleArrayList();

        //
        CustomerManager.getNumberOfCustomers();
        // ? 100
        CustomerManager.addCustomerToArray(new Customer("C1", "CC1", 20, "AAABBCC15"));
        System.out.println(CustomerManager.customerCollectionWithArray[0].getFullName());
        CustomerManager.addCustomerToArray(new Customer("D1", "DD1", 20, "AAABBCC15"));
        System.out.println(CustomerManager.customerCollectionWithArray[1].getFullName());
    }
}