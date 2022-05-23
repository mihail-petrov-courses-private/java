import managers.EventManager;
import types.Event;
import util.Terminal;

public class Application {

    public static void processCreate() {

        Terminal.output("Въведете данни за събитието");
        String eventTitle               = Terminal.inputString("Име на събитие: ");
        String adultOnlyQuestionAnswer  = Terminal.inputString("Събието само за възрастни ли е  Y/N");
        boolean isAdultOnly             = adultOnlyQuestionAnswer.equals("Y");

        EventManager.createEvent(eventTitle, isAdultOnly);
    }

    public static void processList() {
        EventManager.listAllEvents();
    }

    public static void main(String[] args) {

        while(true) {

            Terminal.output("Изберете операция от меньото");
            Terminal.output("============================");
            Terminal.output("(1) Създаване на събитие");
            Terminal.output("(2) Извеждане на всички събития");
            Terminal.output("(3) Изход");
            int commandId = Terminal.inputInt();

            if(commandId == 1) {
                processCreate();
            }

            if(commandId == 2) {
                processList();
            }

            if(commandId == 3) {
                break;
            }
        }
    }
}
