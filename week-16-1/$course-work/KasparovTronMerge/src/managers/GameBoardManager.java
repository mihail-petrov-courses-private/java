package managers;

import ui.containers.ApplicationContainer;

import javax.swing.*;

public class GameBoardManager {

    public static void init() {

        JFrame windowFrame = new JFrame();
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(900, 900);
        windowFrame.add(new ApplicationContainer());
        windowFrame.setVisible(true);
    }
}
