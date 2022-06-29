package me.mihailpetrov.stagestopwatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApplication extends Application {

    private Timeline timeline;

    private int step = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours   = 0;

    private final Label timeFrame = new Label();
    Button startButton = new Button("Start");
    Button endButton = new Button("End");

    @Override
    public void start(Stage stage) throws Exception {

        timeFrame.setText("00:00:00.00");
        timeFrame.setTextFill(Color.RED);
        timeFrame.setFont(new Font(20));
        timeFrame.setLayoutX(180);
        timeFrame.setLayoutY(50);

        startButton.setLayoutX(150);
        startButton.setLayoutY(100);

        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                KeyFrame stopWatchAnimation = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        step += 100;
                        processTimeFrame();
                    }
                });

                timeline = new Timeline(stopWatchAnimation);
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
            }
        });

        endButton.setLayoutX(200);
        endButton.setLayoutY(100);

        endButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                timeline.stop();
            }
        });

        this.bootstrap(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void bootstrap(Stage stage) {

        // Създаване на мениджър на елеменети
        Group groupManager = new Group();
        groupManager.getChildren().addAll(timeFrame, startButton, endButton);

        // Създаване на нова сцена
        Scene mainScene = new Scene(groupManager);

        stage.setTitle("Stage Stopwatch");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(mainScene);
        stage.show();
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
