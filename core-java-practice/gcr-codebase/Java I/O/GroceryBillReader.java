import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class GroceryBillReader {

    public static void main(String[] args) {
        String billFile = "bill.txt";
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(billFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Bill file not found: " + billFile);
            return;
        } catch (IOException e) {
            System.out.println("Error reading bill file: " + e.getMessage());
            return;
        }

        System.out.println("Total lines: " + lineCount);
    }
}
