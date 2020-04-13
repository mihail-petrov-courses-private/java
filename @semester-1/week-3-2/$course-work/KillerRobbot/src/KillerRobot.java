import org.jetbrains.annotations.Contract;

import java.util.Scanner;

class KillerRobot {


    public static void getDirection(int directionObject) {

        // local variable
        // int directionObject = 10;

        // directionObject == 1 or directionObject == 2 or directionObject == 3
        boolean isNormalDirection =     (directionObject == 1) ||
                                        (directionObject == 2) ||
                                        (directionObject == 3);

        // (4 == 1) or (4 == 2) or (4 == 3) -> false
        // isNormalDirection == false

        if(isNormalDirection) {  // true || false for variable

            if(directionObject == 1) { // true || false
                System.out.println("Go sideway");
            }

            if(directionObject == 2) {
                System.out.println("Jump");
            }

            if(directionObject == 3) {
                System.out.println("Forward");
            }
        }

        // ctrl + /             => single line comment
        // ctrl + shift + /     => multy line coment

// standart else evaluation
//        else {
//            System.out.println("I have no idea what to do.");
//        }

// false evaluation
//        if(isNormalDirection == false) { // only in case of true expression
//            System.out.print("I have no idea what to do.");
//        }

        // TRUE  -->  FALSE
        // FALSE --> TRUE
        // NOT TRUE == FALSE
        // NOT FALSE == TRUE
        // OR    ==> ||
        // AND   ==> &&
        // NOT   ==> !

        if(!isNormalDirection) { // idNormalDirection == false
            System.out.print("I have no idea what to do.");
        }
    }

    public static String getNewDirection(int direction) {

        if(direction == 1) {
            return "Go sideway";
        }

        if(direction == 2) {
            return "Jump";
        }

        if(direction == 3) {
            return "Forward";
        }

        return "I have no idea";
    }


    // no input
    public static void print() {
       System.out.println("Welcome Killer Robot");
    }

    // assigne to variable
    // use in expression
    public static int getSerialNumber(int seria) {

        int serialReference = 1;
        print();

        if(seria > 5) {
            serialReference = 100;
            return   serialReference;
        }

        if(seria == 5) {
            serialReference = 5;
            return serialReference;
        }

        return serialReference;
    }

    // Bad code
//    public static boolean isTargetDetected(int numberOfPixel) {
//
//        if(numberOfPixel % 2 == 0) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

    // Bad code
//    public static boolean isTargetDetected(int numberOfPixel) {
//
//        if(numberOfPixel % 2 == 0) {
//            return true;
//        }
//
//        return false;
//    }

    // Good code
    public static boolean isTargetDetected(int numberOfPixel) {
        return (numberOfPixel % 2 == 0);
    }

    public static boolean isBatteryOn(int numberOfAvailableHit) {
        return (numberOfAvailableHit > 0);
    }

    // method signature
    public static double getRandomNumber(double min, double max) {

        System.out.print("getRandomNumber : with double ");
        return (Math.random() * (max - min)) + min;
    }

    // method overloading
//    public static int getRandomInt(int min, int max) {
//        return (int)(Math.random() * (max - min)) + min;
//    }
    public static int getRandomNumber(int min, int max) {

        // System.out.print("getRandomNumber : with int ");
        return (int)(Math.random() * (max - min)) + min;
    }

    public static boolean isHitDeadlyForTheMouse() {

        //
        int randomIndex = getRandomNumber(1, 10);
        return (randomIndex != 5);

        // return (5 == getRandomNumber(1, 10));
    }

    public static boolean isHitSuccessfull(int numberOfPixel, int numberOfAvailableHit) {

        // check if all of the states are true
//        boolean isTargetDetected        = isTargetDetected(numberOfPixel);
//        boolean isBatteryOn             = isBatteryOn(numberOfAvailableHit);
//        boolean isHitDeadlyForTheMouse  = isHitDeadlyForTheMouse();
//
//        return isTargetDetected &&
//                isBatteryOn     &&
//                isHitDeadlyForTheMouse;

        return isTargetDetected(numberOfPixel)          &&
                isBatteryOn(numberOfAvailableHit)       &&
                isHitDeadlyForTheMouse();
    }

    // 1 1 2 3 5 8 13


    public static void swapVariables(int variableA, int variableB) {

        // int variableA = 10;
        // int variableB = 5;


        // get values from external variables
        int a = variableA;
        int b = variableB;
        int temp;
        // swap values of internal variables
        temp = a;
        a = b;
        b = temp;
        variableA = a;
        variableB = b;
    }

    public static void printLocalVariable(int extrenalLocalVariable) {

        // local variable printLocalVariable method
        int localVariable = extrenalLocalVariable;
        System.out.println(localVariable);
    }

    public static boolean isChargable() {

        int chargeIndexA = getRandomNumber(1, 1000);
        int chargeIndexB = getRandomNumber(1, 1000);

        return (chargeIndexA >= chargeIndexB);
    }

    // recursion
    public static void recursiveCall(int count) { // 8

        System.out.println("Recursive call " + count); // 8
        count--; // 7
        if(count > 0) {
            recursiveCall(count); // 7
        }
    }

    public static void mouseTerminator(int numberOfAvailableHit) {

        System.out.println("Enter number of pixels : ");
        Scanner scannerReference = new Scanner(System.in);
        int numberOfPixels = scannerReference.nextInt();

        boolean isSuccesfull = isHitSuccessfull(numberOfPixels, numberOfAvailableHit);

        if(isSuccesfull) {

            System.out.println("!!! Yes we did it !!! ");
            numberOfAvailableHit -= 1;
            System.out.println("Available hit left : " + numberOfAvailableHit);

            mouseTerminator(numberOfAvailableHit);
        } else {
            // System.out.println("Try next time");

            // call method in if statment
            // boolean isChargeAvailable = isChargable();
            if(isChargable()) {
                numberOfAvailableHit = 4;
                mouseTerminator(numberOfAvailableHit);
            }
            else {
                System.out.println("No charge left everrrrr");
            }
        }
        //
    }

    // Gues the number
    // 1 1 2 3 5 8 13 21
    public static void guesTheNumber(int n) {

        // if n >  --> Go down
        // guesTheNumber()

        // if n <  --> Go up
        // geusTheNUmber()

        // if n == -> Bravo
    }


    // only one
    public static void main(String[] args) {

        final int MAX_NUMBER_OF_HITS = 4;
        int numberOfAvailableHit = MAX_NUMBER_OF_HITS;


        // main method
        // wall  - 1
        // chair - 2
        // free  - 3
        //print();
        // Scanner scannerInstance = new Scanner(System.in);
        // int directionObject = scannerInstance.nextInt();
        //System.out.print(getNewDirection(directionObject));

        // getDirection(directionObject);
        // getDirection(directionObject);
        //String serialNumber =  ("ABC" + getSerialNumber(3));
        //System.out.println(serialNumber);

        // min -> 0
        // max -> 1000
        // range => ((0 to 1) * (1000 - 0)) + 0
        // 0 - 1
        // double randomNumber = Math.random();
        // double randomNumber = getRandomInt(0, 100);
        // int randomNumber = getRandomInt(0, 100);
        // System.out.print(randomNumber);

        // System.out.print(getRandomNumber(10.0, 100.0));

        // variable swap with temp variable
//        int variableIntA = 5;
//        int variableIntB = 10;
//        int variableTemp;
//
//        variableTemp = variableIntA; // 5
//        variableIntA = variableIntB; // 10
//        variableIntB = variableTemp; // 5


        // variable swap withot third variable
//        int variableA = 5;
//        int variableB = 10;

        // A --> 5
        // B --> 10
        // A = A + B --> 15
        // B --> 10
        // B = A - B --> 15 - 10 == 5

        // A == 15
        // B == 5
        // A = A - B  => 15 - 5 ==> 10


//        int systemA = 10;
//        int systemB = 5;
//        System.out.println("Variables before the SWAP");
//        System.out.println(systemA); // 10
//        System.out.println(systemB); // 5
//        swapVariables(systemA, systemB);
//        System.out.println("Variables after the SWAP");
//        System.out.println(systemA);
//        System.out.println(systemB);

        // local variable main method
//        int localVariable = 5000;
//        printLocalVariable(localVariable); // 5000
//        System.out.println(localVariable); // 5000

//        System.out.println("Enter number of px : ");
//        int numberOfDetectedPixels = scannerInstance.nextInt();
//        boolean isHitSuccessfull = isHitSuccessfull(numberOfDetectedPixels, numberOfAvailableHit);
//
//        if(isHitSuccessfull) {
//            System.out.println("Yes one down");
//
//            // regular
//            // numberOfAvailableHit = numberOfAvailableHit - 1;
//
//            // shorthand
//            numberOfAvailableHit -= 1;
//
//            // decrement operator  only 1
//            // numberOfAvailableHit--;
//            // --numberOfAvailableHit;
//        }
//        else {
//            System.out.println("** System not responding *** ");
//        }
//
//        // System.out.println("Rest of available hits : " + numberOfAvailableHit);

        // recursiveCall(10);

        mouseTerminator(numberOfAvailableHit);


    }
}