package trackmanagement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import trackmanagement.entity.Session;
import trackmanagement.entity.Talk;
import trackmanagement.entity.Track;

/**
 * A class for managing the scheduling of talks into tracks.
 */
public class TrackManagement {

    // Constants for morning and afternoon session durations
    private static final Integer MORNING_DURATION = 180;
    private static final Integer AFTERNOON_DURATION = 240;

    // Constants for start and end times of the morning session
    private static final String START_TIME = "09:00AM";
    private static final String END_TIME = "01:00PM";

    /**
     * The main method of the TrackManagement class. It parses talks, assigns
     * them to tracks, and prints the schedule.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        String[] input = {
            "Writing Fast Tests Against Enterprise Rails 60min",
            "Overdoing it in Python 45min",
            "Lua for the Masses 30min",
            "Ruby Errors from Mismatched Gem Versions 45min",
            "Common Ruby Errors 45min",
            "Rails for Python Developers lightning",
            "Communicating Over Distance 60min",
            "Accounting-Driven Development 45min",
            "Woah 30min",
            "Sit Down and Write 30min",
            "Pair Programming vs Noise 45min",
            "Rails Magic 60min",
            "Ruby on Rails: Why We Should Move On 60min",
            "Clojure Ate Scala (on my project) 45min",
            "Programming in the Boondocks of Seattle 30min",
            "Ruby vs. Clojure for Back-End Development 30min",
            "Ruby on Rails Legacy App Maintenance 60min",
            "A World Without HackerNews 30min",
            "User Interface CSS in Rails Apps 30min"
        };
        List<Talk> talks = parseTalks(input);
        List<Track> tracks = assignTalksToTracks(talks);

        printSchedule(tracks);
    }

    /**
     * Parses the list of talks from input strings.
     *
     * @param input An array of strings representing talks.
     * @return A list of Talk objects parsed from input strings.
     */
    public static List<Talk> parseTalks(String[] input) {

        List<Talk> talks = new ArrayList<>();
        for (String talkStr : input) {
            String title = talkStr.replaceAll("\\d+min|lightning", "").trim();
            Integer duration = talkStr.contains("lightning") ? 5 : Integer.valueOf(talkStr.replaceAll("\\D+", ""));
            talks.add(new Talk(title, duration));
        }
        return talks;
    }

    /**
     * Assigns talks to tracks based on available session durations.
     *
     * @param talks The list of talks to be assigned to tracks.
     * @return A list of tracks with assigned talks.
     */
    public static List<Track> assignTalksToTracks(List<Talk> talks) {
        List<Track> tracks = new ArrayList<>();

        tracks.add(new Track());

        Integer trackIndex = 0;
        for (Talk talk : talks) {
            Session session = new Session();
            Track track = tracks.get(trackIndex);
            if (track.morningSession.getTotalDuration() + talk.duration <= MORNING_DURATION) {
                session = track.morningSession;
            } else if (track.afternoonSession.getTotalDuration() + talk.duration <= AFTERNOON_DURATION) {
                session = track.afternoonSession;
            } else {
                trackIndex++;
                tracks.add(new Track());
            }
            session.talks.add(talk);
        }
        return tracks;
    }

    /**
     * Prints the schedule of talks for each track.
     *
     * @param tracks The list of tracks containing talks.
     */
    public static void printSchedule(List<Track> tracks) {
        Integer trackNumber = 1;
        for (Track track : tracks) {
            System.out.println("Track " + trackNumber + ":");
            printSession(track.morningSession, START_TIME);
            System.out.println("12:00PM Lunch");
            printSession(track.afternoonSession, END_TIME);
            System.out.println(getFinalEventHour(track.afternoonSession.getTotalDuration()) + "Networking Event\n");
            trackNumber++;
        }
    }

    /**
     * Prints the talks within a session starting from a specified time.
     *
     * @param session The session containing talks to be printed.
     * @param startTime The starting time of the session.
     */
    private static void printSession(Session session, String startTime) {
        Integer hour = Integer.valueOf(startTime.substring(0, 2));
        Integer minute = Integer.valueOf(startTime.substring(3, 5));
        String abbreviation = startTime.substring(5, 7);

        for (Talk talk : session.talks) {
            String durationStr = talk.duration == 5 ? "lightning" : talk.duration + "min";
            System.out.printf("%02d:%02d%s %s %s\n", hour, minute, abbreviation, talk.title, durationStr);
            minute += talk.duration;
            if (minute >= 60) {
                hour++;
                minute = minute % 60;
            }
        }
    }

    /**
     * Calculates the final event hour based on the total session duration.
     *
     * @param sessionDuration The total duration of the session.
     * @return A string representing the final event hour.
     */
    private static String getFinalEventHour(Integer sessionDuration) {
        LocalTime time = LocalTime.of(1, 0);
        LocalTime finalHour = time.plusMinutes(sessionDuration);
        return finalHour.toString() + "PM ";
    }
}
