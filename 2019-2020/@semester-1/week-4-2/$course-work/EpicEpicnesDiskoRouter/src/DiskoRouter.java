import java.util.ArrayList;

public class DiskoRouter {

    public static void main(String[] args) {

        // 1. Customer dossier module
        int numberVariable = 10;
        Customer customerReference = new Customer("Mihail",
                "Petrov",
                27,
                "A256874563");
        //customerReference.fname             = "Mihail";
        //customerReference.lname             = "Petrov";
        // customerReference.age               = 27;
        // customerReference.idNumber          = "A256874563";
        // customerReference.numberOfVisits    = 0;
        // System.out.println(customerReference.permitionToStay);
        System.out.println(customerReference.getFullName());

        Customer newVisitor = new Customer("Ivan", "Dimitrov", 10, "A88542365");
        // newVisitor.fname                    = "Ivan";
        // newVisitor.lname                    = "Dimitrov";
        // newVisitor.age                      = 19;
        // newVisitor.setAge(5);
        // newVisitor.idNumber                 = "A88542365";

        // String id = "Id reference";
        // String id = new String("Id reference");

        newVisitor.numberOfVisits = 0;
        newVisitor.permitionToStay = "B";
        System.out.println(newVisitor.getFullName());
        System.out.println(newVisitor.getAge());
        // Customer.permitionToStay            = "B";


//        ArrayList<Customer> customerCollection = new ArrayList<Customer>();
//
//        // 0
//        customerCollection.add(new Customer("B1", "BB1",19, "AAABBCC11" ));
//        // 1
//        customerCollection.add(new Customer("C1", "CC1",20, "AAABBCC15" ));
//
//        System.out.println("Collection size " + customerCollection.size());
//        Customer customerFromCollection = customerCollection.get(0);
//        System.out.println(customerFromCollection.getFullName());

        CustomerManager.addCustomer(new Customer("B1", "BB1", 19, "AAABBCC11"));
        CustomerManager.addCustomer(new Customer("C1", "CC1", 20, "AAABBCC15"));
        System.out.println(CustomerManager.getAllCustomerCount());

        // Loop : with iteration step
        // 1 loop cycle = 1 iteration
        Customer activeCustomer;

        // i++
        // i += 1
        // i = i + 1
        for (int i = 0; i < CustomerManager.getAllCustomerCount(); i++) {

            System.out.println("*");
            activeCustomer = CustomerManager.getCustomer(i);
            System.out.println(activeCustomer.getFullName());
//            System.out.println("Loop cycle " + i);
            System.out.println(CustomerManager.getCustomer(i).getFullName());

        }

        // if(i < 10) {
        //  System.out.println("*");
        //  System.out.println("Loop cycle");
        //  i = i + 1
        // }
        // if(i < 10) {
        //  System.out.println("*");
        //  System.out.println("Loop cycle");
        //  i = i + 1
        // }





        // 2. Event dossier
    }
}