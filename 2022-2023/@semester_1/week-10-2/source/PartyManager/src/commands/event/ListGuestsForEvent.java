package commands.event;

import managers.EventManager;
import types.Event;
import util.Terminal;

public class ListGuestsForEvent {

    public static void process() {

        EventManager.listAllEvents();
        int eventId = Terminal.inputInt("Изберете ID на събитието");
        Event selectedEvent = EventManager.getEventById(eventId);
        EventManager.setActiveEvent(selectedEvent);

        if(selectedEvent == null) {
            Terminal.output("ИЗбрали сте несъществуващо събитие");
            return;
        }

        Terminal.output("(1) Визуализирай всички гости");
        Terminal.output("(2) Визуализирай всички гости МЪЖЕ");
        Terminal.output("(3) Визуализирай всички гости ЖЕНИ");
        int selectOption = Terminal.inputInt();

        if(selectOption == 1) {
            selectedEvent.listRegisteredCustomers();
        }

        if(selectOption == 2) {
            selectedEvent.listRegisteredCustomers("M");
        }

        if(selectOption == 3) {
            selectedEvent.listRegisteredCustomers("F");
        }
    }
}
