abstract class TollVehicle {
    String vehicleNumber;
    String ownerName;

    public TollVehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public abstract double calculateToll();
}

class TollCar extends TollVehicle {
    public TollCar(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 50.0;
    }
}

class TollBus extends TollVehicle {
    public TollBus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 100.0;
    }
}

class TollTruck extends TollVehicle {
    public TollTruck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double calculateToll() {
        return 150.0;
    }
}

public class VehicleTollManagementSystem {
    public static void main(String[] args) {
        TollVehicle[] vehicles = {
            new TollCar("CAR123", "Ajay"),
            new TollBus("BUS456", "Ravi"),
            new TollTruck("TRK789", "Sunil"),
            new TollCar("CAR321", "Mira")
        };

        System.out.println("Total revenue: " + calculateTotalRevenue(vehicles));
        System.out.println("Highest toll payer: " + findHighestTollVehicle(vehicles));
        searchVehicle(vehicles, "BUS456");
        countVehiclesByType(vehicles);
    }

    private static double calculateTotalRevenue(TollVehicle[] vehicles) {
        double total = 0;
        for (TollVehicle vehicle : vehicles) {
            total += vehicle.calculateToll();
        }
        return total;
    }

    private static void searchVehicle(TollVehicle[] vehicles, String vehicleNumber) {
        for (TollVehicle vehicle : vehicles) {
            if (vehicle.vehicleNumber.equals(vehicleNumber)) {
                System.out.printf("Found %s owned by %s with toll %.2f%n",
                        vehicle.vehicleNumber,
                        vehicle.ownerName,
                        vehicle.calculateToll());
                return;
            }
        }
        System.out.println("Vehicle not found: " + vehicleNumber);
    }

    private static String findHighestTollVehicle(TollVehicle[] vehicles) {
        TollVehicle highest = null;
        for (TollVehicle vehicle : vehicles) {
            if (highest == null || vehicle.calculateToll() > highest.calculateToll()) {
                highest = vehicle;
            }
        }
        return highest == null ? "None" : highest.vehicleNumber + " (" + highest.ownerName + ")";
    }

    private static void countVehiclesByType(TollVehicle[] vehicles) {
        int cars = 0;
        int buses = 0;
        int trucks = 0;
        for (TollVehicle vehicle : vehicles) {
            if (vehicle instanceof TollCar) cars++;
            else if (vehicle instanceof TollBus) buses++;
            else if (vehicle instanceof TollTruck) trucks++;
        }
        System.out.println("Cars: " + cars + ", Buses: " + buses + ", Trucks: " + trucks);
    }
}
