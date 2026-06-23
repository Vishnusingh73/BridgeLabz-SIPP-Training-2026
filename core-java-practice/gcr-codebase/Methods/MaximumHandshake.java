import java.util.Scanner;
public class MaximumHandshake{
    public static int handshake(int n) {
        return (n * (n - 1)) / 2;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        int n = sc.nextInt();
        MaximumHandshake mh = new MaximumHandshake();
        int handshakes = mh.handshake(n);   
        System.out.println("Maximum Handshakes: " + handshakes);
    }
}