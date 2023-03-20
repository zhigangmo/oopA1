import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tutor {
    private String name;
    private double hourlyRate;
    private List<String> expertise = new ArrayList<>();
    private int hoursTaught;

     public Tutor(String name,  int hoursTaught) {
        this.name = name;
        this.hoursTaught = hoursTaught;
     }

     public Tutor(String name, String topic,  int hoursTaught) {
        this.name = name;
        this.hoursTaught = hoursTaught;
        this.expertise.add( topic ); 
        //addPrice(topic, hoursTaught);
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void addPrice(String topic, int price) {
        this.hourlyRate = price;
        //this.topic = topic;
        this.expertise.add(topic);
    }

    public boolean hasExpertise(String topic) { // return wrong
        return this.expertise.contains(topic);
    }

    //public int getExpertiseLevel(String topic) {
        //return this.expertise.getOrDefault(topic, 0);
    //}

    public void addHoursTaught(int hours) {
        this.hoursTaught += hours;
    }

    public int getHoursTaught() {
        return hoursTaught;
    }


}
