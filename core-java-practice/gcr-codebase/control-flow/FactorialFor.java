import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        if (n >= 1) {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.printf("Factorial of %d is %d%n", n, factorial);
        } else {
            System.out.printf("The number %d is not a positive integer for factorial%n", n);
        }
        sc.close();
    }
}
