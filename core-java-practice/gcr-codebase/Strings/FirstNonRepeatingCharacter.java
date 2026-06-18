import java.util.*;

public class FirstNonRepeatingCharacter {
    
    // Method to find first non-repeating character
    public static char findFirstNonRepeatingCharacter(String text) {
        // Create array to store frequency of characters (256 ASCII characters)
        int[] frequency = new int[256];
        
        // Count frequency of each character
        int textLength = getStringLength(text);
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Find first non-repeating character
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }
        
        // Return null character if no non-repeating character found
        return '\0';
    }
    
    // Helper method to find string length without using length()
    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception thrown when index out of bounds
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        char firstNonRepeating = findFirstNonRepeatingCharacter(text);
        
        System.out.println("\n" + "=".repeat(40));
        System.out.println("String: " + text);
        System.out.println("=".repeat(40));
        
        if (firstNonRepeating != '\0') {
            System.out.println("First Non-Repeating Character: " + firstNonRepeating);
        } else {
            System.out.println("No non-repeating character found");
        }
        
        System.out.println("=".repeat(40));
        
        sc.close();
    }
}
