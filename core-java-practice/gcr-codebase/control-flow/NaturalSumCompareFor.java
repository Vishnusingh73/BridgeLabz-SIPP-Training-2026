import java.util.Scanner;

public class NaturalSumCompareFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n >= 1) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }
            System.out.printf("Formula sum: %d%n", formulaSum);
            System.out.printf("For loop sum: %d%n", loopSum);
            System.out.printf("Are the results equal? %b%n", formulaSum == loopSum);
        } else {
            System.out.printf("The number %d is not a natural number%n", n);
        }
        sc.close();
    }
}
