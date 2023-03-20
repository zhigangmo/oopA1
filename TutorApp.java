
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TutorApp {
    public static void main(String[] args) {
        TutorManager tutorManager = new TutorManager();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] commandParts = line.split("\\s+");
                tutorManager.processCommand(commandParts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
