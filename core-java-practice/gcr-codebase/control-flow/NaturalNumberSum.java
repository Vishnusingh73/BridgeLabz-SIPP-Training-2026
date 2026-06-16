import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        if (number >= 1) {
            int sum = number * (number + 1) / 2;
            System.out.printf("The sum of %d natural numbers is %d%n", number, sum);
        } else {
            System.out.printf("The number %d is not a natural number%n", number);
        }
        sc.close();
    }
}
