package me.mihailpetrov.stagestopwatch.models;

public class TimestampSection {

    private String startTimestamp;
    private String endTimestamp;

    private String description;

    public TimestampSection(String startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public TimestampSection(String startTimestamp, String endTimestamp) {
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    public boolean isOpen() {
        return this.startTimestamp != null &&
                this.endTimestamp == null;
    }

    public boolean isFinalized() {
        return  this.startTimestamp != null &&
                this.endTimestamp != null;
    }

    public String getDescription() {
        return (this.description == null) ? "" : this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(String startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public String getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(String endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public String render() {

        if(this.endTimestamp == null) {
            return this.startTimestamp + "\n" + this.getDescription();
        }
        return this.startTimestamp + " --> " + this.endTimestamp + "\n" + this.getDescription();
    }

}
