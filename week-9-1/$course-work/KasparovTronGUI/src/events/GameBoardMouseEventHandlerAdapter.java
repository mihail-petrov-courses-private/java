package events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoardMouseEventHandlerAdapter extends MouseAdapter {

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
    }
}
