import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class DailyExpenseLogger {

    public static void main(String[] args) {
        String expensesFile = "expenses.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine().trim();
        System.out.print("Enter expense amount: ");
        String amount = scanner.nextLine().trim();

        try (PrintWriter writer = new PrintWriter(new FileWriter(expensesFile, true))) {
            writer.printf("%s - %s%n", category, amount);
            System.out.println("Expense saved to " + expensesFile);
        } catch (IOException e) {
            System.out.println("Unable to write expense file: " + e.getMessage());
        }
    }
}
