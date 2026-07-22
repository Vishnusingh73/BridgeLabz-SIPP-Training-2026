import java.util.*;

/**
 * Address Book Application
 * Stores contacts using ArrayList (ordered storage), HashMap (fast lookup),
 * and HashSet (prevent duplicate phone numbers)
 */
public class AddressBook {
    
    private static class Contact implements Comparable<Contact> {
        String name;
        String phone;
        String email;
        
        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
        
        @Override
        public int compareTo(Contact other) {
            return this.name.compareTo(other.name);
        }
        
        @Override
        public String toString() {
            return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
        }
    }
    
    private ArrayList<Contact> contacts;
    private HashMap<String, Contact> nameIndex;
    private HashSet<String> phoneNumbers;
    
    public AddressBook() {
        this.contacts = new ArrayList<>();
        this.nameIndex = new HashMap<>();
        this.phoneNumbers = new HashSet<>();
    }
    
    /**
     * Add a new contact to the address book
     * @param name Contact name
     * @param phone Contact phone number
     * @param email Contact email
     * @return true if added successfully, false if phone already exists
     */
    public boolean addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            System.out.println("Error: Phone number " + phone + " already exists!");
            return false;
        }
        
        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        nameIndex.put(name, contact);
        phoneNumbers.add(phone);
        System.out.println("Contact added successfully: " + name);
        return true;
    }
    
    /**
     * Search for a contact by name
     * @param name Contact name to search
     * @return Contact object if found, null otherwise
     */
    public Contact searchByName(String name) {
        Contact contact = nameIndex.get(name);
        if (contact != null) {
            System.out.println("Found: " + contact);
        } else {
            System.out.println("Contact not found: " + name);
        }
        return contact;
    }
    
    /**
     * Delete a contact by name
     * @param name Contact name to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteContact(String name) {
        Contact contact = nameIndex.get(name);
        if (contact != null) {
            contacts.remove(contact);
            nameIndex.remove(name);
            phoneNumbers.remove(contact.phone);
            System.out.println("Contact deleted successfully: " + name);
            return true;
        } else {
            System.out.println("Contact not found: " + name);
            return false;
        }
    }
    
    /**
     * Display all contacts sorted by name
     */
    public void displaySortedByName() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty!");
            return;
        }
        
        Collections.sort(contacts);
        System.out.println("\n========== Address Book (Sorted by Name) ==========");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        System.out.println("Total contacts: " + contacts.size());
        System.out.println("==================================================\n");
    }
    
    /**
     * Display all contacts
     */
    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty!");
            return;
        }
        
        System.out.println("\n========== All Contacts ==========");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        System.out.println("Total contacts: " + contacts.size());
        System.out.println("==================================\n");
    }
    
    /**
     * Get total number of contacts
     */
    public int getTotalContacts() {
        return contacts.size();
    }
    
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        
        System.out.println("========== Address Book Application ==========\n");
        
        // Add contacts
        addressBook.addContact("John Smith", "9876543210", "john@email.com");
        addressBook.addContact("Alice Johnson", "9876543211", "alice@email.com");
        addressBook.addContact("Bob Wilson", "9876543212", "bob@email.com");
        addressBook.addContact("Carol Davis", "9876543213", "carol@email.com");
        addressBook.addContact("David Brown", "9876543214", "david@email.com");
        
        // Try to add duplicate phone number
        System.out.println();
        addressBook.addContact("Eve Smith", "9876543210", "eve@email.com");
        
        // Display all contacts
        System.out.println();
        addressBook.displayAll();
        
        // Search for a contact
        System.out.println("--- Searching for contacts ---");
        addressBook.searchByName("Alice Johnson");
        System.out.println();
        addressBook.searchByName("Frank Miller");
        System.out.println();
        
        // Display sorted by name
        addressBook.displaySortedByName();
        
        // Delete a contact
        System.out.println("--- Deleting a contact ---");
        addressBook.deleteContact("Bob Wilson");
        System.out.println();
        
        // Display after deletion
        addressBook.displaySortedByName();
        
        System.out.println("Total contacts in address book: " + addressBook.getTotalContacts());
    }
}
