import java.util.Scanner;

public class StoreUpTo10OrUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        int idx = 0;
        System.out.println("Enter numbers (enter 0 or negative to stop, max 10):");
        while (true) {
            if (idx >= arr.length) break;
            double v = sc.nextDouble();
            if (v <= 0) break;
            arr[idx++] = v;
        }
        double total = 0.0;
        System.out.println("Stored values:");
        for (int i = 0; i < idx; i++) {
            System.out.println(arr[i]);
            total += arr[i];
        }
        System.out.printf("Sum of stored values: %.2f%n", total);
        sc.close();
    }
}
