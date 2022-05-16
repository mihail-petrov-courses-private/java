import java.util.ArrayList;

public class CollectionExample {

    void exampleArray() {

        // consistent datatype
        int[] collectionOfNumbers = new int[10];
        boolean[] collectionOfBooleans = new boolean[10];

        System.out.println("Collection of booleans");
        System.out.println(collectionOfBooleans[0]);


        String[] collorArray = new String[]{
          "red", "green", "blue", "yello"
        };

        Customer[] customerCollection = new Customer[] {
                new Customer("B1", "BB1", 19, "AAABBCC11"),
                new Customer("B1", "BB1", 19, "AAABBCC11"),
                new Customer("B1", "BB1", 19, "AAABBCC11"),
                new Customer("B1", "BB1", 19, "AAABBCC11")
        };

        Customer[] customersWithGrantedAccess = new Customer[5];
        customersWithGrantedAccess[0] = new Customer("A1", "AA1", 19, "AAABBCC11");
        customersWithGrantedAccess[1] = new Customer("B1", "BB1", 19, "AAABBCC11");
        customersWithGrantedAccess[2] = new Customer("C1", "CC1", 19, "AAABBCC11");
        customersWithGrantedAccess[3] = new Customer("D1", "DD1", 19, "AAABBCC11");
        //System.out.println(customersWithGrantedAccess[4]);
        // customersWithGrantedAccess[4] = "Hello";

        // customersWithGrantedAccess[9] = new Customer("B1", "BB1", 19, "AAABBCC11");


        ArrayList<Customer> partyMonsterCustomerCollection = new ArrayList<>();

        System.out.println("Customer collection report: ");
        for(int i = 0; i < customersWithGrantedAccess.length; i++) {

            Customer currentCustomer = customersWithGrantedAccess[i];

            if(currentCustomer != null) {

                if(currentCustomer.numberOfVisits > 10 && currentCustomer.getAge() > 21) {
                    partyMonsterCustomerCollection.add(currentCustomer);
                }
            }
        }

//        int i = 0;
//        while(i < customersWithGrantedAccess.length) {
//            System.out.println("Iteration " + i);
//            if(customersWithGrantedAccess[i] != null) {
//
//                System.out.println(customersWithGrantedAccess[i].getFullName());
//            }
//
//            i++;
//        }
//
//        int i = 0;
//        while (i < 20) {
//
//            System.out.println("Iteration : " + i);
//            if(i == 10) {
//                // return;
//                break;
//            }
//
//            i++;
//        }
//
//        System.out.println("CODE AFTER LOOP");

        int i = 1;
        while(i < 1) {
            System.out.println("*** Run WHILE LOOP BODY");
        }

        do {
            System.out.println(" *** Run DO WHILE LOOP ");
        } while(i < 1);

    }

    void exampleArrayList() {

        ArrayList<String> collectionString = new ArrayList<String>();
        collectionString.add("A");
        collectionString.add("B");
        collectionString.add("C");
        collectionString.add("D");
    }
}
