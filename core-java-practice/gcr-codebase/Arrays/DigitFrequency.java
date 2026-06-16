import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        String s = sc.next();
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                freq[c - '0']++;
            }
        }
        System.out.println("Digit frequencies:");
        for (int d = 0; d <= 9; d++) {
            System.out.printf("%d -> %d%n", d, freq[d]);
        }
        sc.close();
    }
}
