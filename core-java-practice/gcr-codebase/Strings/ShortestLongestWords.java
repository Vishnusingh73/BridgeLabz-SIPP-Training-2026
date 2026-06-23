import java.util.*;

public class ShortestLongestWords {
    
    
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
           
        }
        return count;
    }
    
  
    public static String[] splitTextIntoWords(String text) {
        int stringLength = findLength(text);
        int wordCount = 0;
        int[] spaceIndexes = new int[stringLength];
        
      
        for (int i = 0; i < stringLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[wordCount] = i;
                wordCount++;
            }
        }
        
        int totalWords = wordCount + 1;
        String[] words = new String[totalWords];
        
        int startIndex = 0;
        int wordIndex = 0;
        
      
        for (int i = 0; i < wordCount; i++) {
            words[wordIndex] = text.substring(startIndex, spaceIndexes[i]);
            startIndex = spaceIndexes[i] + 1;
            wordIndex++;
        }
        
        
        words[wordIndex] = text.substring(startIndex);
        
        return words;
    }
    
   
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        
        return result;
    }
    
  
    public static int[] findShortestLongestIndex(String[][] wordsWithLengths) {
        int[] result = new int[2]; // [shortestIndex, longestIndex]
        int shortestLength = Integer.parseInt(wordsWithLengths[0][1]);
        int longestLength = Integer.parseInt(wordsWithLengths[0][1]);
        int shortestIndex = 0;
        int longestIndex = 0;
        
        for (int i = 1; i < wordsWithLengths.length; i++) {
            int currentLength = Integer.parseInt(wordsWithLengths[i][1]);
            
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestIndex = i;
            }
            
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestIndex = i;
            }
        }
        
        result[0] = shortestIndex;
        result[1] = longestIndex;
        
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
        
        // Display all words with lengths
        System.out.println("\n" + "=".repeat(40));
        System.out.println(String.format("%-20s | %-10s", "Word", "Length"));
        System.out.println("=".repeat(40));
        
        for (int i = 0; i < wordsWithLengths.length; i++) {
            int length = Integer.parseInt(wordsWithLengths[i][1]);
            System.out.println(String.format("%-20s | %-10d", wordsWithLengths[i][0], length));
        }
        
        System.out.println("=".repeat(40));
        
        // Find shortest and longest
        int[] indexes = findShortestLongestIndex(wordsWithLengths);
        int shortestIndex = indexes[0];
        int longestIndex = indexes[1];
        
        System.out.println("\nShortest Word: " + wordsWithLengths[shortestIndex][0] + 
                         " (Length: " + wordsWithLengths[shortestIndex][1] + ")");
        System.out.println("Longest Word: " + wordsWithLengths[longestIndex][0] + 
                         " (Length: " + wordsWithLengths[longestIndex][1] + ")");
        
        sc.close();
    }
}
