import java.util.*;

public class StringSplit {
    
    // Method to find string length without using length() method
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception thrown when index out of bounds - reached end of string
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
    
    // Method to compare two String arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the text:");
        String text = sc.nextLine();
        
        // Split using user-defined method
        String[] customSplitWords = splitTextIntoWords(text);
        
        // Split using built-in split() method
        String[] builtInSplitWords = text.split(" ");
        
        System.out.println("\nUser-defined split() result:");
        for (int i = 0; i < customSplitWords.length; i++) {
            System.out.println((i + 1) + ". " + customSplitWords[i]);
        }
        
        System.out.println("\nBuilt-in split() result:");
        for (int i = 0; i < builtInSplitWords.length; i++) {
            System.out.println((i + 1) + ". " + builtInSplitWords[i]);
        }
        
        // Compare the two arrays
        boolean isEqual = compareStringArrays(customSplitWords, builtInSplitWords);
        
        System.out.println("\nComparison Result: " + (isEqual ? "Both arrays are equal" : "Arrays are not equal"));
        
        sc.close();
    }
}
