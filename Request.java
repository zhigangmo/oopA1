
import java.util.ArrayList;
import java.util.List;

public class Request {
    private String topic;
    private int hours;
    private List<TutorAssignment> tutorAssignments;

    public Request(String topic, int hours) {
        this.topic = topic;
        this.hours = hours;
        this.tutorAssignments = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public int getHours() {
        return hours;
    }

    public List<TutorAssignment> getTutorAssignments() {
        return tutorAssignments;
    }

    public void addTutorAssignment(TutorAssignment tutorAssignment) {
        tutorAssignments.add(tutorAssignment);
    }
}
