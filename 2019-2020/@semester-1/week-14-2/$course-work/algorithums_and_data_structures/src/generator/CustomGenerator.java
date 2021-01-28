package generator;

public class CustomGenerator {

    private static int sequance = 0;

    public static int next() {
        return sequance++;
    }
}
