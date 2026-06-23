import java.util.*;

public class CharacterFrequency {
    
    
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
    
    
    public static String[][] findCharacterFrequency(String text) {
       
        int[] frequency = new int[256];
        int textLength = getStringLength(text);
       
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }
        
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            
            
            boolean alreadyAdded = false;
            for (int j = 0; j < index; j++) {
                if (result[j][0].charAt(0) == ch) {
                    alreadyAdded = true;
                    break;
                }
            }
            
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
