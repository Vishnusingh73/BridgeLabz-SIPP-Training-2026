interface Trackable {
    default void resetData() {
        System.out.println("Data has been reset.");
    }

    void logActivity();
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

public class FitnessDevice implements Trackable, Reportable, Notifiable {
    @Override
    public void logActivity() {
        System.out.println("Logging fitness activity.");
    }

    @Override
    public void generateReport() {
        System.out.println("Generating fitness report.");
    }

    @Override
    public void sendAlert() {
        System.out.println("Sending fitness alert.");
    }

    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice();
        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}
