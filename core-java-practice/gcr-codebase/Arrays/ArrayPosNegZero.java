import java.util.Scanner;

public class ArrayPosNegZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            System.out.print("Element " + i + " -> ");
            if (v > 0) {
                System.out.print("positive, ");
                if (v % 2 == 0) System.out.println("even");
                else System.out.println("odd");
            } else if (v < 0) {
                System.out.println("negative");
            } else {
                System.out.println("zero");
            }
        }

        int first = arr[0];
        int last = arr[arr.length - 1];
        if (first == last) {
            System.out.printf("First element (%d) is equal to last element (%d)%n", first, last);
        } else if (first > last) {
            System.out.printf("First element (%d) is greater than last element (%d)%n", first, last);
        } else {
            System.out.printf("First element (%d) is less than last element (%d)%n", first, last);
        }
        sc.close();
    }
}
