import java.util.*;

/**
 * Space Mission Crew Management System
 * Manages astronaut assignments to various space missions
 * Uses HashMap for mission tracking and HashSet to prevent duplicate assignments
 */
public class SpaceMissionCrewManagementSystem {
    
    /**
     * Astronaut class representing a crew member
     */
    private static class Astronaut {
        private String astronautId;
        private String name;
        private String specialization;
        
        public Astronaut(String astronautId, String name, String specialization) {
            this.astronautId = astronautId;
            this.name = name;
            this.specialization = specialization;
        }
        
        public String getAstronautId() {
            return astronautId;
        }
        
        public String getName() {
            return name;
        }
        
        public String getSpecialization() {
            return specialization;
        }
        
        @Override
        public String toString() {
            return name + " (ID: " + astronautId + ") - Specialization: " + specialization;
        }
    }
    
    private HashMap<String, List<Astronaut>> missionCrewMap;
    private HashMap<String, HashSet<String>> missionAstronautIds; // To prevent duplicates
    
    public SpaceMissionCrewManagementSystem() {
        this.missionCrewMap = new HashMap<>();
        this.missionAstronautIds = new HashMap<>();
    }
    
    /**
     * Add a new mission
     * @param missionName Name of the mission
     * @return true if mission added, false if already exists
     */
    public boolean addMission(String missionName) {
        if (missionName == null || missionName.trim().isEmpty()) {
            System.out.println("Error: Mission name cannot be empty!");
            return false;
        }
        
        if (missionCrewMap.containsKey(missionName)) {
            System.out.println("✗ Mission '" + missionName + "' already exists!");
            return false;
        }
        
        missionCrewMap.put(missionName, new ArrayList<>());
        missionAstronautIds.put(missionName, new HashSet<>());
        System.out.println("✓ Mission '" + missionName + "' added successfully.");
        return true;
    }
    
    /**
     * Assign an astronaut to a mission
     * @param missionName Name of the mission
     * @param astronaut Astronaut object to assign
     * @return true if assigned successfully, false if duplicate or mission not found
     */
    public boolean assignAstronautToMission(String missionName, Astronaut astronaut) {
        if (astronaut == null) {
            System.out.println("Error: Astronaut cannot be null!");
            return false;
        }
        
        if (!missionCrewMap.containsKey(missionName)) {
            System.out.println("✗ Mission '" + missionName + "' not found!");
            return false;
        }
        
        HashSet<String> assignedIds = missionAstronautIds.get(missionName);
        
        // Check if astronaut is already assigned to this mission
        if (assignedIds.contains(astronaut.getAstronautId())) {
            System.out.println("✗ Error: " + astronaut.getName() + " is already assigned to mission '" + missionName + "'");
            return false;
        }
        
        // Assign astronaut
        missionCrewMap.get(missionName).add(astronaut);
        assignedIds.add(astronaut.getAstronautId());
        System.out.println("✓ Assigned: " + astronaut.getName() + " to mission '" + missionName + "'");
        return true;
    }
    
    /**
     * Remove an astronaut from a mission
     * @param missionName Name of the mission
     * @param astronautId ID of the astronaut to remove
     * @return true if removed, false if not found
     */
    public boolean removeAstronautFromMission(String missionName, String astronautId) {
        if (!missionCrewMap.containsKey(missionName)) {
            System.out.println("✗ Mission '" + missionName + "' not found!");
            return false;
        }
        
        List<Astronaut> crew = missionCrewMap.get(missionName);
        Astronaut toRemove = null;
        
        for (Astronaut astronaut : crew) {
            if (astronaut.getAstronautId().equals(astronautId)) {
                toRemove = astronaut;
                break;
            }
        }
        
        if (toRemove != null) {
            crew.remove(toRemove);
            missionAstronautIds.get(missionName).remove(astronautId);
            System.out.println("✓ Removed: " + toRemove.getName() + " from mission '" + missionName + "'");
            return true;
        } else {
            System.out.println("✗ Astronaut with ID '" + astronautId + "' not found in mission '" + missionName + "'");
            return false;
        }
    }
    
    /**
     * Display all missions and their crew members
     */
    public void displayAllMissions() {
        if (missionCrewMap.isEmpty()) {
            System.out.println("\n========== Space Missions ==========");
            System.out.println("No missions found.");
            System.out.println("===================================\n");
            return;
        }
        
        System.out.println("\n========== All Space Missions ==========");
        for (String missionName : missionCrewMap.keySet()) {
            List<Astronaut> crew = missionCrewMap.get(missionName);
            System.out.println("\nMission: " + missionName);
            System.out.println("Crew Members (" + crew.size() + "):");
            
            if (crew.isEmpty()) {
                System.out.println("  No crew members assigned.");
            } else {
                for (int i = 0; i < crew.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + crew.get(i));
                }
            }
        }
        System.out.println("\n=====================================\n");
    }
    
    /**
     * Display details of a specific mission
     * @param missionName Name of the mission
     */
    public void displayMissionDetails(String missionName) {
        if (!missionCrewMap.containsKey(missionName)) {
            System.out.println("\n========== Mission Details ==========");
            System.out.println("Mission '" + missionName + "' not found.");
            System.out.println("====================================\n");
            return;
        }
        
        List<Astronaut> crew = missionCrewMap.get(missionName);
        System.out.println("\n========== Mission Details: " + missionName + " ==========");
        System.out.println("Total crew members: " + crew.size());
        
        if (crew.isEmpty()) {
            System.out.println("No crew members assigned.");
        } else {
            System.out.println("\nAssigned Crew Members:");
            for (int i = 0; i < crew.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + crew.get(i));
            }
        }
        System.out.println("===============================================\n");
    }
    
    /**
     * Get total number of astronauts assigned to a mission
     * @param missionName Name of the mission
     * @return number of astronauts, -1 if mission not found
     */
    public int getTotalAstronautsInMission(String missionName) {
        if (!missionCrewMap.containsKey(missionName)) {
            return -1;
        }
        return missionCrewMap.get(missionName).size();
    }
    
    /**
     * Display mission statistics
     */
    public void displayMissionStatistics() {
        if (missionCrewMap.isEmpty()) {
            System.out.println("\n========== Mission Statistics ==========");
            System.out.println("No missions found.");
            System.out.println("=======================================\n");
            return;
        }
        
        System.out.println("\n========== Mission Statistics ==========");
        int totalAstronauts = 0;
        
        for (String missionName : missionCrewMap.keySet()) {
            int count = missionCrewMap.get(missionName).size();
            System.out.println(missionName + ": " + count + " astronauts");
            totalAstronauts += count;
        }
        
        System.out.println("\nTotal missions: " + missionCrewMap.size());
        System.out.println("Total astronaut assignments: " + totalAstronauts);
        System.out.println("=======================================\n");
    }
    
    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem spaceAgency = new SpaceMissionCrewManagementSystem();
        
        System.out.println("========== Space Mission Crew Management System ==========\n");
        
        // Add missions
        System.out.println("--- Adding Missions ---");
        spaceAgency.addMission("Apollo 11");
        spaceAgency.addMission("Moon Base Alpha");
        spaceAgency.addMission("Mars Exploration");
        spaceAgency.addMission("Space Station Repair");
        System.out.println();
        
        // Create astronauts
        Astronaut astronaut1 = new Astronaut("A001", "Neil Armstrong", "Command Pilot");
        Astronaut astronaut2 = new Astronaut("A002", "Buzz Aldrin", "Lunar Module Pilot");
        Astronaut astronaut3 = new Astronaut("A003", "Michael Collins", "Command Module Pilot");
        Astronaut astronaut4 = new Astronaut("A004", "Sally Ride", "Mission Specialist");
        Astronaut astronaut5 = new Astronaut("A005", "John Glenn", "Capsule Communicator");
        Astronaut astronaut6 = new Astronaut("A006", "Mae Jemison", "Payload Specialist");
        
        // Assign astronauts to missions
        System.out.println("--- Assigning Astronauts to Missions ---");
        spaceAgency.assignAstronautToMission("Apollo 11", astronaut1);
        spaceAgency.assignAstronautToMission("Apollo 11", astronaut2);
        spaceAgency.assignAstronautToMission("Apollo 11", astronaut3);
        
        System.out.println();
        spaceAgency.assignAstronautToMission("Moon Base Alpha", astronaut1);
        spaceAgency.assignAstronautToMission("Moon Base Alpha", astronaut4);
        spaceAgency.assignAstronautToMission("Moon Base Alpha", astronaut5);
        
        System.out.println();
        spaceAgency.assignAstronautToMission("Mars Exploration", astronaut2);
        spaceAgency.assignAstronautToMission("Mars Exploration", astronaut6);
        
        // Try duplicate assignment
        System.out.println();
        spaceAgency.assignAstronautToMission("Apollo 11", astronaut1);
        System.out.println();
        
        // Display all missions
        spaceAgency.displayAllMissions();
        
        // Display specific mission details
        System.out.println("--- Mission Details ---");
        spaceAgency.displayMissionDetails("Apollo 11");
        spaceAgency.displayMissionDetails("Mars Exploration");
        
        // Display statistics
        System.out.println("--- Mission Statistics ---");
        spaceAgency.displayMissionStatistics();
        
        // Show total astronauts per mission
        System.out.println("--- Total Astronauts Per Mission ---");
        System.out.println("Apollo 11: " + spaceAgency.getTotalAstronautsInMission("Apollo 11") + " astronauts");
        System.out.println("Moon Base Alpha: " + spaceAgency.getTotalAstronautsInMission("Moon Base Alpha") + " astronauts");
        System.out.println("Mars Exploration: " + spaceAgency.getTotalAstronautsInMission("Mars Exploration") + " astronauts");
        System.out.println("Space Station Repair: " + spaceAgency.getTotalAstronautsInMission("Space Station Repair") + " astronauts");
        System.out.println();
        
        // Remove an astronaut
        System.out.println("--- Removing an Astronaut ---");
        spaceAgency.removeAstronautFromMission("Moon Base Alpha", "A005");
        System.out.println();
        
        // Display updated details
        spaceAgency.displayMissionDetails("Moon Base Alpha");
    }
}
