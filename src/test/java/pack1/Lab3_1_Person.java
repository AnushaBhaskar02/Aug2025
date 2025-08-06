package pack1;

public class Lab3_1_Person {
	// Person.java

	private String firstName;
	private String lastName;
	private int age;
	private String gender;

	public Lab3_1_Person() {
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
		this.gender = "";
	}

	// Parameterized constructor with validation
	public Lab3_1_Person(String firstName, String lastName, int age, String gender) throws NameBlankException {
		if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
			throw new NameBlankException("First name and last name cannot be blank!");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	public void displayDetails() {
		System.out.println("First Name : " + firstName);
		System.out.println("Last Name  : " + lastName);
		System.out.println("Age        : " + age);
		System.out.println("Gender     : " + gender);
	}



}
