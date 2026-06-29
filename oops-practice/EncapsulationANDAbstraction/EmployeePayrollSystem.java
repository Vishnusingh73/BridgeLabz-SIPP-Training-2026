abstract class Employee {
    private int employeeId;
    private String employeeName;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    abstract double calculateSalary();

    void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        FullTimeEmployee fullTime = new FullTimeEmployee();
        fullTime.setEmployeeId(101);
        fullTime.setEmployeeName("Anita Sharma");
        fullTime.setMonthlySalary(40000.0);

        PartTimeEmployee partTime = new PartTimeEmployee();
        partTime.setEmployeeId(201);
        partTime.setEmployeeName("Ravi Kumar");
        partTime.setHoursWorked(80);
        partTime.setHourlyRate(300.0);

        System.out.println("Full Time Employee");
        fullTime.displayEmployeeInfo();
        System.out.println("Salary: " + fullTime.calculateSalary());
        System.out.println();

        System.out.println("Part Time Employee");
        partTime.displayEmployeeInfo();
        System.out.println("Salary: " + partTime.calculateSalary());
    }
}
