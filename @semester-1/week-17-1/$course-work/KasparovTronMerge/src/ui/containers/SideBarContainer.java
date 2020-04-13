package ui.containers;

import state.PanelReference;
import ui.panels.ScoreCountPanel;
import ui.panels.TimeCountPanel;

import javax.swing.*;

public class SideBarContainer extends JPanel {

    public SideBarContainer() {

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        TimeCountPanel timeCountPanel = new TimeCountPanel();
        ScoreCountPanel scoreCountPanel = new ScoreCountPanel();

        // PanelReference.setTimeCountPanel(timeCountPanel);
        PanelReference.push(timeCountPanel);
        PanelReference.push(scoreCountPanel);

        this.add(timeCountPanel);
        this.add(scoreCountPanel);
    }
}
