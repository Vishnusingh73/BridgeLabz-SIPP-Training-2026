import java.util.Scanner;
public class posneg{
    public static String checkNumber(int num) {
        if (num > 0) {
            return "Positive";
        } else if (num < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        posneg pn = new posneg();
        String result = pn.checkNumber(num);
        System.out.println("The number is: " + result);
    }
}