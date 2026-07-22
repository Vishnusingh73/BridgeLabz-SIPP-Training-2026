import java.util.*;

/**
 * Smart City Traffic Monitoring System
 * Monitors vehicle counts across different roads
 * Uses HashMap for storage and TreeMap for sorted display
 * Identifies busiest roads and generates traffic analysis reports
 */
public class SmartCityTrafficMonitoringSystem {
    
    private HashMap<String, Integer> trafficData;
    
    public SmartCityTrafficMonitoringSystem() {
        this.trafficData = new HashMap<>();
    }
    
    /**
     * Add or update vehicle count for a road
     * @param roadName Name of the road
     * @param vehicleCount Number of vehicles
     */
    public void addOrUpdateRoadTraffic(String roadName, int vehicleCount) {
        if (roadName == null || roadName.trim().isEmpty()) {
            System.out.println("Error: Road name cannot be empty!");
            return;
        }
        
        if (vehicleCount < 0) {
            System.out.println("Error: Vehicle count cannot be negative!");
            return;
        }
        
        trafficData.put(roadName, vehicleCount);
        System.out.println("✓ Updated: " + roadName + " → " + vehicleCount + " vehicles");
    }
    
    /**
     * Update traffic count for a road (increment by specified amount)
     * @param roadName Name of the road
     * @param additionalVehicles Number of vehicles to add
     */
    public void updateTrafficCount(String roadName, int additionalVehicles) {
        if (!trafficData.containsKey(roadName)) {
            System.out.println("✗ Road '" + roadName + "' not found!");
            return;
        }
        
        int currentCount = trafficData.get(roadName);
        int newCount = currentCount + additionalVehicles;
        trafficData.put(roadName, newCount);
        System.out.println("✓ Updated: " + roadName + " → " + newCount + " vehicles (added " + additionalVehicles + ")");
    }
    
    /**
     * Get vehicle count for a specific road
     * @param roadName Name of the road
     * @return vehicle count or -1 if not found
     */
    public int getVehicleCountForRoad(String roadName) {
        return trafficData.getOrDefault(roadName, -1);
    }
    
    /**
     * Find and display the busiest road
     */
    public void displayBusiestRoad() {
        if (trafficData.isEmpty()) {
            System.out.println("\n========== Busiest Road ==========");
            System.out.println("No traffic data available.");
            System.out.println("=================================\n");
            return;
        }
        
        String busiestRoad = null;
        int maxVehicles = 0;
        
        for (String road : trafficData.keySet()) {
            int vehicles = trafficData.get(road);
            if (vehicles > maxVehicles) {
                maxVehicles = vehicles;
                busiestRoad = road;
            }
        }
        
        System.out.println("\n========== Busiest Road ==========");
        System.out.println("Road Name: " + busiestRoad);
        System.out.println("Vehicle Count: " + maxVehicles);
        System.out.println("Status: CONGESTED ⚠️");
        System.out.println("=================================\n");
    }
    
    /**
     * Display all roads and their vehicle counts in sorted order
     */
    public void displayAllRoadsSorted() {
        if (trafficData.isEmpty()) {
            System.out.println("\n========== Traffic Report (Sorted) ==========");
            System.out.println("No traffic data available.");
            System.out.println("===========================================\n");
            return;
        }
        
        // Use TreeMap for sorted display
        TreeMap<String, Integer> sortedMap = new TreeMap<>(trafficData);
        
        System.out.println("\n========== All Roads (Sorted by Name) ==========");
        int roadNumber = 1;
        for (String road : sortedMap.keySet()) {
            int vehicles = sortedMap.get(road);
            String status = getTrafficStatus(vehicles);
            System.out.println(roadNumber + ". " + road + " → " + vehicles + " vehicles [" + status + "]");
            roadNumber++;
        }
        System.out.println("\nTotal roads monitored: " + sortedMap.size());
        System.out.println("===============================================\n");
    }
    
    /**
     * Get traffic status based on vehicle count
     * @param vehicleCount Number of vehicles
     * @return Traffic status string
     */
    private String getTrafficStatus(int vehicleCount) {
        if (vehicleCount < 50) {
            return "Light";
        } else if (vehicleCount < 100) {
            return "Moderate";
        } else if (vehicleCount < 150) {
            return "Heavy";
        } else {
            return "Congested";
        }
    }
    
    /**
     * Generate comprehensive traffic analysis report
     */
    public void generateTrafficAnalysisReport() {
        if (trafficData.isEmpty()) {
            System.out.println("\n========== Traffic Analysis Report ==========");
            System.out.println("No traffic data available.");
            System.out.println("============================================\n");
            return;
        }
        
        int totalVehicles = 0;
        int lightTraffic = 0;
        int moderateTraffic = 0;
        int heavyTraffic = 0;
        int congestedTraffic = 0;
        
        for (int count : trafficData.values()) {
            totalVehicles += count;
            
            if (count < 50) lightTraffic++;
            else if (count < 100) moderateTraffic++;
            else if (count < 150) heavyTraffic++;
            else congestedTraffic++;
        }
        
        double averageTraffic = (double) totalVehicles / trafficData.size();
        
        System.out.println("\n========== Traffic Analysis Report ==========");
        System.out.println("\nOverall Statistics:");
        System.out.println("  Total vehicles across all roads: " + totalVehicles);
        System.out.println("  Total roads being monitored: " + trafficData.size());
        System.out.println("  Average vehicles per road: " + String.format("%.2f", averageTraffic));
        
        System.out.println("\nTraffic Status Distribution:");
        System.out.println("  Light Traffic (< 50 vehicles): " + lightTraffic + " roads");
        System.out.println("  Moderate Traffic (50-99 vehicles): " + moderateTraffic + " roads");
        System.out.println("  Heavy Traffic (100-149 vehicles): " + heavyTraffic + " roads");
        System.out.println("  Congested Traffic (≥ 150 vehicles): " + congestedTraffic + " roads");
        
        // Busiest road
        String busiestRoad = null;
        int maxVehicles = 0;
        for (String road : trafficData.keySet()) {
            int vehicles = trafficData.get(road);
            if (vehicles > maxVehicles) {
                maxVehicles = vehicles;
                busiestRoad = road;
            }
        }
        
        // Least busy road
        String leastBusyRoad = null;
        int minVehicles = Integer.MAX_VALUE;
        for (String road : trafficData.keySet()) {
            int vehicles = trafficData.get(road);
            if (vehicles < minVehicles) {
                minVehicles = vehicles;
                leastBusyRoad = road;
            }
        }
        
        System.out.println("\nRoad Status:");
        System.out.println("  Busiest Road: " + busiestRoad + " (" + maxVehicles + " vehicles) ⚠️");
        System.out.println("  Least Busy Road: " + leastBusyRoad + " (" + minVehicles + " vehicles) ✓");
        
        System.out.println("\nRecommendations:");
        if (congestedTraffic > 0) {
            System.out.println("  ⚠️  " + congestedTraffic + " road(s) are severely congested. Consider:");
            System.out.println("      - Deploying traffic police");
            System.out.println("      - Implementing alternative routes");
            System.out.println("      - Adjusting traffic signals");
        }
        if (averageTraffic > 100) {
            System.out.println("  ⚠️  City-wide traffic is heavy. Monitor situation closely.");
        }
        
        System.out.println("\n=============================================\n");
    }
    
    /**
     * Display total number of roads being monitored
     */
    public int getTotalRoadsMonitored() {
        return trafficData.size();
    }
    
    /**
     * Clear all traffic data
     */
    public void clearTrafficData() {
        trafficData.clear();
        System.out.println("✓ All traffic data cleared.");
    }
    
    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem trafficSystem = new SmartCityTrafficMonitoringSystem();
        
        System.out.println("========== Smart City Traffic Monitoring System ==========\n");
        
        // Add traffic data for different roads
        System.out.println("--- Adding Traffic Data ---");
        trafficSystem.addOrUpdateRoadTraffic("Main Street", 85);
        trafficSystem.addOrUpdateRoadTraffic("Broadway", 142);
        trafficSystem.addOrUpdateRoadTraffic("Park Avenue", 35);
        trafficSystem.addOrUpdateRoadTraffic("Fifth Avenue", 95);
        trafficSystem.addOrUpdateRoadTraffic("Oak Lane", 120);
        trafficSystem.addOrUpdateRoadTraffic("Elm Street", 45);
        trafficSystem.addOrUpdateRoadTraffic("Maple Road", 165);
        trafficSystem.addOrUpdateRoadTraffic("Cedar Drive", 60);
        trafficSystem.addOrUpdateRoadTraffic("Birch Boulevard", 130);
        trafficSystem.addOrUpdateRoadTraffic("Ash Avenue", 75);
        System.out.println();
        
        // Display all roads in sorted order
        trafficSystem.displayAllRoadsSorted();
        
        // Display busiest road
        trafficSystem.displayBusiestRoad();
        
        // Update traffic counts
        System.out.println("--- Updating Traffic Counts ---");
        trafficSystem.updateTrafficCount("Main Street", 20);
        System.out.println();
        trafficSystem.updateTrafficCount("Broadway", 15);
        System.out.println();
        
        // Display updated roads
        trafficSystem.displayAllRoadsSorted();
        
        // Generate detailed traffic analysis report
        System.out.println("--- Generating Traffic Analysis Report ---");
        trafficSystem.generateTrafficAnalysisReport();
        
        // Display specific road traffic
        System.out.println("--- Traffic for Specific Roads ---");
        System.out.println("Park Avenue: " + trafficSystem.getVehicleCountForRoad("Park Avenue") + " vehicles");
        System.out.println("Maple Road: " + trafficSystem.getVehicleCountForRoad("Maple Road") + " vehicles");
        System.out.println();
        
        // Display total roads monitored
        System.out.println("--- System Status ---");
        System.out.println("Total roads being monitored: " + trafficSystem.getTotalRoadsMonitored());
    }
}
