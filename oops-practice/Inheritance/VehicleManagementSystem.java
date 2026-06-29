interface Refuelable {
    void refuel();
}

class Vehicle {
    private String maxSpeed;
    private String model;

    public Vehicle(String maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed);
    }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println(getModel() + " is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is refueling.");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle("180 km/h", "EV-X");
        PetrolVehicle petrolVehicle = new PetrolVehicle("200 km/h", "PV-Z");

        electricVehicle.displayDetails();
        electricVehicle.charge();
        System.out.println();

        petrolVehicle.displayDetails();
        petrolVehicle.refuel();
    }
}
