abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    abstract double calculateBill();

    void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;

    public double getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends Patient {
    private double consultationFee;
    private double treatmentCharges;

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    double calculateBill() {
        return consultationFee + treatmentCharges;
    }
}

public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient();
        inPatient.setPatientId("P1001");
        inPatient.setName("Sheetal Gupta");
        inPatient.setAge(45);
        inPatient.setRoomCharges(5000);
        inPatient.setTreatmentCharges(12000);

        OutPatient outPatient = new OutPatient();
        outPatient.setPatientId("P2001");
        outPatient.setName("Rohit Desai");
        outPatient.setAge(30);
        outPatient.setConsultationFee(800);
        outPatient.setTreatmentCharges(2500);

        System.out.println("In-Patient Details:");
        inPatient.displayPatientDetails();
        System.out.println("Bill Amount: " + inPatient.calculateBill() + "\n");

        System.out.println("Out-Patient Details:");
        outPatient.displayPatientDetails();
        System.out.println("Bill Amount: " + outPatient.calculateBill());
    }
}
