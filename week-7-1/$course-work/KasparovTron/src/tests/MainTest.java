package tests;

public class MainTest {

    static void assertIsTrue(boolean isTrue) {

        String message = (isTrue) ? "Success" : "Fail";
        System.out.println(message);
    }

    static void assertIsFalse(boolean isFalse) {
//
//        String message = (!isFalse) ? "Success" : "Fail";
//        System.out.println(message);
        assertIsTrue(!isFalse);
    }
}
