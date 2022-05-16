import managers.CustomerManager;
import managers.EventManager;
import types.Customer;
import types.Event;
import util.Terminal;

public class Application {

    private static final String PROCESS_CREATE     = "init";
    private static final String PROCESS_LIST       = "list";
    private static final String PROCESS_REMOVE     = "remove";

    private static final String PROCESS_UPDATE     = "update";

    private static final String PROCESS_REGISTER_CUSTOMER = "register customer";
    private static final String PROCESS_EXIT       = "exit";

    public static void main(String[] args) {

        while(true) {

            Terminal.output("Изберете операция от меньото");
            Terminal.output("============================");
            Terminal.output("(" + PROCESS_CREATE + ") Създаване на събитие");
            Terminal.output("(" + PROCESS_REMOVE + ") Премахване на събитие по ID");
            Terminal.output("(" + PROCESS_LIST   + ") Извеждане на всички събития");

            if(EventManager.hasRegisteredEvents()) {
                Terminal.output("(" + PROCESS_REGISTER_CUSTOMER + ") Добавяне на потребител към съществуващо събитие");
            }

            Terminal.output("(" + PROCESS_EXIT   + ") Изход");
            String commandId = Terminal.inputString();

            boolean isProcessAddCustomerToEventAvailable = commandId.equalsIgnoreCase(PROCESS_REGISTER_CUSTOMER) &&
                                                                        EventManager.hasRegisteredEvents();

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

            if(isProcessAddCustomerToEventAvailable) {
                processAddCustomerToEvent();
            }

            if(commandId.equalsIgnoreCase(PROCESS_EXIT)) {
                break;
            }
        }
    }

    private static void processCreate() {

        Terminal.output("Въведете данни за събитието");
        String eventTitle               = Terminal.inputString("Име на събитие: ");
        String adultOnlyQuestionAnswer  = Terminal.inputString("Събието само за възрастни ли е  Y/N");
        boolean isAdultOnly             = adultOnlyQuestionAnswer.equals("Y");

        EventManager.createEvent(eventTitle, isAdultOnly);
    }

    private static void processUpdate() {

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

    private static void processRemoveEvent() {

        int eventId = Terminal.inputInt("Въведете ID на събитието");
        EventManager.removeEventById(eventId);
    }

    private static void processList() {
        EventManager.listAllEvents();
    }

    private static void processAddCustomerToEvent() {

        processList();

        int eventId = Terminal.inputInt("Изберете съществуващо събитие");
        Terminal.output("=========================================");
        Terminal.output("Вие избрахте");
        Event selectedEvent = EventManager.getEventById(eventId);
        Terminal.outputObject(selectedEvent);
        Terminal.output("=========================================");

        if(CustomerManager.hasRegisteredCustomers()) {
            processAddCustomerToEventOptions(selectedEvent);
            return;
        }

        registerCustomerDirectly(selectedEvent);
    }

    private static void processAddCustomerToEventOptions(Event selectedEvent) {

        Terminal.output("Изберете вариант за регистрация на потребител");
        Terminal.output("(1) Избор от списък");
        Terminal.output("(2) Регистрация на нов потребител");
        int operationId = Terminal.inputInt();

        if(operationId == 1) {
            registerCustomerBasedOnList(selectedEvent);
            return;
        }

        if(operationId == 2) {
            registerCustomerDirectly(selectedEvent);
            return;
        }
    }

    private static void registerCustomerDirectly(Event selectedEvent) {

        Customer selectedCustomer = processCustomerRegister();

        if(selectedCustomer != null) {

            selectedEvent.registerCustomer(selectedCustomer);
            Terminal.output("Потребителя е добавен към събитието успешно");
        }
    }

    private static void registerCustomerBasedOnList(Event selectedEvent) {

        Terminal.output("Изберете потребител от списъка");
        Terminal.output("==============================");
        CustomerManager.listAllCustomers();
        int selectedCustomerId = Terminal.inputInt();
        Customer selectedCustomer = CustomerManager.getCustomerById(selectedCustomerId);

        if(selectedCustomer != null) {

            selectedEvent.registerCustomer(selectedCustomer);
            Terminal.output("Потребителя е добавен към събитието успешно");
        }
    }

    private static Customer processCustomerRegister() {

        final String GENDER_MALE = "M";
        final String GENDER_FEMALE = "F";

        Terminal.output("Въведете информация за клиента");
        String firstName    = Terminal.inputString("Първо име");
        String lastName     = Terminal.inputString("Второ име");
        String gender       = Terminal.inputString("Пол - M / F");
        int age             = Terminal.inputInt("Възраст");

        boolean isAgeCorrect = (age > 1) && (age < 100);

        boolean isGenderCorrect = gender.equalsIgnoreCase(GENDER_MALE) &&
                                  gender.equalsIgnoreCase(GENDER_FEMALE);

        if(!isGenderCorrect) {

            Terminal.output("Въведохте грешен пол - за потребителя");
            Terminal.output("Операция приключва - неуспешно");
            return null;
        }

        if(!isAgeCorrect) {
            Terminal.output("Въведохте възраст извън интервала 1 - 100 ");
            Terminal.output("Операция приключва - неуспешно");
            return null;
        }

        Customer newCustomer = CustomerManager.createCustomer(firstName, lastName, gender, age);
        Terminal.output("Потребителя е добавен успешно");

        return newCustomer;
    }
}
