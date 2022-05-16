package ui.containers;

import state.PanelReference;
import ui.panels.GameBoardActionPanel;
import ui.panels.GameBoardPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanelContainer extends JPanel {

    public GamePanelContainer() {

        // side panels
        try {

            // set layout
            BoxLayout gamePanelLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
            setLayout(gamePanelLayout);

            // add child panel
            GameBoardPanel gameBoardPanel               = new GameBoardPanel();
            GameBoardActionPanel gameBoardActionPanel   = new GameBoardActionPanel();

            // * get regerence
            PanelReference.setGameBoardPanel(gameBoardPanel);
            PanelReference.push(gameBoardPanel);


            this.add(gameBoardPanel);
            this.add(gameBoardActionPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
