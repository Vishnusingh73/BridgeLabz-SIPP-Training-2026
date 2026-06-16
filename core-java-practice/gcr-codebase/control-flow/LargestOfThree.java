import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();
        boolean firstLargest = number1 > number2 && number1 > number3;
        boolean secondLargest = number2 > number1 && number2 > number3;
        boolean thirdLargest = number3 > number1 && number3 > number2;
        System.out.printf("Is the first number the largest? %b%n", firstLargest);
        System.out.printf("Is the second number the largest? %b%n", secondLargest);
        System.out.printf("Is the third number the largest? %b%n", thirdLargest);
        sc.close();
    }
}
