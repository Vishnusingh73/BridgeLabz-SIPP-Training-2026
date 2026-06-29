import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class EmailDomainCounter {

    public static void main(String[] args) {
        String emailFile = "emails.txt";
        Map<String, Integer> domainCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(emailFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String email = line.trim();
                int atIndex = email.indexOf('@');
                if (atIndex > 0 && atIndex < email.length() - 1) {
                    String domain = email.substring(atIndex + 1).toLowerCase();
                    domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Email file not found: " + emailFile);
            return;
        } catch (IOException e) {
            System.out.println("Error reading email file: " + e.getMessage());
            return;
        }

        for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
