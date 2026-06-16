import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] marks = new int[n][3]; // 0: Physics, 1: Chemistry, 2: Maths
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d - Enter marks for Physics (0-100): ", i + 1);
            int p = sc.nextInt();
            if (p < 0) { i--; continue; }
            marks[i][0] = p;

            System.out.printf("Student %d - Enter marks for Chemistry (0-100): ", i + 1);
            int c = sc.nextInt();
            if (c < 0) { i--; continue; }
            marks[i][1] = c;

            System.out.printf("Student %d - Enter marks for Maths (0-100): ", i + 1);
            int m = sc.nextInt();
            if (m < 0) { i--; continue; }
            marks[i][2] = m;

            double perc = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            percentage[i] = perc;
            if (perc >= 90) grade[i] = "A";
            else if (perc >= 80) grade[i] = "B";
            else if (perc >= 70) grade[i] = "C";
            else if (perc >= 60) grade[i] = "D";
            else grade[i] = "F";
        }

        System.out.println("\nResults:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d - Physics=%d, Chemistry=%d, Maths=%d, Percentage=%.2f, Grade=%s%n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }
        sc.close();
    }
}
