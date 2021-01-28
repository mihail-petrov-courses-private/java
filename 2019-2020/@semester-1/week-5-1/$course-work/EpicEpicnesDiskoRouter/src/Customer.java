public class Customer {

    static String permitionToStay = "A";

    String fname;

    String lname;

    int age;

    String idNumber;

    int numberOfVisits;

    Customer(String fname, String inputLname, int inputAge, String inputIdNumber) {

        // fname           = inputFname;
        this.fname           = fname;
        this.lname           = inputLname;
        // age             = inputAge;
        this.setAge(inputAge);
        this.idNumber        = inputIdNumber;
        this.numberOfVisits  = 1;
    }

    String getFullName() {
        return this.fname + " "+ this.lname;
    }

    void setAge(int inputAge) {

        if(inputAge > 16 && inputAge < 100 ) {
            this.age = inputAge;
        }
    }

    int getAge() {

        if(this.age == 0) {
            return -1;
        }

        return age;
    }
}
