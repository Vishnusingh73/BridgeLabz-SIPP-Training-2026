import java.util.Scanner;
public class IntOperation{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int a = sc.nextInt();
        System.out.print("Enter the second integer: ");
        int b = sc.nextInt();   
        System.out.print("Enter the third integer: ");
        int c = sc.nextInt();
        int d=a + b *c;
        int e= a * b + c;
        int f= c + a / b;
        int g= a % b + c;
        System.out.println("The result of a + b * c is: " + d); 
        System.out.println("The result of a * b + c is: " + e);
        System.out.println("The result of c + a / b is: " + f);
        System.out.println("The result of a % b + c is: " + g);

    }
}