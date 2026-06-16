import java.util.*;
public class Vote{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the age of 10 Students: ");
        int[] ages = new int[10];
        for(int i = 0; i < ages.length; i++){
            ages[i] = sc.nextInt();
        }
        for(int i = 0; i < ages.length; i++){
            if(ages[i] >= 18){
                System.out.printf("The student with the age %d can vote%n", ages[i]);
            } else {
                System.out.printf("The student with the age %d is not eligible to vote%n", ages[i]g);
            }
        }
    }
}