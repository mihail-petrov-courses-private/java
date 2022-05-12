package commands.event;

import managers.EventManager;
import util.Terminal;

public class RemoveEvent {

    public static void process() {

        int eventId = Terminal.inputInt("Въведете ID на събитието");
        EventManager.removeEventById(eventId);
    }
}
