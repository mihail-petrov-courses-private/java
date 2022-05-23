package commands.event;

import managers.EventManager;

public class ListEvent {

    public static void process() {
        EventManager.listAllEvents();
    }
}
