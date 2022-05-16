package ui.containers;

import ui.panels.TimeCountPanel;

import javax.swing.*;

public class SideBarContainer extends JPanel {

    public SideBarContainer() {

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        TimeCountPanel timeCountPanel = new TimeCountPanel();
        this.add(timeCountPanel);
    }
}
