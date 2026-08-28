import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Bill Nye", new Contact("Bill Nye", "+1 818 222 0100"));
        contacts.put("Sally Loo", new Contact("Sally Loo", "+1 805 444 0010"));
        contacts.put("John Smith", new Contact("John Smith", "+1 939 555 0001"));
        contacts.put("Robot Junior", new Contact("Robot Junior", "+1 917 777 1000"));
 
        // Step 5: look up a contact 
        Contact contact1 = contacts.get("Bill Nye");
        if (contact1 == null) {
            System.out.println("Contact not found.");
        }
        else {
            System.out.println("Contact found: " + contact1);
        }
        Contact contact2 = contacts.get("Jo March");
        if (contact2 == null) {
            System.out.println("Contact not found.");
        }
        else {
            System.out.println("Contact found: " + contact2);
        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("\n=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact); 
        }
    } 
}