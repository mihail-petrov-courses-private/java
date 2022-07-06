package me.mihailpetrov.stagestopwatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class StopwatchController {

    public Label timeFrame;

    private Timeline timeline;

    private int step = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours   = 0;

    public void startTimer() {

        KeyFrame stopWatchAnimation = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                step += 100;
                processTimeFrame();
            }
        });

        this.timeline = new Timeline(stopWatchAnimation);
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.play();
    }

    public void stopTimer() {
        this.timeline.stop();
    }

    private void processTimeFrame() {

        final int NEXT_TICK             = 1000;
        final int NEXT_PROCESS          = 60;
        final int INITIAL_TIMER_VALUE   = 0;

        if(step == NEXT_TICK) {
            seconds++;
            step = INITIAL_TIMER_VALUE;
        }

        if(seconds == NEXT_PROCESS) {
            minutes++;
            seconds = INITIAL_TIMER_VALUE;
        }

        if(minutes == NEXT_PROCESS) {
            hours++;
            minutes = INITIAL_TIMER_VALUE;
        }

        String secondsTemplate  = seconds >= 10 ? String.valueOf(seconds)   : ("0" + seconds);
        String minutesTemplate  = minutes >= 10 ? String.valueOf(minutes)   : ("0" + minutes);
        String hoursTemplate    = hours >= 10 ? String.valueOf(hours)       : ("0" + hours);
        String resultTemplate   = hoursTemplate + ":" + minutesTemplate + ":" + secondsTemplate + "." + step;
        timeFrame.setText(resultTemplate);
    }

}
