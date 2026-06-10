import java.util.Scanner;

public class FeeDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the course fee: ");
        double fee = input.nextDouble();

        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();

        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;

        System.out.println("Discount Amount = " + discount);
        System.out.println("Fee to Pay = " + finalFee);

        input.close();
    }
}