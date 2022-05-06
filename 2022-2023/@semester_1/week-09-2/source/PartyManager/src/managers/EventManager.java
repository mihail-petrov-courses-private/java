package managers;

import types.Event;
import util.Terminal;

public class EventManager {

    private static int eventCollectionIndex    = 0;

    private static final int INIT_EVENT_SIZE = 10;

    private static Event[] eventCollection     = new Event[INIT_EVENT_SIZE];

    public static void createEvent(String eventTitle, boolean isAdultOnly) {

         Event newEvent = new Event(eventTitle, isAdultOnly);
        eventCollection[eventCollectionIndex++] = newEvent;
    }

    public static void removeEventById(int id) {
        int eventIndex = getEventIndexById(id);

        // на базата на индекса - да елиминирам този елемент
        eventCollection[eventIndex] = null;

        // да прехвърля всички останали елементи в нов масив
        Event[] temporalEventCollection = new Event[INIT_EVENT_SIZE];
        int temporalIndex = 0;

//        for(int i = 0; i < eventCollection.length; i++) {
//
//            Event eventElement = eventCollection[i];
//
//            if(eventElement != null) {
//                temporalEventCollection[temporalIndex++] = eventElement;
//            }
//        }

        // FOR цикъл - за изрично обхождане на колекции от данни
        for(Event eventElement : eventCollection) {

            if(eventElement != null) {
                temporalEventCollection[temporalIndex++] = eventElement;
            }
        }

        eventCollection = temporalEventCollection;
        eventCollectionIndex--;
    }

    public static void updateEvent(Event processableEvent, String eventTitle, boolean isAdultOnly) {
        processableEvent.setTitle(eventTitle);
        processableEvent.setAdultOnly(isAdultOnly);
    }

    public static Event getEventById(int id) {

        for(Event event: eventCollection) {

            if(event.getId() == id) {
                return event;
            }
        }

        return null;
    }

    public static int getEventIndexById(int id) {

        for(int i = 0; i < eventCollection.length; i++) {
            Event event = eventCollection[i];
            if(event.getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public static void listAllEvents() {

        for(Event processableEvent : eventCollection) {
            Terminal.outputObject(processableEvent);
        }
    }
}