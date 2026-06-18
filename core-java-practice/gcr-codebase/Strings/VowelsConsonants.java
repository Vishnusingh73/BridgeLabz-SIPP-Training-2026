import java.util.*;

public class VowelsConsonants {
    
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
    
    // Method to check if character is vowel or consonant
    // Returns: "Vowel", "Consonant", or "Not a Letter"
    public static String checkCharacterType(char ch) {
        // Convert to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);  // Convert uppercase to lowercase using ASCII
        }
        
        // Check if it's a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }
        
        // Check if it's a consonant
        if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        }
        
        // Not a letter
        return "Not a Letter";
    }
    
    // Method to find and count vowels and consonants
    public static int[] countVowelsConsonants(String str) {
        int[] result = new int[2]; // [vowels, consonants]
        int vowelCount = 0;
        int consonantCount = 0;
        
        int stringLength = findLength(str);
        
        for (int i = 0; i < stringLength; i++) {
            char ch = str.charAt(i);
            String charType = checkCharacterType(ch);
            
            if (charType.equals("Vowel")) {
                vowelCount++;
            } else if (charType.equals("Consonant")) {
                consonantCount++;
            }
        }
        
        result[0] = vowelCount;
        result[1] = consonantCount;
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        
        // Count vowels and consonants
        int[] counts = countVowelsConsonants(text);
        int vowels = counts[0];
        int consonants = counts[1];
        
        System.out.println("\n" + "=".repeat(40));
        System.out.println("String: " + text);
        System.out.println("=".repeat(40));
        System.out.println("Total Vowels: " + vowels);
        System.out.println("Total Consonants: " + consonants);
        System.out.println("=".repeat(40));
        
        // Display character-by-character breakdown
        System.out.println("\nCharacter Breakdown:");
        System.out.println(String.format("%-10s | %-15s", "Character", "Type"));
        System.out.println("-".repeat(40));
        
        int stringLength = findLength(text);
        for (int i = 0; i < stringLength; i++) {
            char ch = text.charAt(i);
            String charType = checkCharacterType(ch);
            if (!charType.equals("Not a Letter")) {
                System.out.println(String.format("%-10s | %-15s", ch, charType));
            }
        }
        
        sc.close();
    }
}
