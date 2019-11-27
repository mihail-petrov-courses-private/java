class IceCreameManager {

    // main method - entry point in my application
    public static void main(String[] args) {
        System.out.println("ICE CREAME - FACTORY");

        // VARIABLE TYPE
        // 11 / 125 / 55 / 100 -> Numbers
        // "Hello world" / "UCE CREAME - FACTORY"

        // int - integer
        // int alabala
        // int sampleIntegereVariable
        // int lecture2Variable
        int sampleIntVariable;

        // not appropriate
        // int a - single character
        // int testmest - not applicatble I dont know what is this
        // int sampleIntVariable

        // appropriate
        int numberOfIceCreameSamples;
        int ageOfResident;
        int initialCountOfObjects;
        int countNumberMultyplyBy2;
        // cannot use number as a starting identificatror character
        //int 2initialNumber;

        int $numberVariableWithSpecialSimbol;
        int numberVariableWithSpecialSimbol$;
        int numberVariable$WithSpecialSimbol;

        // can not declare variable with @
        // int @$numberVariableWithSpecialSimbol;
        // int $numberVariableWithSpecialSimbol@;
        // int $numberVariable*WithSpecialSimbol;

        int numberOfIceCreameForADay = 10;
        System.out.println(numberOfIceCreameForADay);

        numberOfIceCreameForADay = 100;
        System.out.println(numberOfIceCreameForADay);


        //int numberOfDefectedIceCreameSamples = 0;
        int numberOfDefectedIceCreameSamples;
        numberOfDefectedIceCreameSamples = 0;
        System.out.println(numberOfDefectedIceCreameSamples);

        // incompatible type variables
        // int numberWithIncorectValue = "Hello world";

        // int fractureNumericValue = 10.5;
        double fractureVariable = 10.5555555515457445;


        double fractureWithIntigerNumber = 10;
        System.out.println(fractureWithIntigerNumber);

        double iceCreamePrice = 1.99;
        System.out.print("ICE CREAME price:");
        System.out.print(iceCreamePrice);

        String iceCreameTitle = "EXTREAME ICE CREAME";
        System.out.print(iceCreameTitle);

        // int
        // double
        // String
        boolean isActive = true; // false
        boolean isOn = false;
        boolean hasNewSkill = false;
        boolean isTransactionReady = false;

        // skill
        // transactionReady
        // on

        // not valid expressions
        // boolean isStringTrue = True;

        System.out.println();
        System.out.println(isActive);

        // int
        // double
        // String
        // boolean

        // string literal with double q : ''
        String iceCreameId = "E";

        // chaacter literal with single q : ''
        char iceCreameSingleId = 'E';

        // Type casting
        // incopmatible type casting
        // String charLiteralContainer = (String)'E';

        // explicit type casting
        int doubleContainerWithIntType = (int)10.5;

        // implicit type casting
        // double intContainerWithDoubleType = (double)10; - not nesesary (double)
        double intContainerWithDoubleType = (double)10;

        System.out.println();
        System.out.println("Type casting:");
        System.out.println(doubleContainerWithIntType);

        // int
        // double
        // boolean
        // String
        // char
        String redColor = "red";
        String blueColor = "blue";
        String greenColor = "green";
        String orangeColor = "orange";

        // array
        String[] colorCollection = {
                "red", "green", "blue", "orange", "lila", "yellow", "pink"
        };

        colorCollection[0] = "red";
        colorCollection[1] = "green";
        // ...
        colorCollection[6] = "pink";

        // get the first element of the array
        System.out.println();
        System.out.println(colorCollection[0]);

        // try to reach non initialise element
        //System.out.println();
        //System.out.println(colorCollection[5]);

        // number of elements in array / collection
        System.out.println();
        System.out.println(colorCollection.length);

        // assignment with aritmetic operation
        int lastIndexInCollorCollection = colorCollection.length - 1;
        System.out.println();
        System.out.println(lastIndexInCollorCollection);


        // get last element from collorCollection
        System.out.println();
        System.out.println(colorCollection[lastIndexInCollorCollection]);

        // change the value of array variable using index
        colorCollection[6] = "IPhone pink";
        System.out.println();
        System.out.println(colorCollection[6]);

        int initialNumberVariable = 10;
        int variableIdentificator = initialNumberVariable;

        ///
        String[] newColorCollection = {
                "red", // index - 0
                "green", // index - 1,
                "blue" // index - 2
        };

        // all elements in collection count
        int collectionCount = newColorCollection.length;
        int lastIndex = collectionCount - 1;
        System.out.println(newColorCollection[lastIndex]);
    }
}

// week-1-2