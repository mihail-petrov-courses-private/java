package managers;

import types.Event;
import util.Collection;
import util.Terminal;

public class EventManager {

    private static int eventCollectionIndex    = 0;

    private static final int INIT_EVENT_SIZE = 10;

    private static Event[] eventCollection     = new Event[INIT_EVENT_SIZE];

    private static Event selectedEvent;


    public static boolean hasRegisteredEvents() {
        return eventCollectionIndex > 0;
    }

    public static void createEvent(String eventTitle, boolean isAdultOnly) {

         Event newEvent = new Event(eventTitle, isAdultOnly);
        eventCollection[eventCollectionIndex++] = newEvent;
    }

    public static void removeEventById(int id) {

        int eventIndex = getEventIndexById(id);
        Collection.remove(eventCollection, eventIndex);

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

            if(processableEvent != null) {
                Terminal.outputObject(processableEvent);
            }
        }
    }

    public static void setActiveEvent(Event event) {
        selectedEvent = event;
    }

    public static Event getActiveEvent() {
        return selectedEvent;
    }
}