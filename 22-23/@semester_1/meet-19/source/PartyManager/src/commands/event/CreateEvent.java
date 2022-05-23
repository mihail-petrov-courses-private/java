package commands.event;

import managers.EventManager;
import util.Terminal;

public class CreateEvent {

    public static void process() {

        Terminal.output("Въведете данни за събитието");
        String eventTitle               = Terminal.inputString("Име на събитие: ");
        String adultOnlyQuestionAnswer  = Terminal.inputString("Събието само за възрастни ли е  Y/N");
        boolean isAdultOnly             = adultOnlyQuestionAnswer.equals("Y");

        EventManager.createEvent(eventTitle, isAdultOnly);
    }
}
