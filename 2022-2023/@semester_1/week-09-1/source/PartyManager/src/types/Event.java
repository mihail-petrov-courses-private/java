package types;

import util.SequenceGenerator;

public class Event {
    private int id;
    private String title;
    private boolean isAdultOnly;

    public Event(String title, boolean isAdultOnly) {

        this.id          = SequenceGenerator.next();
        this.title       = title;
        this.isAdultOnly = isAdultOnly;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAdultOnly() {
        return this.isAdultOnly;
    }

    public void setAdultOnly(boolean adultOnly) {
        this.isAdultOnly = adultOnly;
    }

    public String render() {

        String ageNotification = this.isAdultOnly() ? "18+" : "0+";
        return this.getTitle() + " : " + ageNotification;
    }
}