import managers.EventManager;
import types.Event;
import util.Terminal;

public class Application {

    private static final String PROCESS_CREATE     = "init";
    private static final String PROCESS_LIST       = "list";
    private static final String PROCESS_REMOVE     = "remove";

    private static final String PROCESS_UPDATE     = "update";
    private static final String PROCESS_EXIT       = "exit";

    public static void processCreate() {

        Terminal.output("Въведете данни за събитието");
        String eventTitle               = Terminal.inputString("Име на събитие: ");
        String adultOnlyQuestionAnswer  = Terminal.inputString("Събието само за възрастни ли е  Y/N");
        boolean isAdultOnly             = adultOnlyQuestionAnswer.equals("Y");

        EventManager.createEvent(eventTitle, isAdultOnly);
    }

    public static void processUpdate() {

        int eventId = Terminal.inputInt("Въведете ID то на събитието, което ще актуализирате");
        Event processableEvent          = EventManager.getEventById(eventId);

        if(processableEvent == null) {

            Terminal.output("Няма намерено събитие за това ID");
            return;
        }

        String eventTitle               = Terminal.inputString("Име на събитие (" + processableEvent.getTitle() + "): ");
        String adultOnlyQuestionAnswer  = Terminal.inputString("Събието само за възрастни ли е (" + processableEvent.getTitle() + "):" + "  Y/N");
        boolean isAdultOnly             = adultOnlyQuestionAnswer.equals("Y");

        EventManager.updateEvent(processableEvent, eventTitle, isAdultOnly);
    }

    public static void processRemoveEvent() {

        int eventId = Terminal.inputInt("Въведете ID на събитието");
        EventManager.removeEventById(eventId);
    }

    public static void processList() {
        EventManager.listAllEvents();
    }

    public static void main(String[] args) {

        while(true) {

            Terminal.output("Изберете операция от меньото");
            Terminal.output("============================");
            Terminal.output("(" + PROCESS_CREATE + ") Създаване на събитие");
            Terminal.output("(" + PROCESS_REMOVE + ") Премахване на събитие по ID");
            Terminal.output("(" + PROCESS_LIST   + ")  Извеждане на всички събития");
            Terminal.output("(" + PROCESS_EXIT   + ")  Изход");
            String commandId = Terminal.inputString();

            if(commandId.equalsIgnoreCase(PROCESS_CREATE)) {
                processCreate();
            }

            if(commandId.equalsIgnoreCase(PROCESS_REMOVE)) {
                processRemoveEvent();
            }

            if(commandId.equalsIgnoreCase(PROCESS_UPDATE)) {
                processUpdate();
            }

            if(commandId.equalsIgnoreCase(PROCESS_LIST)) {
                processList();
            }

            if(commandId.equalsIgnoreCase(PROCESS_EXIT)) {
                break;
            }
        }
    }
}
