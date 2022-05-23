package commands.event;

import managers.EventManager;
import types.Event;
import util.Terminal;

public class UpdateEvent {

    public static void process() {

        int eventId            = Terminal.inputInt("Въведете ID то на събитието, което ще актуализирате");
        Event processableEvent = EventManager.getEventById(eventId);

        if(processableEvent == null) {

            Terminal.output("Няма намерено събитие за това ID");
            return;
        }

        String eventTitle               = Terminal.inputString("Име на събитие (" + processableEvent.getTitle() + "): ");
        String adultOnlyQuestionAnswer  = Terminal.inputString("Събието само за възрастни ли е (" + processableEvent.getTitle() + "):" + "  Y/N");
        boolean isAdultOnly             = adultOnlyQuestionAnswer.equals("Y");

        EventManager.updateEvent(processableEvent, eventTitle, isAdultOnly);
    }
}
