package pack1;

public class Lab3_2 {
    // Method to validate age
    public static void validateAge(int age) throws AgeException {
        if (age <= 15) {
            throw new AgeException("Age must be greater than 15!");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(20); 
            validateAge(15); 
            validateAge(10);
        } catch (AgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
