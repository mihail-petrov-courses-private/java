import java.util.Random;

public class RandomGenerator {

    static Random randomGenerator = new Random();

    public static int number(int upperBound) {
        return randomGenerator.nextInt(upperBound) + 1;
    }

    public static int number(int lowerBound, int upperBound) {
        return lowerBound + number(upperBound);
    }

    public static double number() {
        return randomGenerator.nextDouble();
    }

}
