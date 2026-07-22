import java.util.*;

/**
 * Event Entry Verification System
 * Uses HashSet to store unique participant email IDs
 * Prevents duplicate registrations and manages event attendance
 */
public class EventEntryVerificationSystem {
    
    private HashSet<String> registeredParticipants;
    private int attemptedRegistrations;
    
    public EventEntryVerificationSystem() {
        this.registeredParticipants = new HashSet<>();
        this.attemptedRegistrations = 0;
    }
    
    /**
     * Register a new participant
     * @param emailId Participant email ID
     * @return true if registration successful, false if duplicate
     */
    public boolean registerParticipant(String emailId) {
        attemptedRegistrations++;
        
        if (emailId == null || emailId.trim().isEmpty()) {
            System.out.println("Error: Email ID cannot be empty!");
            return false;
        }
        
        // HashSet automatically prevents duplicates
        if (registeredParticipants.contains(emailId)) {
            System.out.println("✗ Registration Failed: " + emailId + " is already registered!");
            return false;
        }
        
        registeredParticipants.add(emailId);
        System.out.println("✓ Registration Successful: " + emailId + " has been registered.");
        return true;
    }
    
    /**
     * Check if a participant is registered
     * @param emailId Participant email ID
     * @return true if registered, false otherwise
     */
    public boolean isRegistered(String emailId) {
        return registeredParticipants.contains(emailId);
    }
    
    /**
     * Unregister a participant
     * @param emailId Participant email ID
     * @return true if successfully removed, false if not found
     */
    public boolean unregisterParticipant(String emailId) {
        if (registeredParticipants.remove(emailId)) {
            System.out.println("✓ Unregistration Successful: " + emailId + " has been removed.");
            return true;
        } else {
            System.out.println("✗ Error: " + emailId + " was not registered!");
            return false;
        }
    }
    
    /**
     * Display all registered participants
     */
    public void displayAllParticipants() {
        if (registeredParticipants.isEmpty()) {
            System.out.println("\n========== Event Registration Status ==========");
            System.out.println("No participants registered yet.");
            System.out.println("Total registered participants: 0");
            System.out.println("===============================================\n");
            return;
        }
        
        System.out.println("\n========== Registered Participants ==========");
        List<String> sortedList = new ArrayList<>(registeredParticipants);
        Collections.sort(sortedList);
        
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println((i + 1) + ". " + sortedList.get(i));
        }
        System.out.println("\nTotal registered participants: " + registeredParticipants.size());
        System.out.println("=============================================\n");
    }
    
    /**
     * Display registration statistics
     */
    public void displayRegistrationStats() {
        System.out.println("\n========== Registration Statistics ==========");
        System.out.println("Total registration attempts: " + attemptedRegistrations);
        System.out.println("Unique registrations: " + registeredParticipants.size());
        System.out.println("Duplicate attempts blocked: " + (attemptedRegistrations - registeredParticipants.size()));
        System.out.println("==============================================\n");
    }
    
    /**
     * Get total number of eligible attendees
     */
    public int getTotalAttendees() {
        return registeredParticipants.size();
    }
    
    /**
     * Get all participants as a set
     */
    public Set<String> getRegisteredParticipants() {
        return new HashSet<>(registeredParticipants);
    }
    
    public static void main(String[] args) {
        EventEntryVerificationSystem eventSystem = new EventEntryVerificationSystem();
        
        System.out.println("========== Event Entry Verification System ==========\n");
        
        // Register participants
        System.out.println("--- Registering Participants ---");
        eventSystem.registerParticipant("john@email.com");
        eventSystem.registerParticipant("alice@email.com");
        eventSystem.registerParticipant("bob@email.com");
        eventSystem.registerParticipant("carol@email.com");
        eventSystem.registerParticipant("david@email.com");
        
        // Attempt duplicate registrations
        System.out.println("\n--- Attempting Duplicate Registrations ---");
        eventSystem.registerParticipant("john@email.com");
        System.out.println();
        eventSystem.registerParticipant("alice@email.com");
        System.out.println();
        eventSystem.registerParticipant("frank@email.com");
        
        // Display all registered participants
        System.out.println();
        eventSystem.displayAllParticipants();
        
        // Check if specific participant is registered
        System.out.println("--- Checking Registration Status ---");
        if (eventSystem.isRegistered("bob@email.com")) {
            System.out.println("✓ bob@email.com is eligible to enter the conference");
        } else {
            System.out.println("✗ bob@email.com is NOT eligible to enter the conference");
        }
        System.out.println();
        
        if (eventSystem.isRegistered("unknown@email.com")) {
            System.out.println("✓ unknown@email.com is eligible to enter the conference");
        } else {
            System.out.println("✗ unknown@email.com is NOT eligible to enter the conference");
        }
        System.out.println();
        
        // More registrations
        System.out.println("--- More Participants Registering ---");
        eventSystem.registerParticipant("eve@email.com");
        System.out.println();
        eventSystem.registerParticipant("charlie@email.com");
        System.out.println();
        
        // Display updated participant list
        eventSystem.displayAllParticipants();
        
        // Unregister a participant
        System.out.println("--- Unregistering a Participant ---");
        eventSystem.unregisterParticipant("david@email.com");
        System.out.println();
        
        // Display final list
        eventSystem.displayAllParticipants();
        
        // Display statistics
        eventSystem.displayRegistrationStats();
        
        System.out.println("Total attendees eligible to enter the conference: " + eventSystem.getTotalAttendees());
    }
}
