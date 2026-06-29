interface HeartRateMonitor {
    boolean monitorHeartRate(String patientId, int heartRate);

    default void displayHealthTips() {
        System.out.println("Maintain a healthy heart with regular exercise and a balanced diet.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.matches("PAT[0-9]{3}");
    }
}

interface TemperatureMonitor {
    boolean monitorTemperature(String patientId, double temperature);

    default void displayHealthTips() {
        System.out.println("Stay hydrated and keep your body temperature stable.");
    }
}

public class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {
    @Override
    public boolean monitorHeartRate(String patientId, int heartRate) {
        return HeartRateMonitor.isPatientIdValid(patientId) && heartRate >= 60 && heartRate <= 100;
    }

    @Override
    public boolean monitorTemperature(String patientId, double temperature) {
        return HeartRateMonitor.isPatientIdValid(patientId) && temperature >= 36.5 && temperature <= 37.5;
    }

    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public static void main(String[] args) {
        String[] patientNames = {"Raj", "Maya", "Neha"};
        String[] patientIds = {"PAT101", "INVALID", "PAT303"};
        int[] heartRates = {72, 55, 88};
        double[] temperatures = {37.0, 38.5, 36.8};

        HealthMonitoringSystem system = new HealthMonitoringSystem();
        system.displayHealthTips();
        System.out.println();

        for (int i = 0; i < patientNames.length; i++) {
            String name = patientNames[i];
            String id = patientIds[i];
            boolean validId = HeartRateMonitor.isPatientIdValid(id);
            boolean heartOk = system.monitorHeartRate(id, heartRates[i]);
            boolean tempOk = system.monitorTemperature(id, temperatures[i]);
            System.out.printf("Patient: %s, ID valid: %b, Heart OK: %b, Temp OK: %b%n",
                    name, validId, heartOk, tempOk);
            if (validId && heartOk && tempOk) {
                System.out.println("Final health report: all readings are normal.");
            } else if (!validId) {
                System.out.println("Final health report: invalid patient ID.");
            } else {
                System.out.println("Final health report: follow up required.");
            }
            System.out.println();
        }
    }
}
