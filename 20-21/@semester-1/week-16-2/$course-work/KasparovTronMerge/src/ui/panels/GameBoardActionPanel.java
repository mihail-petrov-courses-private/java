package ui.panels;

import state.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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

        undoAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Undu");
                System.out.print(Thread.currentThread());
            }
        });

        reduAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Redu");
                System.out.println(Thread.currentThread());
            }
        });

        restartAction.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                System.out.println("Reset");
                System.out.print(Thread.currentThread());
                GameBoard.getInstance().reset();
                try {
                    Thread.sleep(10000);
                }
                catch (Exception se) {
                    se.printStackTrace();
                }

            }
        });
    }
}
