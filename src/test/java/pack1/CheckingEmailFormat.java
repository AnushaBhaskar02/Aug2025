package pack1;

public class CheckingEmailFormat {
	public static void main(String[] args) {
		String email = "anusha20@gmail.com";

		if (email.contains("@")) {
			System.out.println("Valid email");
		} else {
			System.out.println("Invalid email");
		}
	}
}
