package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoardActionPanel extends JPanel {

    public GameBoardActionPanel() {

        JButton undoAction = new JButton("Undo");
        this.add(undoAction);
        JButton reduAction = new JButton("Redu");
        this.add(reduAction);

        undoAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // Design patterns
                // ***
                // Observer Pattern in Java
                // Publish - Subscribe
            }
        });

        reduAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Redu");
            }
        });


        // undoAction.addActionListener();
    }

    /*
    public void paint(Graphics g) {
        g.fillRect(0,0,50,50);
        System.out.print("Repaint");
    }
     */

}
