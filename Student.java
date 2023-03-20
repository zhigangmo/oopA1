import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private ArrayList<Tutor> tutors;

    public Student(String name) {
        this.name = name;
        this.tutors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTutor(String tutorName, String topic, int hoursTaught) {
        Tutor tutor = new Tutor(tutorName, topic, hoursTaught);
        tutors.add(tutor);
    }

    public ArrayList<Tutor> getTutors() {
        return tutors;
    }
    
    public int assignTutor(Tutor bestTutor, String topic,  int hoursRequested)
    {
       if( hoursRequested <= bestTutor.getHoursTaught()) 
           return hoursRequested;
       return 0;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", tutors=" + tutors +
                '}';
    }
}
