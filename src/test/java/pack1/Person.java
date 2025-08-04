package pack1;


public class Person {
	String firstName;
	String lastName;
	char gender;
	Person(String firstName,String lastName,char gender){
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;

	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void display() {
		System.out.println("Person details:");
		System.out.println("------------------------");
		System.out.println("First Name:"+firstName);
		System.out.println("Last Name: "+lastName);
		System.out.println("Gender: "+gender);
	}
	public void phNumber(long phNumber) {
		System.out.println("phone number:"+phNumber);
	}
}


