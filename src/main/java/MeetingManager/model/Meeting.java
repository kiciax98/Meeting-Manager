package MeetingManager.model;

public class Meeting {
    private int id;
    private String title;
    private String owner;
    private String date;
    private String topic;

    public Meeting(int id, String title, String owner, String date) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.date = date;
        this.topic = null;
    }

    public Meeting(int id, String title, String owner, String date, String topic) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        this.date = date;
        this.topic = topic;
    }

    public Meeting() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }

    public String getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
