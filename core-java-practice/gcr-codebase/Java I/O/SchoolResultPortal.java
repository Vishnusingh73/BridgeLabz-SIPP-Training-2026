import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class SchoolResultPortal {

    static class Student {
        String name;
        double marks;

        Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        String inputFile = "students.txt";
        String reportFile = "report-card.txt";
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("[,\\s]+", 2);
                if (parts.length == 2) {
                    try {
                        double marks = Double.parseDouble(parts[1].trim());
                        students.add(new Student(parts[0].trim(), marks));
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
            return;
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
            return;
        }

        if (students.isEmpty()) {
            System.out.println("No student data found in " + inputFile);
            return;
        }

        double sum = 0;
        for (Student student : students) {
            sum += student.marks;
        }
        double average = sum / students.size();

        try (PrintWriter writer = new PrintWriter(new FileWriter(reportFile, true))) {
            writer.println("Report Card");
            writer.println("----------------------");
            for (Student student : students) {
                writer.printf("Name: %s, Marks: %.2f%n", student.name, student.marks);
            }
            writer.printf("Average Marks: %.2f%n", average);
            writer.println();
        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
            return;
        }

        System.out.println("Report written to " + reportFile + " (appended)");
    }
}
