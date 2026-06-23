import java.util.Scanner;
public class SumOfNatural{
     public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + recursiveSum(n - 1);
    }
       public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        
        if (n <= 0) {
            System.out.println("Please enter a valid natural number.");
            return;
        }

        int recursiveResult = recursiveSum(n);
        int formulaResult = formulaSum(n);

        System.out.println("Sum using Recursion = " + recursiveResult);
        System.out.println("Sum using Formula = " + formulaResult);

        if (recursiveResult == formulaResult) {
            System.out.println("Both results are correct and equal.");
        } else {
            System.out.println("Results are not equal.");
        }

        sc.close();
    }
}