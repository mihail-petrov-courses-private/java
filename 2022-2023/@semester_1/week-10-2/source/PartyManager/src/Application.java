import commands.customer.AddCustomerToEvent;
import commands.customer.RemoveCustomerFromEvent;
import commands.event.*;
import managers.EventManager;
import util.Terminal;

public class Application {

    private static final String PROCESS_CREATE     = "init";
    private static final String PROCESS_LIST       = "list";
    private static final String PROCESS_REMOVE     = "remove";
    private static final String PROCESS_UPDATE     = "update";
    private static final String PROCESS_REGISTER_CUSTOMER = "register_customer";
    private static final String PROCESS_GUEST_LIST = "guest_list";

    private static final String PROCESS_GUEST_REMOVE = "guest_remove";
    private static final String PROCESS_EXIT       = "exit";

    public static void main(String[] args) {

        while(true) {

            Terminal.output("Изберете операция от меньото");
            Terminal.output("============================");
            Terminal.output("(" + PROCESS_CREATE + ") Създаване на събитие");

            if(EventManager.hasRegisteredEvents()) {

                Terminal.output("(" + PROCESS_REMOVE + ") Премахване на събитие по ID");
                Terminal.output("(" + PROCESS_LIST   + ") Извеждане на всички събития");
                Terminal.output("(" + PROCESS_REGISTER_CUSTOMER + ") Добавяне на потребител към съществуващо събитие");
                Terminal.output("(" + PROCESS_GUEST_LIST   + ") Списък с гостите на дадено събитие");
                Terminal.output("(" + PROCESS_GUEST_REMOVE + ") Премахване на потребител от събитие");
            }

            Terminal.output("(" + PROCESS_EXIT   + ") Изход");
            String commandId = Terminal.inputString();


            boolean isProcessListEventAvailable         =   commandId.equalsIgnoreCase(PROCESS_LIST) &&
                                                            EventManager.hasRegisteredEvents();
            boolean isProcessAddCustomerToEventAvailable =  commandId.equalsIgnoreCase(PROCESS_REGISTER_CUSTOMER) &&
                                                            EventManager.hasRegisteredEvents();

            if(commandId.equalsIgnoreCase(PROCESS_CREATE)) {
                CreateEvent.process();
            }

            if(commandId.equalsIgnoreCase(PROCESS_REMOVE)) {
                RemoveEvent.process();
            }

            if(commandId.equalsIgnoreCase(PROCESS_UPDATE)) {
                UpdateEvent.process();
            }

            if(isProcessListEventAvailable) {
                ListEvent.process();
            }

            if(isProcessAddCustomerToEventAvailable) {
                AddCustomerToEvent.process();
            }

            if(commandId.equalsIgnoreCase(PROCESS_GUEST_LIST)) {
                ListGuestsForEvent.process();
            }

            if(commandId.equalsIgnoreCase(PROCESS_GUEST_REMOVE)) {
                RemoveCustomerFromEvent.process();
            }

            if(commandId.equalsIgnoreCase(PROCESS_EXIT)) {
                break;
            }
        }
    }
}
