package types;

import util.SequenceGenerator;

public class Customer {

    private int id;

    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    public Customer(String firstName, String lastName, String gender, int age) {

        this.id = SequenceGenerator.nextCustomerId();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setAge(age);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.getId() + " " + this.getFullName()
                + " [" + this.getAge() + "]"
                + " [" + this.getGender() + "]";
    }
}
