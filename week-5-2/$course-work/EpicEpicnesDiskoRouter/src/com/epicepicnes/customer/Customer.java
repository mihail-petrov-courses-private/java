package com.epicepicnes.customer;

import com.epicepicnes.config.LegalConfig;

public class Customer {

    static String permitionToStay = "A";

    public String fname;

    public String lname;

    public int age;

    public String idNumber;

    public int numberOfVisits;

    public Customer(String fname, String inputLname, int inputAge, String inputIdNumber) {

        // fname           = inputFname;
        this.fname           = fname;
        this.lname           = inputLname;
        // age             = inputAge;
        this.setAge(inputAge);
        this.idNumber        = inputIdNumber;
        this.numberOfVisits  = LegalConfig.NUMBER_OF_INITIAL_VISITATION;
    }

    public String getFullName() {
        return this.fname + " "+ this.lname;
    }

    public void setAge(int inputAge) {

        boolean isAgeValid = inputAge >= LegalConfig.MIN_REQUIED_AGE_TO_BECOME_A_CUSTOMER &&
                             inputAge < LegalConfig.MAX_REQUIED_AGE_TO_BECOME_A_CUSTOMER;

        if(isAgeValid) {
            this.age = inputAge;
        }
    }

    public int getAge() {

        if(this.age == 0) {
            return -1;
        }

        return age;
    }


    public boolean isIdValid() {
        return (this.idNumber.length() == LegalConfig.REQUIRED_ID_NUMBER_LENGTH);
    }

    public boolean isLegal() {
        return this.age >= LegalConfig.LEGAL_AGE;
    }
}
