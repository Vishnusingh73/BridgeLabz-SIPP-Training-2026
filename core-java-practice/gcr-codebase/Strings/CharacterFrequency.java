import java.util.*;

public class CharacterFrequency {
    
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
    
    // Method to find frequency of characters in a string
    public static String[][] findCharacterFrequency(String text) {
        // Create array to store frequency of characters (256 ASCII characters)
        int[] frequency = new int[256];
        int textLength = getStringLength(text);
        
        // Count frequency of each character
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Count unique characters with frequency > 0
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }
        
        // Create 2D array to store characters and their frequencies
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        
        // Store characters and their frequencies
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            
            // Check if character already added
            boolean alreadyAdded = false;
            for (int j = 0; j < index; j++) {
                if (result[j][0].charAt(0) == ch) {
                    alreadyAdded = true;
                    break;
                }
            }
            
            // Add character if not already added
            if (!alreadyAdded) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        // Get character frequencies
        String[][] frequencies = findCharacterFrequency(text);
        
        System.out.println("\n" + "=".repeat(40));
        System.out.println("String: " + text);
        System.out.println("=".repeat(40));
        System.out.println(String.format("%-10s | %-10s", "Character", "Frequency"));
        System.out.println("-".repeat(40));
        
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(String.format("%-10s | %-10s", frequencies[i][0], frequencies[i][1]));
        }
        
        System.out.println("=".repeat(40));
        
        sc.close();
    }
}
