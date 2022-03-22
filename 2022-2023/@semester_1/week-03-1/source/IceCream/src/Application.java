import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // Задача 1
        int maxNumberOfIceCreamForADay = 250;

        // Задача 2
        double iceCremePrice = 2.5;

        // Задача 3
        String productTitle = "EXTREME ICE CREAM";

        // Задача 4
        boolean isProductionOn = true;

        // Задача 5
        String productLetter = "C";
        char productLetterChar = 'C';
        int productNumber = 1547;
        String productSignatureNumber = productLetterChar + productNumber + "";
        System.out.println(productSignatureNumber);
        String productSignatureString = productLetterChar + "" + productNumber;
        System.out.println(productSignatureString);

        // Задача 6
        String redFlavorId      = "RED";
        String greenFlavorId    = "GREEN";
        String blueFlavorId     = "BLUE";
        String YellowFlavorId   = "YELLOW";

        // Задача 7
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Как се казваш ? ");
        String userName      = inputScanner.nextLine();
        System.out.println("Здравей "
                + userName
                + " ти спечели "
                + maxNumberOfIceCreamForADay
                + " бройки от "
                + redFlavorId + " " + productTitle);
    }
}
