package com.epicepicnes.events;

public class Event {

    String id; // ABBCFDGDFSGDFSD
    String title;
    boolean isAccesableForUnderaged;

    public Event(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAccesableForUnderaged = false;
    }

    public Event(String id, String title, boolean isAccesableForUnderaged) {
        this.id = id;
        this.title = title;
        this.isAccesableForUnderaged = isAccesableForUnderaged;
    }

}
