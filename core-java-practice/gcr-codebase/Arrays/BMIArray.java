import java.util.Scanner;

public class BMIArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            double w;
            do {
                System.out.printf("Person %d - Enter weight in kg (positive): ", i + 1);
                w = sc.nextDouble();
            } while (w <= 0);
            weight[i] = w;

            double h;
            do {
                System.out.printf("Person %d - Enter height in meters (positive): ", i + 1);
                h = sc.nextDouble();
            } while (h <= 0);
            height[i] = h;

            bmi[i] = weight[i] / (height[i] * height[i]);
            double b = bmi[i];
            if (b < 18.5) status[i] = "Underweight";
            else if (b < 25.0) status[i] = "Normal weight";
            else if (b < 30.0) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: Height=%.2f m, Weight=%.2f kg, BMI=%.2f, Status=%s%n",
                    i + 1, height[i], weight[i], bmi[i], status[i]);
        }
        sc.close();
    }
}
