package trackmanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Session {

    public List<Talk> talks;

    public Session() {
        this.talks = new ArrayList<>();
    }

    public Integer getTotalDuration() {
        return talks.stream().mapToInt(t -> t.duration).sum();
    }
}
