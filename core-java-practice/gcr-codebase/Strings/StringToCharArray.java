import java.util.*;

public class StringToCharArray {
    
    // Method to return all characters in a string using user-defined approach
    public static char[] getCharArrayCustom(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }
    
    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the text:");
        String text = sc.next();
        
        // Get characters using user-defined method
        char[] customCharArray = getCharArrayCustom(text);
        
        // Get characters using built-in toCharArray() method
        char[] builtInCharArray = text.toCharArray();
        
        System.out.println("\nUser-defined method result:");
        System.out.print("[ ");
        for (char c : customCharArray) {
            System.out.print(c + " ");
        }
        System.out.println("]");
        
        System.out.println("\nBuilt-in toCharArray() result:");
        System.out.print("[ ");
        for (char c : builtInCharArray) {
            System.out.print(c + " ");
        }
        System.out.println("]");
        
        // Compare the two arrays
        boolean isEqual = compareCharArrays(customCharArray, builtInCharArray);
        
        System.out.println("\nComparison Result: " + (isEqual ? "Both arrays are equal" : "Arrays are not equal"));
        
        sc.close();
    }
}
