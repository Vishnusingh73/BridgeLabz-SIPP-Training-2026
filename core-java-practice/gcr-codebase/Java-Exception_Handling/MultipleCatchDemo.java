import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;

        try {
            System.out.print("Enter array size (enter 0 for uninitialized array): ");
            int size = scanner.nextInt();
            if (size > 0) {
                arr = new int[size];
                System.out.println("Enter " + size + " integer values:");
                for (int i = 0; i < size; i++) {
                    arr[i] = scanner.nextInt();
                }
            }

            System.out.print("Enter index to retrieve: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}
