import java.util.*;

/**
 * Smart Classroom Attendance Tracker
 * Uses HashMap<String, ArrayList<String>> to track students present in each subject
 * Prevents duplicate attendance entries for the same student in a subject
 */
public class SmartClassroomAttendanceTracker {
    
    private HashMap<String, ArrayList<String>> attendanceRecords;
    
    public SmartClassroomAttendanceTracker() {
        this.attendanceRecords = new HashMap<>();
    }
    
    /**
     * Mark attendance for a student in a subject
     * @param subjectName Name of the subject
     * @param studentName Name of the student
     * @return true if attendance marked successfully, false if already marked
     */
    public boolean markAttendance(String subjectName, String studentName) {
        if (subjectName == null || subjectName.trim().isEmpty() || 
            studentName == null || studentName.trim().isEmpty()) {
            System.out.println("Error: Subject name and student name cannot be empty!");
            return false;
        }
        
        // Create subject list if it doesn't exist
        attendanceRecords.putIfAbsent(subjectName, new ArrayList<>());
        
        ArrayList<String> students = attendanceRecords.get(subjectName);
        
        // Check if student is already marked present
        if (students.contains(studentName)) {
            System.out.println("✗ Error: " + studentName + " is already marked present in " + subjectName);
            return false;
        }
        
        // Add student to attendance
        students.add(studentName);
        System.out.println("✓ Attendance marked: " + studentName + " in " + subjectName);
        return true;
    }
    
    /**
     * Remove attendance for a student from a subject
     * @param subjectName Name of the subject
     * @param studentName Name of the student
     * @return true if removed successfully, false if not found
     */
    public boolean removeAttendance(String subjectName, String studentName) {
        if (!attendanceRecords.containsKey(subjectName)) {
            System.out.println("✗ Subject '" + subjectName + "' not found!");
            return false;
        }
        
        ArrayList<String> students = attendanceRecords.get(subjectName);
        if (students.remove(studentName)) {
            System.out.println("✓ Removed: " + studentName + " from " + subjectName);
            return true;
        } else {
            System.out.println("✗ " + studentName + " was not marked present in " + subjectName);
            return false;
        }
    }
    
    /**
     * Check if a student is marked present in a subject
     * @param subjectName Name of the subject
     * @param studentName Name of the student
     * @return true if present, false otherwise
     */
    public boolean isStudentPresent(String subjectName, String studentName) {
        if (!attendanceRecords.containsKey(subjectName)) {
            return false;
        }
        return attendanceRecords.get(subjectName).contains(studentName);
    }
    
    /**
     * Display attendance list for a specific subject
     * @param subjectName Name of the subject
     */
    public void displayAttendanceForSubject(String subjectName) {
        if (!attendanceRecords.containsKey(subjectName)) {
            System.out.println("\n========== Attendance for " + subjectName + " ==========");
            System.out.println("Subject not found or no students present.");
            System.out.println("=====================================================\n");
            return;
        }
        
        ArrayList<String> students = attendanceRecords.get(subjectName);
        System.out.println("\n========== Attendance for " + subjectName + " ==========");
        
        if (students.isEmpty()) {
            System.out.println("No students marked present.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }
        }
        System.out.println("\nTotal students present: " + students.size());
        System.out.println("=====================================================\n");
    }
    
    /**
     * Display attendance for all subjects
     */
    public void displayAllAttendance() {
        if (attendanceRecords.isEmpty()) {
            System.out.println("\n========== Overall Attendance ==========");
            System.out.println("No attendance records found.");
            System.out.println("=======================================\n");
            return;
        }
        
        System.out.println("\n========== Overall Attendance Report ==========");
        for (String subject : attendanceRecords.keySet()) {
            ArrayList<String> students = attendanceRecords.get(subject);
            System.out.println("\n" + subject + " (" + students.size() + " students):");
            for (String student : students) {
                System.out.println("  - " + student);
            }
        }
        System.out.println("\n===============================================\n");
    }
    
    /**
     * Get total students present in a subject
     * @param subjectName Name of the subject
     * @return number of students present
     */
    public int getTotalStudentsInSubject(String subjectName) {
        if (attendanceRecords.containsKey(subjectName)) {
            return attendanceRecords.get(subjectName).size();
        }
        return 0;
    }
    
    /**
     * Display total students present in every subject
     */
    public void displayTotalStudentsPerSubject() {
        if (attendanceRecords.isEmpty()) {
            System.out.println("\n========== Students Per Subject ==========");
            System.out.println("No subjects found.");
            System.out.println("=========================================\n");
            return;
        }
        
        System.out.println("\n========== Students Present Per Subject ==========");
        int totalAllSubjects = 0;
        
        for (String subject : attendanceRecords.keySet()) {
            int count = attendanceRecords.get(subject).size();
            System.out.println(subject + ": " + count + " students");
            totalAllSubjects += count;
        }
        
        System.out.println("\nTotal student-subject attendance records: " + totalAllSubjects);
        System.out.println("Total unique subjects: " + attendanceRecords.size());
        System.out.println("==================================================\n");
    }
    
    /**
     * Get list of all subjects
     */
    public Set<String> getAllSubjects() {
        return attendanceRecords.keySet();
    }
    
    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();
        
        System.out.println("========== Smart Classroom Attendance Tracker ==========\n");
        
        // Mark attendance for Java subject
        System.out.println("--- Marking Attendance for Java ---");
        tracker.markAttendance("Java", "Raj Kumar");
        tracker.markAttendance("Java", "Priya Singh");
        tracker.markAttendance("Java", "Amit Patel");
        tracker.markAttendance("Java", "Neha Verma");
        
        // Try duplicate attendance
        System.out.println();
        tracker.markAttendance("Java", "Raj Kumar");
        
        // Mark attendance for Python subject
        System.out.println("\n--- Marking Attendance for Python ---");
        tracker.markAttendance("Python", "Priya Singh");
        tracker.markAttendance("Python", "Sanjay Kumar");
        tracker.markAttendance("Python", "Anjali Sharma");
        
        // Mark attendance for DSA subject
        System.out.println("\n--- Marking Attendance for DSA ---");
        tracker.markAttendance("DSA", "Amit Patel");
        tracker.markAttendance("DSA", "Sanjay Kumar");
        tracker.markAttendance("DSA", "Raj Kumar");
        tracker.markAttendance("DSA", "Vikram Singh");
        
        // Display attendance for specific subjects
        System.out.println("\n--- Displaying Subject-wise Attendance ---");
        tracker.displayAttendanceForSubject("Java");
        tracker.displayAttendanceForSubject("Python");
        tracker.displayAttendanceForSubject("DSA");
        
        // Check if student is present in a subject
        System.out.println("--- Checking Student Attendance ---");
        if (tracker.isStudentPresent("Java", "Raj Kumar")) {
            System.out.println("✓ Raj Kumar is present in Java");
        }
        System.out.println();
        
        if (tracker.isStudentPresent("Python", "Raj Kumar")) {
            System.out.println("✓ Raj Kumar is present in Python");
        } else {
            System.out.println("✗ Raj Kumar is NOT present in Python");
        }
        System.out.println();
        
        // Display all attendance
        System.out.println("--- Overall Attendance Report ---");
        tracker.displayAllAttendance();
        
        // Display total students per subject
        System.out.println("--- Total Students Per Subject ---");
        tracker.displayTotalStudentsPerSubject();
        
        // Remove attendance
        System.out.println("--- Removing Attendance ---");
        tracker.removeAttendance("Python", "Priya Singh");
        System.out.println();
        tracker.removeAttendance("Java", "Raj Kumar");
        System.out.println();
        
        // Display updated totals
        System.out.println("--- Updated Total Students Per Subject ---");
        tracker.displayTotalStudentsPerSubject();
    }
}
