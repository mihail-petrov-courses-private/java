package com.epicepicnes.customer;

import com.epicepicnes.config.LegalConfig;

import java.util.ArrayList;

public class CustomerManager {

    static ArrayList<Customer> collection = new ArrayList<Customer>();

    public static void addCustomer(Customer newCustomer) {

        if(newCustomer.isIdValid()) {
            collection.add(newCustomer);
        }
    }

    public static Customer getCustomer(int index) {
        return collection.get(index);
    }

    public static ArrayList<Customer> getCustomerOlderThanCollection(int expectedAge) {

        ArrayList<Customer> reducedCustomerCollection = new ArrayList<>();
        for(int i = 0; i < collection.size(); i++) {

            Customer collectionReference = collection.get(i);

            if(collectionReference.getAge() > expectedAge) {
                reducedCustomerCollection.add(collectionReference);
            }
        }

        return reducedCustomerCollection;
    }


    public static ArrayList<Customer> getAllVipCustomer() {

        ArrayList<Customer> reduceCollection = new ArrayList<>();

        for(int i = 0; i < collection.size(); i++) {
            if(collection.get(i).numberOfVisits >= LegalConfig.MIN_VISITS_FOR_VIP_STATUS_PROMOTION) {
                reduceCollection.add(collection.get(i));
            }
        }

        return reduceCollection;
    }


    public static int getAllCustomerCount() {
        return collection.size();
    }

    public static void render(ArrayList<Customer> collection) {

        for(int i = 0 ; i < collection.size(); i++) {

            Customer customerReference = collection.get(i);

            System.out.println(customerReference.getFullName());
            System.out.println(customerReference.getAge());
            System.out.println("***");
        }
    }
}