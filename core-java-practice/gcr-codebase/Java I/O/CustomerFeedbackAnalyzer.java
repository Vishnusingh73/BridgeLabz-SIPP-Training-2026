import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class CustomerFeedbackAnalyzer {

    public static void main(String[] args) {
        String feedbackFile = "feedback.txt";
        int goodCount = 0;
        int linesRead = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(feedbackFile))) {
            String line;
            while (linesRead < 5 && (line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("good")) {
                    goodCount++;
                }
                linesRead++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Feedback file not found: " + feedbackFile);
            return;
        } catch (IOException e) {
            System.out.println("Error reading feedback file: " + e.getMessage());
            return;
        }

        System.out.println("Good Feedback Count = " + goodCount);
    }
}
