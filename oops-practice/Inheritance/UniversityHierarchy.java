class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class Student extends Person {
    private final String studentId;
    private double gpa;

    Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", studentId='" + studentId + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

class GradStudent extends Student {
    private String thesisTitle;

    GradStudent(String name, int age, String studentId, double gpa, String thesisTitle) {
        super(name, age, studentId, gpa);
        this.thesisTitle = thesisTitle;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return "GradStudent{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", studentId='" + getStudentId() + '\'' +
                ", gpa=" + getGpa() +
                ", thesisTitle='" + thesisTitle + '\'' +
                '}';
    }
}

public class UniversityHierarchy {
    public static void main(String[] args) {
        GradStudent gradStudent = new GradStudent("Amit", 26, "GS101", 9.1, "AI for Healthcare");

        System.out.println(gradStudent);
        System.out.println("Graduate student IS-A Student: " + (gradStudent instanceof Student));
        System.out.println("Graduate student IS-A Person: " + (gradStudent instanceof Person));
    }
}
