package managers;

import ui.containers.ApplicationContainer;

import javax.swing.*;

public class GameBoardManager {

    public static void init() {

        try {

            JFrame windowFrame = new JFrame();
            windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            windowFrame.setSize(900, 900);

            // ApplicationPanel applicationPanel   = new ApplicationPanel();
//            BoxLayout applicationBoxLayout      = new BoxLayout(applicationPanel, BoxLayout.X_AXIS);
//            applicationPanel.setLayout(applicationBoxLayout);
//
//            // main container
//            GamePanel gamePanel         = new GamePanel();
//            SideBarPanel sidebarPanel   = new SideBarPanel();
//
//            applicationPanel.add(gamePanel);
//            applicationPanel.add(sidebarPanel);

            // layout
            // BoxLayout gamePanelLayout = new BoxLayout(gamePanel, BoxLayout.Y_AXIS);
            // gamePanel.setLayout(gamePanelLayout);

            // side panels
            // GameBoardPanel gameBoardPanel               = new GameBoardPanel();
            // GameBoardActionPanel gameBoardActionPanel   = new GameBoardActionPanel();

            // add to main container
            // gamePanel.add(gameBoardPanel);
            // gamePanel.add(gameBoardActionPanel);

            // windowFrame.add(new GameBoardActionPanel());
            // windowFrame.add(new GameBoardPanel());
            // windowFrame.add(gamePanel);
            // windowFrame.add(applicationPanel);
            windowFrame.add(new ApplicationContainer());

            windowFrame.setVisible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
