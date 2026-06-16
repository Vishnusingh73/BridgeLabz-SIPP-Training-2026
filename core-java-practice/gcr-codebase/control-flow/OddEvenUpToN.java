import java.util.Scanner;

public class OddEvenUpToN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();
        if (number >= 1) {
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.printf("%d is even number%n", i);
                } else {
                    System.out.printf("%d is odd number%n", i);
                }
            }
        } else {
            System.out.printf("The number %d is not a natural number%n", number);
        }
        sc.close();
    }
}
