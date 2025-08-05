package pack1;

import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Person p=new Person("Anusha", "Bhaskar", 'F');
		p.display();
		p.phNumber(9845344354L);

	}

}
