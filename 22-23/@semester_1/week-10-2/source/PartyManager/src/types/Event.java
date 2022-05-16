package types;

import managers.CustomerManager;
import util.Collection;
import util.SequenceGenerator;
import util.Terminal;

public class Event {
    private int id;
    private String title;
    private boolean isAdultOnly;

    private Customer[] registeredCustomerCollection = new Customer[10];
    private int registeredCustomerCollectionIndex = 0;

    public Event(String title, boolean isAdultOnly) {

        this.id          = SequenceGenerator.nextEventId();
        this.title       = title;
        this.isAdultOnly = isAdultOnly;
    }

    public Event(String title) {
        this.id          = SequenceGenerator.nextEventId();
        this.title       = title;
        this.isAdultOnly = false;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAdultOnly() {
        return this.isAdultOnly;
    }

    public void setAdultOnly(boolean adultOnly) {
        this.isAdultOnly = adultOnly;
    }

    public String getAgeId() {
        return this.isAdultOnly() ? "18+" : "0+";
    }

    public String render() {
        return this.getId() + ": " +  this.getTitle() + " : " + this.getAgeId();
    }

    public String toString() {
        return this.render();
    }

    public void registerCustomer(Customer customer) {
        this.registeredCustomerCollection[this.registeredCustomerCollectionIndex++] = customer;
    }

    public void listRegisteredCustomers() {

        for(Customer customer : this.registeredCustomerCollection) {
            if(customer != null) {
                Terminal.outputObject(customer);
            }
        }
    }

    public void listRegisteredCustomers(String gender) {

        for(Customer customer : this.registeredCustomerCollection) {

            boolean isProcessable = customer != null &&
                                    customer.getGender().equals(gender);

            if(isProcessable) {
                Terminal.outputObject(customer);
            }
        }
    }

    public void remove(int customerId) {

        int customerIndex =  CustomerManager.getCustomerIndexById(customerId);
        Collection.remove(this.registeredCustomerCollection, customerIndex);
        registeredCustomerCollectionIndex--;
    }
}