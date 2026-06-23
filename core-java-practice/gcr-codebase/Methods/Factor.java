import java.util.Scanner;

public class Factor{

    public static int[] findFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];

        // Second loop to store factors
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    public static int findSum(int[] factors) {
        int sum = 0;

        for (int factor : factors) {
            sum += factor;
        }

        return sum;
    }

    public static long findProduct(int[] factors) {
        long product = 1;

        for (int factor : factors) {
            product *= factor;
        }

        return product;
    }

    public static double findSumOfSquares(int[] factors) {
        double sumSquares = 0;

        for (int factor : factors) {
            sumSquares += Math.pow(factor, 2);
        }

        return sumSquares;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.println("\nFactors are:");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        System.out.println("\n\nSum of factors = " + findSum(factors));
        System.out.println("Product of factors = " + findProduct(factors));
        System.out.println("Sum of squares of factors = " + findSumOfSquares(factors));

        sc.close();
    }
}