package managers;

import types.Event;
import util.Terminal;

public class EventManager {

    private static int eventCollectionIndex    = 0;
    private static Event[] eventCollection     = new Event[10];

    public static void createEvent(String eventTitle, boolean isAdultOnly) {

        Event newEvent = new Event(eventTitle, isAdultOnly);
        eventCollection[eventCollectionIndex++] = newEvent;
    }

    public static void removeEventById(int id) {
        int eventIndex = getEventIndexById(id);

        // на базата на индекса - да елиминирам този елемент
        eventCollection[eventIndex] = null;
    }

    public static Event getEventById(int id) {

        for(int i = 0; i < eventCollection.length; i++) {
            Event event = eventCollection[i];
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
        for(int i = 0; i < eventCollectionIndex; i++) {

            Event processableEvent = eventCollection[i];
            Terminal.output(processableEvent.render());
        }
    }
}
