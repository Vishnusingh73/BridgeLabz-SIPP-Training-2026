public class ThrowThrowsDemo {
    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 5, 3);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }

    public static double calculateInterest(double amount, double rate, int years) {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Negative amount or rate");
        }
        return amount * rate * years / 100;
    }
}
