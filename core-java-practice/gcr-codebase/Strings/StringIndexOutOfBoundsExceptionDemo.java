import java.util.*;

public class StringIndexOutOfBoundsExceptionDemo {
    
    // Method to generate StringIndexOutOfBoundsException
    public static void generateStringIndexOutOfBoundsException(String str) {
        System.out.println("--- Demonstrating StringIndexOutOfBoundsException (will crash) ---");
        System.out.println("String: " + str);
        System.out.println("String length: " + str.length());
        System.out.println("Accessing character at index beyond string length:");
        System.out.println(str.charAt(str.length()));  // This will throw exception
    }
    
    // Method to handle StringIndexOutOfBoundsException
    public static void handleStringIndexOutOfBoundsException(String str) {
        System.out.println("--- Handling StringIndexOutOfBoundsException with try-catch ---");
        System.out.println("String: " + str);
        System.out.println("String length: " + str.length());
        
        try {
            System.out.println("Attempting to access character at index beyond string length...");
            System.out.println(str.charAt(str.length()));
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException!");
            System.out.println("Exception: Attempted to access index " + str.length() + 
                             " but string length is only " + str.length());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== StringIndexOutOfBoundsException Demonstration ===\n");
        
        System.out.println("Enter a String:");
        String text = sc.next();
        
        System.out.println("\n1. Generate StringIndexOutOfBoundsException (will crash program)");
        System.out.println("2. Handle StringIndexOutOfBoundsException (with try-catch)\n");
        
        System.out.println("Choose an option (1 or 2):");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            try {
                generateStringIndexOutOfBoundsException(text);
            } catch (java.lang.StringIndexOutOfBoundsException e) {
                System.out.println("Program crashed with StringIndexOutOfBoundsException!");
                System.out.println("This is why we need exception handling.");
            }
        } else if (choice == 2) {
            handleStringIndexOutOfBoundsException(text);
            System.out.println("\nProgram continued after exception was handled!");
        } else {
            System.out.println("Invalid choice!");
        }
        
        sc.close();
    }
}
