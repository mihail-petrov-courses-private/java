package ui.panels;

import contracts.IUpdatePanelUi;
import state.TimeCount;

import javax.swing.*;
import java.awt.*;

public class TimeCountPanel extends JPanel implements IUpdatePanelUi {

    public TimeCountPanel() {

        JLabel timeCounterLabel = new JLabel("0");
        timeCounterLabel.setFont(new Font("Verdana", 1, 46));
        this.add(timeCounterLabel);

        (new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    while(true) {

                        System.out.println(TimeCount.getInstance().isPaused());

                        if(TimeCount.getInstance().isPaused()) {
                            //Thread.sleep(1000);
                            continue;
                        }


                        timeCounterLabel.setText("" + TimeCount.getInstance().getCounter());
                        Thread.sleep(1000);
                        // counter++;
                        TimeCount.getInstance().update();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })).start();


        //experimentalRunProcess.start();
    }

    public void updatePanelUi() {
        updateUI();
    }
}
