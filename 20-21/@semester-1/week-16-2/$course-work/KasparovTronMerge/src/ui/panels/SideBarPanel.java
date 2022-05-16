package ui.panels;

import meta.PiecePosition;
import pieces.Piece;
import state.GameBoard;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SideBarPanel extends JPanel {

    public SideBarPanel() {

        GameBoard game = GameBoard.getInstance();

        JButton restartAction = new JButton("Restart");
        this.add(restartAction);

        restartAction.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                //
            }
        });
    }
}
