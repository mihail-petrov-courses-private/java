import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameBoardPanel extends JPanel {

    private final int SIDE = 50;
    private int clickedRow;
    private int clickedCol;
    private boolean isTileSelected  = false;
    private boolean isTileMoved     = false;

    public GameBoardPanel() {

        // mouse listener with extrenal class
        // addMouseListener(new GameBoardMouseEventHandler());

        // mouse listener with anonimus class
        // better approach
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int tileX = e.getX();
                int tileY = e.getY();

                clickedRow = (tileY / 50); // 35 / 50
                clickedCol = (tileX / 50); //

                if(isTileSelected) { // move method
                    isTileMoved     = true;
                    isTileSelected  = false;
                }
                else {
                    isTileSelected  = true;
                    isTileMoved     = false;
                }

                //

                // Problem : rerender UI from wrapper class
                // Answer can access all properties
                // gameBoardProxy();
                updateUI();
            }
        });
    }

    private void gameBoardProxy() {

        System.out.println("Call from mouse listener");
        System.out.println(clickedRow);
        System.out.println(clickedCol);
    }


    public void paint(Graphics g) {

        // init game
        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                render(g, row, col);
            }
        }

        // render
    }

    private void render(Graphics g, int row, int col) {

        boolean isRowEven = (row % 2 == 0);
        boolean isColEven = (col % 2 == 0);

        boolean isBlack     = (isRowEven && isColEven) ||
                              (!isRowEven && !isColEven);

        int x               =  col * SIDE;
        int y               =  row * SIDE;

        boolean isTileClicked = (row == clickedRow && col == clickedCol);

        if(isTileClicked && isTileSelected) {

            g.setColor(Color.RED);
            g.fillRect(x, y, SIDE, SIDE);
            return;
        }

        if(isTileClicked && isTileMoved) {

            g.setColor(Color.BLUE);
            g.fillRect(x, y, SIDE, SIDE);
            return;
        }

        Color tileColor = isBlack ? Color.BLACK : Color.WHITE;
        g.setColor(tileColor);
        g.fillRect(x, y, SIDE, SIDE);
    }
}