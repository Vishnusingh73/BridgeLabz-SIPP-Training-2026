import java.util.*;

public class FirstNonRepeatingCharacter {
    
  
    public static char findFirstNonRepeatingCharacter(String text) {
        
        int[] frequency = new int[256];
        
       
        int textLength = getStringLength(text);
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
      
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }
        
       
        return '\0';
    }
    
   
    public static int getStringLength(String str) {
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
