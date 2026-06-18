import java.util.*;

public class UniqueCharacterFrequency {
    
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
    
    // Method to find unique characters in a string using nested loops
    public static char[] findUniqueCharacters(String text) {
        int textLength = getStringLength(text);
        char[] uniqueChars = new char[textLength];
        int uniqueCount = 0;
        
        // Use nested loops to find unique characters
        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
            // Check if character already in uniqueChars array
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueChars[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            
            // Add character if unique
            if (isUnique) {
                uniqueChars[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }
        
        // Create result array with exact size
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueChars[i];
        }
        
        return result;
    }
    
    // Method to find frequency of characters in a string
    public static String[][] findCharacterFrequencyUsingUnique(String text) {
        // Create array to store frequency of characters (256 ASCII characters)
        int[] frequency = new int[256];
        int textLength = getStringLength(text);
        
        // Count frequency of each character
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Get unique characters
        char[] uniqueChars = findUniqueCharacters(text);
        
        // Create 2D array to store unique characters and their frequencies
        String[][] result = new String[uniqueChars.length][2];
        
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        // Get unique characters
        char[] uniqueCharacters = findUniqueCharacters(text);
        
        // Get character frequencies using unique characters
        String[][] frequencies = findCharacterFrequencyUsingUnique(text);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("String: " + text);
        System.out.println("=".repeat(50));
        
        System.out.println("\nUnique Characters: ");
        System.out.print("[ ");
        for (int i = 0; i < uniqueCharacters.length; i++) {
            System.out.print(uniqueCharacters[i]);
            if (i < uniqueCharacters.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
        
        System.out.println("\n" + String.format("%-15s | %-15s", "Character", "Frequency"));
        System.out.println("-".repeat(50));
        
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(String.format("%-15s | %-15s", frequencies[i][0], frequencies[i][1]));
        }
        
        System.out.println("=".repeat(50));
        
        sc.close();
    }
}
