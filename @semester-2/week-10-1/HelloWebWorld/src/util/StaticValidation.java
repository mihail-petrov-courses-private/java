package util;

public class StaticValidation {

    public static boolean isEqualTo(String input, String source) {
        return input.equals(source);
    }

    public static boolean isStringSizeGreaterThan(String input, int size) {
        return input.length() > size;
    }

    public static boolean isStringSizeLowerThan(String input, int size) {
        return input.length() < size;
    }

    public static boolean isStringSizeEqualTo(String input, int size) {
        return input.length() == size;
    }
}
