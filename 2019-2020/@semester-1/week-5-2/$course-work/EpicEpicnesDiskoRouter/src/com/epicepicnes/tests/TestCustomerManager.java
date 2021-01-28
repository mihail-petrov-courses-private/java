package com.epicepicnes.tests;

import com.epicepicnes.customer.*;

import java.util.ArrayList;
//import com.epicepicnes.customer.CustomerManager;

public class TestCustomerManager {

    static void testIfCollectionIsFullWhenUsersDoesnothaveAgeGreatherThan20() {

        System.out.print("testIfCollectionIsFullWhenUsersDoesnothaveAgeGreatherThan20 - ");

        // Arnage - Act - Assert
        CustomerManager.addCustomer(new Customer("Mihail", "Petrov",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer("Ivan", "Petrov",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer("Nencho", "Ilchev",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer(">Борис", "Цанев",
                28, "AABBDJDH"));

        // Act
        ArrayList<Customer> collection = CustomerManager.getCustomerOlderThanCollection(20);

        // Assert
        boolean isValid         = (collection.size() == 4);
        String assertMessage    = (isValid) ? "_VALID_" : "*FAIL*";

        System.out.println(assertMessage);
    }

    static void testIfTheRusltCollectionIsEmptyWhenNoUserMetTheProperAgeRestriction() {

        System.out.print("testIfCollectionIsFullWhenUsersDoesnothaveAgeGreatherThan20 - ");

        // Arnage - Act - Assert
        CustomerManager.addCustomer(new Customer("Mihail", "Petrov",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer("Ivan", "Petrov",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer("Nencho", "Ilchev",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer(">Борис", "Цанев",
                28, "AABBDJDH"));

        // Act
        ArrayList<Customer> collection = CustomerManager.getCustomerOlderThanCollection(30);

        // Assert
        boolean isValid         = (collection.size() == 0);
        String assertMessage    = (isValid) ? "_VALID_" : "*FAIL*";

        System.out.println(assertMessage);
    }



    public static void testIfCollectionHasVipCustomer() {

        System.out.print("testIfCollectionHasVipCustomer - ");

        // Arnage - Act - Assert
        CustomerManager.addCustomer(new Customer("Mihail", "Petrov",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer("Ivan", "Petrov",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer("Nencho", "Ilchev",
                28, "AABBDJDH"));

        CustomerManager.addCustomer(new Customer(">Борис", "Цанев",
                28, "AABBDJDH"));

        // Act
        ArrayList<Customer> collection = CustomerManager.getAllVipCustomer();

        // Assert
        boolean isValid         = (collection.size() == 1);
        String assertMessage    = (isValid) ? "_VALID_" : "*FAIL*";

        System.out.println(assertMessage);
    }


    public static void run() {

        testIfCollectionIsFullWhenUsersDoesnothaveAgeGreatherThan20();
        testIfTheRusltCollectionIsEmptyWhenNoUserMetTheProperAgeRestriction();
        testIfCollectionHasVipCustomer();
    }
}
