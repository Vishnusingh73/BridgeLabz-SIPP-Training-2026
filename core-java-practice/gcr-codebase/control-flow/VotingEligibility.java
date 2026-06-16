import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        if (age >= 18) {
            System.out.printf("The person's age is %d and can vote.%n", age);
        } else {
            System.out.printf("The person's age is %d and cannot vote.%n", age);
        }
        sc.close();
    }
}
