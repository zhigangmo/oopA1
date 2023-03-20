public class TutorAssignment {
    private Tutor tutor;
    private int hours;

    public TutorAssignment(Tutor tutor, int hours) {
        this.tutor = tutor;
        this.hours = hours;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}

