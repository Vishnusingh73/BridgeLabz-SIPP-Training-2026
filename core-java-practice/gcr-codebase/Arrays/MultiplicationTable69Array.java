import java.util.Scanner;

public class MultiplicationTable69Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        int[] results = new int[4];
        int idx = 0;
        for (int i = 6; i <= 9; i++) {
            results[idx++] = number * i;
        }
        idx = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.printf("%d * %d = %d%n", number, i, results[idx++]);
        }
        sc.close();
    }
}
