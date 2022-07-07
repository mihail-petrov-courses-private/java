package me.mihailpetrov.stagestopwatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import me.mihailpetrov.stagestopwatch.models.TimestampSection;
import me.mihailpetrov.stagestopwatch.services.database.LocalDatabase;

import java.io.File;
import java.util.ArrayList;

public class StopwatchController {

    public VBox mainViewReference;

    public Label timeFrame;

    public Label timestampSection;

    private Timeline timeline;

    private int step = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours   = 0;

    // масив от селекции
    // private TimestampSection[] collection = new TimestampSection[10];
    private ArrayList<TimestampSection> collection = new ArrayList<>();
    private int index = 0;

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

    public void exportSubtitle() {

        Window mainWindow = this.mainViewReference.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save subtitle file");
        fileChooser.setInitialDirectory(new File("e:\\"));
        File savedFileReference = fileChooser.showSaveDialog(mainWindow);

        LocalDatabase.write(savedFileReference, this.getTimeSectionLabel());
    }

    public void registerSectionTimerStart() {

        String currentTimeFrame         = this.getCurrentTimeFrame();

        if(this.collection.size() == 0) {

            TimestampSection section = new TimestampSection(currentTimeFrame);
            section.setDescription("Comment");
            this.collection.add(section);
        }

        TimestampSection section    = this.getCurrentTimestampSection();

        if(section.isOpen()) {
            section.setStartTimestamp(currentTimeFrame);
        }

        if(section.isFinalized()) {

            TimestampSection newSection = new TimestampSection(currentTimeFrame);
            newSection.setDescription("Comment");
            this.collection.add(newSection);
        }

        this.renderTimeSectionLabel();
    }

    public void registerSectionTimerStop() {

        String currentTimeFrame  = this.getCurrentTimeFrame();
        TimestampSection section = this.getCurrentTimestampSection();
        section.setEndTimestamp(currentTimeFrame);

        this.renderTimeSectionLabel();
    }

    private TimestampSection getCurrentTimestampSection() {
        return this.collection.get(this.collection.size() - 1);
    }

    private String getTimeSectionLabel() {
        String resultTimeStampContext = "";
        for(TimestampSection element : this.collection) {
            resultTimeStampContext += element.render() + "\n";
        }

        return resultTimeStampContext;
    }

    private void renderTimeSectionLabel() {
        this.timestampSection.setText(this.getTimeSectionLabel());
    }

    private String getCurrentTimeFrame() {

        String secondsTemplate  = seconds >= 10 ? String.valueOf(seconds)   : ("0" + seconds);
        String minutesTemplate  = minutes >= 10 ? String.valueOf(minutes)   : ("0" + minutes);
        String hoursTemplate    = hours >= 10 ? String.valueOf(hours)       : ("0" + hours);

        return hoursTemplate + ":" + minutesTemplate + ":" + secondsTemplate + "." + step;
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

        timeFrame.setText(this.getCurrentTimeFrame());
    }
}
