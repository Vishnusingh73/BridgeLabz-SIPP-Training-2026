class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
}

public class ParkingManagementSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Vehicle("KA01AB1234", "Ravi", "Car"),
            new Vehicle("KA01CD5678", "Asha", "Bike"),
            new Vehicle("KA02EF9012", "Mira", "Car"),
            new Vehicle("KA03GH3456", "Nikhil", "Bike"),
            new Vehicle("KA04IJ7890", "Sara", "Car"),
            new Vehicle("KA05KL1234", "Vikram", "Bike"),
            new Vehicle("KA06MN5678", "Sunita", "Car"),
            new Vehicle("KA07OP9012", "Rohan", "Bike"),
            new Vehicle("KA08QR3456", "Pooja", "Car"),
            new Vehicle("KA09ST7890", "Gita", "Bike")
        };

        displayCars(vehicles);
        displayBikes(vehicles);
    }

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars in parking:");
        for (Vehicle vehicle : vehicles) {
            if ("Car".equalsIgnoreCase(vehicle.vehicleType)) {
                System.out.println(vehicle.vehicleNumber + " - " + vehicle.ownerName);
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("Bikes in parking:");
        for (Vehicle vehicle : vehicles) {
            if ("Bike".equalsIgnoreCase(vehicle.vehicleType)) {
                System.out.println(vehicle.vehicleNumber + " - " + vehicle.ownerName);
            }
        }
    }
}
