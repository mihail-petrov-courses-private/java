public class NewYearRevision {

    static int numberOfVendors = 5;

    static void addNewVendor() {

        // int numberOfVendors = 156;
        // System.out.println("1$ Number of current vendors " + numberOfVendors);
        // System.out.println("2$ Number of current vendors " + NewYearRevision.numberOfVendors);

        // add single digit by using the variable
        numberOfVendors = numberOfVendors + 1;

        //-= | *= | /=
        // numberOfVendors += 1;

        // increment operator
        numberOfVendors++;
    }

    static void addNumberOfVendors(int count) {
        numberOfVendors += count;
    }


    static boolean isContentAccessable(String browser, int userAge) {

        // 1. declare expression
        // 2. return variable result
//        boolean isValid = (browser == Config.activeBrowserUsedForBrowsing) &&
//                (userAge >= Config.ageRestrictin);
//
//        return isValid;


        return (browser == Config.activeBrowserUsedForBrowsing) &&
                (userAge >= Config.ageRestrictin);
    }


    static void printNumberOfVendors() {
        Util.print("===================");
        Util.printNumber(numberOfVendors);
    }

    public static void main(String[] args) {

        String activeBrowser = "IE";
        int userAge = 26;

        // variable declaration
        int numberOfEmployees = 100;
        final int numberOfManagers = 1;
        numberOfEmployees = 150;

        // String companyName = "New Year Revision";
        String name = "New Year Revision";

        // I can not use numberOfVendors variable
        // -> variable is outside the main method
        // System.out.println("Number of vendors " + numberOfVendors);

        // addNewVendor();

        System.out.println("Vendor name " + Vendor.name);
        Vendor.name = "Lafka Newspaper OOD";
        System.out.println("Vendor name " + Vendor.name);

        System.out.println("Employ name " + Employ.name);

        System.out.println(Vendor.managerName);
        // Vendor.managerName = "Mihail";

//        boolean isContentAccessable = (activeBrowser == Config.activeBrowserUsedForBrowsing) &&
//                                      (userAge >= Config.ageRestrictin);

        boolean isContentAccessable = isContentAccessable(activeBrowser, userAge);


        // Conditional statements
        if(isContentAccessable) {
            System.out.println("~~~This is home page of NewYearRevision~~~~");
        }
        else {
            System.out.println("!!!SORRY!!!");
        }

        // static variable from the same class
        System.out.println(numberOfVendors);


        System.out.println("*** Static method demonstartion *** ");
        int numberOfVendors = 50;


        printNumberOfVendors();
        addNewVendor();
        printNumberOfVendors();


        Util.separate("Car section");
        Car tesla = new Car();
        tesla.color = "red";
        tesla.numberOfDoors = 2;

        Car bmv = new Car();
        bmv.color = "black";
        bmv.numberOfDoors = 4;

        Car trabant = new Car();

        Util.print("Tesla   " + tesla.getColor());
        Util.print("BMV     " + bmv.getColor());
        Util.print("Trabant " + trabant.getColor());
    }
}

// wHEN jvm execute the class
// NewYearRevision.main()