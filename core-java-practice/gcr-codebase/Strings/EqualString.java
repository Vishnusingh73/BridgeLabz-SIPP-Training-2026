import java.util.*;

public class EqualString {
    
    
    public static String createSubstringUsingCharAt(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < str.length(); i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
    
   
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the String:");
        String text = sc.next();
        
        System.out.println("Enter the start index:");
        int startIndex = sc.nextInt();
        
        System.out.println("Enter the end index:");
        int endIndex = sc.nextInt();
        
       
        String substringCharAt = createSubstringUsingCharAt(text, startIndex, endIndex);
        
       
        String substringBuiltIn = text.substring(startIndex, endIndex);
        
        System.out.println("\nSubstring using charAt(): " + substringCharAt);
        System.out.println("Substring using built-in substring(): " + substringBuiltIn);
        
       
        boolean isEqual = compareStringsUsingCharAt(substringCharAt, substringBuiltIn);
        
        System.out.println("\nComparison Result: " + (isEqual ? "Both substrings are equal" : "Substrings are not equal"));
        
        sc.close();
    }
}
