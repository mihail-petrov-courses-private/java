package managers;

import ui.GameBoardPanel;

import javax.swing.*;

public class GameBoardManager {

    public static void init() {

        try {

            JFrame windowFrame = new JFrame();
            windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowFrame.setSize(500, 500);
            windowFrame.add(new GameBoardPanel());
            windowFrame.setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
