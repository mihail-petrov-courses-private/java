package ui.containers;

import ui.panels.TimeCountPanel;

import javax.swing.*;

public class ApplicationContainer extends JPanel {

    public ApplicationContainer() {

        BoxLayout applicationBoxLayout      = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(applicationBoxLayout);

        // main container
        GamePanelContainer gamePanel         = new GamePanelContainer();
        SideBarContainer sidebarContainer    = new SideBarContainer();

        this.add(gamePanel);
        this.add(sidebarContainer);
    }
}
