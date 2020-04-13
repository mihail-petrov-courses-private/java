import javax.swing.*;
import java.awt.*;

public class ClassInstantiationModels {


    public static void main() {

        // Step 1.Frame Window
        JFrame windowFrame = new JFrame();
        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame.setSize(500, 500);

        // array with predefined values
        // String[] collection = new String[3];
        String[] collection = new String[]{
                "A", "B", "C"
        };

        // anonimus class
        // XXYYZZ
        JPanel panelAnonimusInstance = new JPanel() {

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

                Color tileColor = isBlack ? Color.BLACK : Color.WHITE;
                g.setColor(tileColor);
                g.fillRect(x, y, SIDE, SIDE);
            }
        };


        class InnerPanel extends JPanel {

            public void paint(Graphics g) {
                g.fillRect(10,10,100,100);
            }
        }

        GameBoardRule ruleReference = new GameBoardRule(){

            @Override
            public boolean isRuleAvailable() {
                return false;
            }
        };


        // external class
        // windowFrame.add(new GameBoardPanel());

        // anonimus class
        // windowFrame.add(panelAnonimusInstance);

        // local class
        windowFrame.add(new InnerPanel());

        // instantiaty inner class
        GameBoardStrategy.FreeStyle strategy = new GameBoardStrategy.FreeStyle();
    }
}
