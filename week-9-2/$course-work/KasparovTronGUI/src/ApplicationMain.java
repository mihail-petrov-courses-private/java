import javax.swing.*;
import java.awt.*;

public class ApplicationMain {

    public static void main(String[] args) {

        // Step 1.Frame Window
        JFrame windowFrame = new JFrame();
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(500, 500);

        // external class
        windowFrame.add(new GameBoardPanel());
        windowFrame.setVisible(true);
    }
}