package events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoardMouseEventHandler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("MOUSE : pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("MOUSE : relessed");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
