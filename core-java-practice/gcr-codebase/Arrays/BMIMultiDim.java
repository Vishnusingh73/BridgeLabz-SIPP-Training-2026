import java.util.Scanner;

public class BMIMultiDim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[][] personData = new double[n][3]; // [weight, height, bmi]
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            double w;
            do {
                System.out.printf("Person %d - Enter weight in kg (positive): ", i + 1);
                w = sc.nextDouble();
            } while (w <= 0);
            personData[i][0] = w;

            double h;
            do {
                System.out.printf("Person %d - Enter height in meters (positive): ", i + 1);
                h = sc.nextDouble();
            } while (h <= 0);
            personData[i][1] = h;

            double b = personData[i][0] / (personData[i][1] * personData[i][1]);
            personData[i][2] = b;

            if (b < 18.5) weightStatus[i] = "Underweight";
            else if (b < 25.0) weightStatus[i] = "Normal weight";
            else if (b < 30.0) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d: Height=%.2f m, Weight=%.2f kg, BMI=%.2f, Status=%s%n",
                    i + 1, personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
        sc.close();
    }
}
