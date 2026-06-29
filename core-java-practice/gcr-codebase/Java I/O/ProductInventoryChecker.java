import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ProductInventoryChecker {

    public static void main(String[] args) {
        String inventoryFile = "inventory.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split("[,\\s]+", 3);
                if (parts.length < 3) {
                    continue;
                }
                String productName = parts[0].trim();
                String stockStr = parts[1].trim();
                String priceStr = parts[2].trim();
                try {
                    int stock = Integer.parseInt(stockStr);
                    double price = Double.parseDouble(priceStr);
                    String status = stock == 0 ? "Out of stock" : "In stock";
                    System.out.printf("%s - Qty: %d, Price: %.2f, Status: %s%n", productName, stock, price, status);
                } catch (NumberFormatException ignored) {
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found: " + inventoryFile);
        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
    }
}
