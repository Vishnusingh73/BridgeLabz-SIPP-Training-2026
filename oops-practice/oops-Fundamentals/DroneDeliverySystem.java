public class Drone {
    String droneId;
    int batteryPercentage;
    static String companyName = "SkyLogistics";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (batteryPercentage > 20) {
            System.out.println(droneId + " started delivery.");
        } else {
            System.out.println(droneId + " cannot start delivery due to low battery.");
        }
    }

    public void displayStatus() {
        System.out.println("Drone: " + droneId + ", Battery: " + batteryPercentage + "%, Company: " + companyName);
    }
}

public class DroneDeliverySystem {
    public static void main(String[] args) {
        Drone[] drones = {
            new Drone("D001", 85),
            new Drone("D002", 40),
            new Drone("D003", 15)
        };

        for (Drone drone : drones) {
            drone.displayStatus();
            drone.startDelivery();
            System.out.println();
        }

        System.out.println("All drones share company name: " + Drone.companyName);
    }
}
