package trackmanagement.entity;

public class Track {

    public Session morningSession;
    public Session afternoonSession;

    public Track() {
        this.morningSession = new Session();
        this.afternoonSession = new Session();
    }
}
