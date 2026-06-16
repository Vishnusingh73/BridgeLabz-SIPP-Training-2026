import java.util.Scanner;

public class NaturalSumCompareWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n >= 1) {
            int formulaSum = n * (n + 1) / 2;
            int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }
            System.out.printf("Formula sum: %d%n", formulaSum);
            System.out.printf("While loop sum: %d%n", loopSum);
            System.out.printf("Are the results equal? %b%n", formulaSum == loopSum);
        } else {
            System.out.printf("The number %d is not a natural number%n", n);
        }
        sc.close();
    }
}
