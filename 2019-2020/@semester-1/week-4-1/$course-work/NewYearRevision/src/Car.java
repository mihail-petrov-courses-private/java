public class Car {

    String color = "white";
    int numberOfDoors;

    void setColor(String carColor) {
        color = carColor;
    }

    String getColor() {
        return "Main color is " + color;
    }

    void  printColor() {
        Util.print(getColor());
    }
}