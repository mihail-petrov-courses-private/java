package ui.panels;

import contracts.IUpdatePanelUi;
import state.TimeCount;

import javax.swing.*;
import java.awt.*;

public class ScoreCountPanel extends JPanel implements IUpdatePanelUi {

    public ScoreCountPanel() {

        JLabel scoreCounterLabel = new JLabel("0");
        scoreCounterLabel.setFont(new Font("Verdana", 1, 46));
        this.add(scoreCounterLabel);

    }

    public void updatePanelUi() {
        updateUI();
    }
}
