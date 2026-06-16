import java.util.Scanner;

public class DivisibleBy5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        boolean divisible = number % 5 == 0;
        System.out.printf("Is the number %d divisible by 5? %b%n", number, divisible);
        sc.close();
    }
}
