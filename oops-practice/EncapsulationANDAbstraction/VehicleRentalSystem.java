abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    abstract double calculateRentalCost(int days);

    void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

class Car extends Vehicle {
    private double dailyRate;

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getLoadingCharge() {
        return loadingCharge;
    }

    public void setLoadingCharge(double loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    @Override
    double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Car car = new Car();
        car.setVehicleNumber("CAR123");
        car.setVehicleType("Car");
        car.setDailyRate(2500);

        Bike bike = new Bike();
        bike.setVehicleNumber("BIKE456");
        bike.setVehicleType("Bike");
        bike.setDailyRate(800);

        Truck truck = new Truck();
        truck.setVehicleNumber("TRK789");
        truck.setVehicleType("Truck");
        truck.setDailyRate(4500);
        truck.setLoadingCharge(1200);

        int rentalDays = 3;

        System.out.println("Car Rental");
        car.displayVehicleDetails();
        System.out.println("Rental Cost for " + rentalDays + " days: " + car.calculateRentalCost(rentalDays));
        System.out.println();

        System.out.println("Bike Rental");
        bike.displayVehicleDetails();
        System.out.println("Rental Cost for " + rentalDays + " days: " + bike.calculateRentalCost(rentalDays));
        System.out.println();

        System.out.println("Truck Rental");
        truck.displayVehicleDetails();
        System.out.println("Rental Cost for " + rentalDays + " days: " + truck.calculateRentalCost(rentalDays));
    }
}
