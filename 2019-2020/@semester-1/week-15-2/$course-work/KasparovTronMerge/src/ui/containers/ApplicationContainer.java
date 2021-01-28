package ui.containers;

import ui.panels.SideBarPanel;

import javax.swing.*;

public class ApplicationContainer extends JPanel {

    public ApplicationContainer() {

        BoxLayout applicationBoxLayout      = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(applicationBoxLayout);

        // main container
        GamePanelContainer gamePanel         = new GamePanelContainer();
        SideBarPanel sidebarPanel   = new SideBarPanel();

        this.add(gamePanel);
        this.add(sidebarPanel);
    }
}
