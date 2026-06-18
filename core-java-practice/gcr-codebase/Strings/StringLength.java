import java.util.*;

public class StringLength {
    
    // Method to find string length without using length() method
    public static int findLengthWithoutLengthMethod(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception is thrown when index is out of bounds
            // This means we've reached the end of the string
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the string:");
        String text = sc.next();
        
        // Get length using user-defined method
        int customLength = findLengthWithoutLengthMethod(text);
        
        // Get length using built-in length() method
        int builtInLength = text.length();
        
        System.out.println("\nString: " + text);
        System.out.println("Length using user-defined method: " + customLength);
        System.out.println("Length using built-in length() method: " + builtInLength);
        System.out.println("Results match: " + (customLength == builtInLength));
        
        sc.close();
    }
}
