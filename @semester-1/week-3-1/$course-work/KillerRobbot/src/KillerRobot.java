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

        System.out.print("getRandomNumber : with int ");
        return (int)(Math.random() * (max - min)) + min;
    }

    public static boolean isHitDeadlyForTheMouse() {

        //
        int randomIndex = getRandomNumber(1, 10);
        return (randomIndex != 5);

        // return (5 == getRandomNumber(1, 10));
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
        //Scanner scannerInstance = new Scanner(System.in);
        //int directionObject = scannerInstance.nextInt();
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

        System.out.print(getRandomNumber(10.0, 100.0));
    }
}