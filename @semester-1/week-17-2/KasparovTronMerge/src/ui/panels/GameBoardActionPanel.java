package ui.panels;

import state.GameBoard;
import state.PanelReference;
import state.TimeCount;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoardActionPanel extends JPanel {

    public GameBoardActionPanel() {

        GameBoard game = GameBoard.getInstance();
        JButton undoAction = new JButton("Undo");
        this.add(undoAction);
        JButton reduAction = new JButton("Redu");
        this.add(reduAction);
        JButton restartAction = new JButton("Restart");
        this.add(restartAction);

        JButton timePauseAction = new JButton("Pause Timer");
        this.add(timePauseAction);

        JButton timeResumeAction = new JButton("Resume Timer");
        this.add(timeResumeAction);

        undoAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        reduAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        restartAction.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                GameBoard.getInstance().reset();
                TimeCount.getInstance().reset();

                // *
                // PanelReference.getGameBoardPanel().updatePanelUi();
                // PanelReference.getTimeCountPanel().updatePanelUi();
                PanelReference.updatePanelUi();

                // Reminder
                // ((GameBoardPanel)PanelReference.getGameBoardPanel()).testGameBoardPanelMethod();

                // Update UI of GameBoardPanel
                // * reference GameBoardPanel -> updateUi
                // * infinit loop : GameBoardPanel
                // * send message from reset method
            }
        });

        timePauseAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                TimeCount.getInstance().pause();
            }
        });

        timeResumeAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                TimeCount.getInstance().resume();
            }
        });

    }
}
