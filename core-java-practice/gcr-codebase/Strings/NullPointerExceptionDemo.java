import java.util.*;

public class NullPointerExceptionDemo {
    
   
    public static void generateNullPointerException() {
        System.out.println("--- Demonstrating NullPointerException (will crash) ---");
        String text = null;
        System.out.println("Calling length() on null string:");
        System.out.println(text.length());
    }
    
    public static void handleNullPointerException() {
        System.out.println("--- Handling NullPointerException with try-catch ---");
        try {
            String text = null;
            System.out.println("Attempting to call length() on null string...");
            System.out.println(text.length());
        } catch (java.lang.NullPointerException e) {
            System.out.println("Caught NullPointerException!");
            System.out.println("Exception: A null object cannot be used to invoke methods");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== NullPointerException Demonstration ===\n");
        System.out.println("1. Generate NullPointerException (will crash program)");
        System.out.println("2. Handle NullPointerException (with try-catch)\n");
        
        System.out.println("Choose an option (1 or 2):");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            try {
                generateNullPointerException();
            } catch (java.lang.NullPointerException e) {
                System.out.println("Program crashed with NullPointerException!");
                System.out.println("This is why we need exception handling.");
            }
        } else if (choice == 2) {
            handleNullPointerException();
            System.out.println("\nProgram continued after exception was handled!");
        } else {
            System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
}
