import javax.swing.*;

public class ApplicationMain {

    public static void main(String[] args) {

        // Step 1.Frame Window
        JFrame windowFrame = new JFrame();
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(500, 500);

        // anonimus class
        //windowFrame.add(new JPanel() {
        // body
        //});

        windowFrame.add(new ApplicationWindow());
        windowFrame.setVisible(true);
    }
}