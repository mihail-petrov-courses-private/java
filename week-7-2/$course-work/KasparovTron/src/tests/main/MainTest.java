package tests.main;

public class MainTest {

    public static void assertIsTrue(boolean isTrue) {

        String message = (isTrue) ? "Success" : "Fail";
        System.out.println(message);
    }

    public static void assertIsFalse(boolean isFalse) {
//
//        String message = (!isFalse) ? "Success" : "Fail";
//        System.out.println(message);
        assertIsTrue(!isFalse);
    }
}
