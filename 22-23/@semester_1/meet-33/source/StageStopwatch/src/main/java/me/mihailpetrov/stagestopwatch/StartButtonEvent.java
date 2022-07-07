package me.mihailpetrov.stagestopwatch;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

// логиката за обработка на събитие
// - в бутона START
public class StartButtonEvent implements EventHandler {

    private Label label;

    public StartButtonEvent(Label element) {
        this.label = element;
    }

    @Override
    public void handle(Event event) {
        System.out.println("You click the button");
        this.label.setText("01:00:00.00");
    }
}
