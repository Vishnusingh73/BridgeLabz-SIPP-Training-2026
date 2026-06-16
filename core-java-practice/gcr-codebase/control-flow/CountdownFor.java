gimport java.util.Scanner;

public class CountdownFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter countdown start value: ");
        int number = sc.nextInt();
        for (int i = number; i >= 1; i--) {
            System.out.println(i);
        }
        sc.close();
    }
}
