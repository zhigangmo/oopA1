import java.util.HashMap;
import java.util.Map;

public class TutorManager {
    private Map<String, Tutor> tutors;
    private Map<String, Student> students;

    public TutorManager() {
        tutors = new HashMap<>();
        students = new HashMap<>();
    }

    public Tutor findTutorByName( String tn ) // return null 1st
    {
        return tutors.get( tn ); // return null if not found 
    }

    public void addTutor(String tutorName, String topic, int hours, double rates) {
        Tutor tutor = findTutorByName(tutorName);
        if (tutor == null) { //initalize
            tutor = new Tutor(tutorName, topic, hours);
            tutors.put(tutor.getName(), tutor);
        }
        //tutor.addPrice(topic, hours); // pending to modify
    }

    public void addStudent(String studentName) {
        Student student = new Student(studentName);
        students.put(studentName, student);
    }

    public void addTutorExpertise(String tutorName, String topic, int price) {
        Tutor tutor = findTutorByName(tutorName);
        if (tutor != null) {
            tutor.addPrice(topic, price);
        }
    }

    public void assignTutor(String studentName, String topic, int hoursRequested) {
        Student student = students.get(studentName);
        if (student == null) {
            System.out.println("Student " + studentName + " not found.");
            return;
        }

        Tutor bestTutor = findBestTutor(topic);
        if (bestTutor != null) {
            student.addTutor(bestTutor.getName(), topic, hoursRequested);
            bestTutor.addHoursTaught(hoursRequested);
        } else {
            System.out.println("No tutor found for the requested topic.");
        }
    }

    // can"t find
    private Tutor findBestTutor(String topic) {
        Tutor bestTutor = null;
        double minHourlyRate = Double.MAX_VALUE;

        for(Tutor tutor : tutors.values()){ // loop each tutor, tutor? topic? 1st tutor should be tutor1  
                                              // with 20 rate, but tutor2 is 15 
            if (tutor.hasExpertise(topic) && tutor.getHourlyRate() < minHourlyRate) { //skip
                // hasExpertise return fasle

                minHourlyRate = tutor.getHourlyRate();
                bestTutor = tutor;
            }
        }
        return bestTutor;
    }

    public Student getStudent(String studentName) {
        return students.get(studentName);
    }

    public Tutor getTutor(String tutorName) {
        return findTutorByName(tutorName);
    }

    public void processCommand(String[] commandParts) {
        //String command = commandParts[0].toUpperCase();
        String command = commandParts[0];
        switch (command) {
            case "TUTOR":
                if (commandParts.length != 3) {
                    System.out.println("Invalid number of arguments for TUTOR command");
                    break;
                }
                String tutorName = commandParts[1];
                int hours = Integer.parseInt(commandParts[2]);
                addTutor(tutorName, "", hours, 0); // empty for topic
                break;
            case "STUDENT":
                if (commandParts.length != 2) {
                    System.out.println("Invalid number of arguments for STUDENT command");
                    break;
                }
                String studentName = commandParts[1];
                addStudent(studentName);
                break;
            case "TOPIC":
                if (commandParts.length != 4) {
                    System.out.println("Invalid number of arguments for TOPIC command");
                    break;
                }
                String topic = commandParts[1];
                String tutorAssigned = commandParts[2];
                int price = Integer.parseInt(commandParts[3]);
                addTutorExpertise(tutorAssigned, topic, price);
                break;

            case "REQUEST": 
                                if (commandParts.length != 4) {
                                    System.out.println("Invalid number of arguments for REQUEST command");
                                    break;
                                }
                                String studentName1 = commandParts[1];
                                String topic1 = commandParts[2];
                                int hoursRequested = Integer.parseInt(commandParts[3]);
                                processRequest(studentName1, topic1, hoursRequested);
                                break;
            
            case "STUDENTREPORT":
                            if (commandParts.length != 2) {
                                System.out.println("Invalid number of arguments for STUDENTREPORT command");
                                break;
                            }
                            String n = commandParts[1];
                            generateStudentReport(n);
                            break;

            case "TUTORREPORT":
                            if (commandParts.length != 2) {
                                System.out.println("Invalid number of arguments for TUTORREPORT command");
                                break;
                            }
                            String t= commandParts[1];
                            generateTutorReport(t);
                            break;

            default:
                            System.out.println("Unknown command: " + command);
                            break;

        }
    }

    public void generateStudentReport(String  n)
    {
        Student s = students.get(n);
        if( s != null )
            System.out.println( s.toString() );
    }

    public void generateTutorReport(String  n)
    {
        Tutor t = tutors.get(n);
        if( t != null )
            System.out.println(t.toString());
    }

    public void processRequest(String studentName, String topic, int hoursRequested) {
        Student student = students.get(studentName);
        if (student == null) {
            System.out.println("Student " + studentName + " not found.");
            return;
        }

        Tutor bestTutor = findBestTutor(topic);
        if (bestTutor == null) { // correct
            System.out.println("No suitable tutor found for topic " + topic);
            return;
        }

        int hoursAssigned = student.assignTutor(bestTutor, topic, hoursRequested);
        if (hoursAssigned == 0) {
            System.out.println("Tutor " + bestTutor.getName() + " has no available hours for topic " + topic);
        } else {
            System.out.println("Assigned " + hoursAssigned + " hours of tutoring on topic " + topic + " to tutor " + bestTutor.getName() + " for student " + student.getName());
            bestTutor.addHoursTaught(hoursAssigned);
        }
    }
}

