import javax.swing.*;
import java.awt.*;

public class ApplicationWindow extends JPanel {

    private final int SIDE = 50;

    public void paint(Graphics g) {

        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                render(g, row, col);
            }
        }
    }

    private void render(Graphics g, int row, int col) {

        boolean isRowEven = (row % 2 == 0);
        boolean isColEven = (col % 2 == 0);

        boolean isBlack     = (isRowEven && isColEven) ||
                              (!isRowEven && !isColEven);

        int x               =  col * SIDE;
        int y               =  row * SIDE;

//        if(isBlack) {
//            g.setColor(Color.BLACK);
//        }
//        else {
//            g.setColor(Color.WHITE);
//        }

        Color tileColor = isBlack ? Color.BLACK : Color.WHITE;
        g.setColor(tileColor);
        g.fillRect(x, y, SIDE, SIDE);
    }
}