import java.util.Scanner;
public class SimpleIntrest{
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
            System.out.print("Enter the principal amount: ");
            double principal = sc.nextDouble(); 
            System.out.print("Enter the rate of interest: ");
            double rate = sc.nextDouble();
            System.out.print("Enter the time in years: ");
            double time = sc.nextDouble();
            SimpleIntrest si = new SimpleIntrest();
            double interest = si.calculateSimpleInterest(principal, rate, time);
            System.out.println("Simple Interest: " + interest);
        
    }
}