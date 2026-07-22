import java.util.*;

/**
 * Smart Parking Slot Manager
 * Manages vehicle parking in a shopping mall using ArrayList
 * Allows vehicles to enter, exit, search, and display all parked vehicles
 */
public class SmartParkingSlotManager {
    
    private ArrayList<String> parkedVehicles;
    
    public SmartParkingSlotManager() {
        this.parkedVehicles = new ArrayList<>();
    }
    
    /**
     * Add a vehicle to the parking area
     * @param registrationNumber Vehicle registration number
     * @return true if vehicle entered successfully, false if already parked
     */
    public boolean addVehicle(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            System.out.println("Error: Registration number cannot be empty!");
            return false;
        }
        
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println("Error: Vehicle " + registrationNumber + " is already parked!");
            return false;
        }
        
        parkedVehicles.add(registrationNumber);
        System.out.println("✓ Vehicle " + registrationNumber + " has entered the parking area.");
        return true;
    }
    
    /**
     * Remove a vehicle from the parking area
     * @param registrationNumber Vehicle registration number
     * @return true if vehicle exited successfully, false if not found
     */
    public boolean removeVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            parkedVehicles.remove(registrationNumber);
            System.out.println("✓ Vehicle " + registrationNumber + " has exited the parking area.");
            return true;
        } else {
            System.out.println("Error: Vehicle " + registrationNumber + " is not parked here!");
            return false;
        }
    }
    
    /**
     * Search for a vehicle in the parking area
     * @param registrationNumber Vehicle registration number
     * @return true if vehicle is parked, false otherwise
     */
    public boolean searchVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println("✓ Vehicle " + registrationNumber + " is currently parked.");
            return true;
        } else {
            System.out.println("✗ Vehicle " + registrationNumber + " is NOT parked.");
            return false;
        }
    }
    
    /**
     * Display all parked vehicles
     */
    public void displayAllVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("\n========== Parking Status ==========");
            System.out.println("No vehicles currently parked.");
            System.out.println("Total occupied slots: 0");
            System.out.println("====================================\n");
            return;
        }
        
        System.out.println("\n========== Currently Parked Vehicles ==========");
        for (int i = 0; i < parkedVehicles.size(); i++) {
            System.out.println((i + 1) + ". " + parkedVehicles.get(i));
        }
        System.out.println("\nTotal occupied parking slots: " + parkedVehicles.size());
        System.out.println("==============================================\n");
    }
    
    /**
     * Get total number of parked vehicles
     */
    public int getTotalParkedVehicles() {
        return parkedVehicles.size();
    }
    
    /**
     * Get the list of all parked vehicles
     */
    public ArrayList<String> getParkedVehiclesList() {
        return new ArrayList<>(parkedVehicles);
    }
    
    public static void main(String[] args) {
        SmartParkingSlotManager parkingManager = new SmartParkingSlotManager();
        
        System.out.println("========== Smart Parking Slot Manager ==========\n");
        
        // Vehicles entering the parking area
        System.out.println("--- Vehicles Entering ---");
        parkingManager.addVehicle("KA-01-AB-1234");
        parkingManager.addVehicle("KA-02-CD-5678");
        parkingManager.addVehicle("MH-03-EF-9012");
        parkingManager.addVehicle("DL-04-GH-3456");
        parkingManager.addVehicle("TN-05-IJ-7890");
        
        // Try to add duplicate vehicle
        System.out.println();
        parkingManager.addVehicle("KA-01-AB-1234");
        
        // Display all parked vehicles
        System.out.println();
        parkingManager.displayAllVehicles();
        
        // Search for vehicles
        System.out.println("--- Searching for Vehicles ---");
        parkingManager.searchVehicle("KA-02-CD-5678");
        System.out.println();
        parkingManager.searchVehicle("KA-99-ZZ-9999");
        System.out.println();
        
        // Vehicle exits the parking area
        System.out.println("--- Vehicles Exiting ---");
        parkingManager.removeVehicle("KA-01-AB-1234");
        System.out.println();
        parkingManager.removeVehicle("DL-04-GH-3456");
        
        // Display updated parking status
        System.out.println();
        parkingManager.displayAllVehicles();
        
        // Try to remove non-existent vehicle
        System.out.println("--- Attempt to Remove Non-existent Vehicle ---");
        parkingManager.removeVehicle("KA-99-ZZ-9999");
        System.out.println();
        
        // Final parking status
        parkingManager.displayAllVehicles();
        
        System.out.println("Final total occupied parking slots: " + parkingManager.getTotalParkedVehicles());
    }
}
