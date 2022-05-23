package commands.customer;

import commands.event.ListGuestsForEvent;
import managers.EventManager;
import types.Event;
import util.Terminal;

public class RemoveCustomerFromEvent {

    public static void process() {
        // Стъпка 1
        ListGuestsForEvent.process();

        // Стъпка 2 - взимам потребител
        Event selectedEvent = EventManager.getActiveEvent();
        int customerId      = Terminal.inputInt("Въведете ID на потребителя");

        if(selectedEvent != null) {
            selectedEvent.remove(customerId);
            Terminal.output("Потребителя е премахнат от събитието");
        }
    }
}
