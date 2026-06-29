abstract class Vehicle {
    String vehicleNumber;
    String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public abstract double fuelCost(double km);
}

class Car extends Vehicle {
    public Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double fuelCost(double km) {
        return km * 15.0;
    }
}

class Bus extends Vehicle {
    public Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double fuelCost(double km) {
        return km * 10.0;
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double fuelCost(double km) {
        return km * 8.0;
    }
}

class ElectricCar extends Vehicle {
    public ElectricCar(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    @Override
    public double fuelCost(double km) {
        return km * 5.0;
    }
}

public class FleetFuelCostDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("C101", "Alice"),
            new Bus("B202", "Bob"),
            new Bike("M303", "Charlie"),
            new ElectricCar("E404", "Dana")
        };

        double distance = 120.0;
        for (Vehicle vehicle : fleet) {
            printFuelCost(vehicle, distance);
        }
    }

    private static void printFuelCost(Vehicle vehicle, double km) {
        if (vehicle instanceof ElectricCar) {
            ElectricCar electricCar = (ElectricCar) vehicle;
            System.out.printf("ElectricCar %s (%s) cost for %.1f km: %.2f%n",
                    electricCar.vehicleNumber,
                    electricCar.ownerName,
                    km,
                    electricCar.fuelCost(km));
        } else if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.printf("Car %s (%s) cost for %.1f km: %.2f%n",
                    car.vehicleNumber,
                    car.ownerName,
                    km,
                    car.fuelCost(km));
        } else if (vehicle instanceof Bus) {
            Bus bus = (Bus) vehicle;
            System.out.printf("Bus %s (%s) cost for %.1f km: %.2f%n",
                    bus.vehicleNumber,
                    bus.ownerName,
                    km,
                    bus.fuelCost(km));
        } else if (vehicle instanceof Bike) {
            Bike bike = (Bike) vehicle;
            System.out.printf("Bike %s (%s) cost for %.1f km: %.2f%n",
                    bike.vehicleNumber,
                    bike.ownerName,
                    km,
                    bike.fuelCost(km));
        } else {
            System.out.printf("Unknown vehicle type for %s%n", vehicle.vehicleNumber);
        }
    }
}
