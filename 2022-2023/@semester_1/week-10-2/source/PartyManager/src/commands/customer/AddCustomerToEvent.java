package commands.customer;

import managers.CustomerManager;
import managers.EventManager;
import types.Customer;
import types.Event;
import util.Terminal;

public class AddCustomerToEvent {

    public static void process() {

        EventManager.listAllEvents();

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

        boolean isGenderCorrect = gender.equalsIgnoreCase(GENDER_MALE) ||
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
