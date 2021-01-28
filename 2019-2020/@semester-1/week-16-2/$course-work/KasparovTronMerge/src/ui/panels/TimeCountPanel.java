package ui.panels;

import meta.PiecePosition;
import pieces.Piece;
import state.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TimeCountPanel extends JPanel {

    public TimeCountPanel() {

        JLabel timeCounterLabel = new JLabel("0");
        timeCounterLabel.setFont(new Font("Verdana", 1, 46));
        this.add(timeCounterLabel);

        (new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    System.out.println(Thread.currentThread());
                    int counter = 0;

                    while(true) {
                        timeCounterLabel.setText("" + counter);
                        Thread.sleep(1000);
                        counter++;
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })).start();


        //experimentalRunProcess.start();
    }
}
