
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import trackmanagement.TrackManagement;
import trackmanagement.entity.Talk;
import trackmanagement.entity.Track;

/**
 *
 * @author notchaeng
 */
public class TrackManagementTest {

    @Test
    public void testAssignTalksToTracks() {
        String[] input = {
            "Writing Fast Tests Against Enterprise Rails 60min",
            "Overdoing it in Python 45min"
        };
        List<Talk> talks = TrackManagement.parseTalks(input);
        List<Track> tracks = TrackManagement.assignTalksToTracks(talks);
        assertEquals(2, talks.size());
        assertEquals(1, tracks.size());
    }
}
