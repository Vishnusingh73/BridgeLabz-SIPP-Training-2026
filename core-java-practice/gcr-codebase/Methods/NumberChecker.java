import java.util.Scanner;

class NumberChecker {

  
    public static int countDigits(int number) {
        int count = 0;
        int temp = Math.abs(number);

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        return count == 0 ? 1 : count;
    }

    public static int[] getDigitsArray(int number) {

        int count = countDigits(number);
        int[] digits = new int[count];

        int temp = Math.abs(number);

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {

        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {

        int power = digits.length;
        int sum = 0;

        for (int digit : digits) {
            sum += (int) Math.pow(digit, power);
        }

        return sum == number;
    }

   
    public static void findLargestAndSecondLargest(int[] digits) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {

            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);
    }

    
    public static void findSmallestAndSecondSmallest(int[] digits) {

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {

            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        System.out.println("Smallest Digit = " + smallest);
        System.out.println("Second Smallest Digit = " + secondSmallest);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = NumberChecker.countDigits(number);
        int[] digits = NumberChecker.getDigitsArray(number);

        System.out.println("\nCount of Digits = " + digitCount);

        System.out.print("Digits Array = ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }

        System.out.println();

        if (NumberChecker.isDuckNumber(digits)) {
            System.out.println("Duck Number : Yes");
        } else {
            System.out.println("Duck Number : No");
        }

        if (NumberChecker.isArmstrong(number, digits)) {
            System.out.println("Armstrong Number : Yes");
        } else {
            System.out.println("Armstrong Number : No");
        }

        NumberChecker.findLargestAndSecondLargest(digits);
        NumberChecker.findSmallestAndSecondSmallest(digits);

        sc.close();
    }
}