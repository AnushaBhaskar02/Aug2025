package pack1;

public class Lab3_1 {
	// PersonMain.java
	    public static void main(String[] args) {
	        try {
	            // Valid Person
	        	Lab3_1_Person person1 = new Lab3_1_Person("Anusha", "Bhaskar", 22, "Female");
	            System.out.println("Person 1 details:");
	            person1.displayDetails();

	            System.out.println();

	            // Invalid Person (empty first name or last name)
	            Lab3_1_Person person2 = new Lab3_1_Person("", "Akash", 30, "male"); 
	            System.out.println("Person 2 details:");
	            person2.displayDetails();

	        } catch (NameBlankException e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
	}
