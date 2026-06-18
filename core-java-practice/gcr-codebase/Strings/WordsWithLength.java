import java.util.*;

public class WordsWithLength {
    
    // Method to find string length without using length() method
    public static int findLength(String str) {
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
    
    // Method to split text into words using charAt() without using built-in split()
    public static String[] splitTextIntoWords(String text) {
        int stringLength = findLength(text);
        int wordCount = 0;
        int[] spaceIndexes = new int[stringLength];
        
        // Find all space positions
        for (int i = 0; i < stringLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[wordCount] = i;
                wordCount++;
            }
        }
        
        // Total words = number of spaces + 1
        int totalWords = wordCount + 1;
        String[] words = new String[totalWords];
        
        int startIndex = 0;
        int wordIndex = 0;
        
        // Extract words using space indexes
        for (int i = 0; i < wordCount; i++) {
            words[wordIndex] = text.substring(startIndex, spaceIndexes[i]);
            startIndex = spaceIndexes[i] + 1;
            wordIndex++;
        }
        
        // Extract the last word
        words[wordIndex] = text.substring(startIndex);
        
        return words;
    }
    
    // Method to create 2D array with word and its length
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the text:");
        String text = sc.nextLine();
        
        // Split into words
        String[] words = splitTextIntoWords(text);
        
        // Get 2D array with words and their lengths
        String[][] wordsWithLengths = getWordsWithLengths(words);
        
        // Display in tabular format
        System.out.println("\n" + "=".repeat(40));
        System.out.println(String.format("%-20s | %-10s", "Word", "Length"));
        System.out.println("=".repeat(40));
        
        for (int i = 0; i < wordsWithLengths.length; i++) {
            int length = Integer.parseInt(wordsWithLengths[i][1]);
            System.out.println(String.format("%-20s | %-10d", wordsWithLengths[i][0], length));
        }
        
        System.out.println("=".repeat(40));
        
        sc.close();
    }
}
