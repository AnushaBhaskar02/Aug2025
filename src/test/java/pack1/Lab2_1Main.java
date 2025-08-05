package pack1;

public class Lab2_1Main {
    public static void main(String[] args) {
        Person2_1 smithPerson = new Person2_1("Smith", 30.0f);
        Person2_1 kathyPerson = new Person2_1("Kathy", 28.0f);

        Lab2_1 smithAcc = new Lab2_1(smithPerson, 2000);
        Lab2_1 kathyAcc = new Lab2_1(kathyPerson, 3000);

        smithAcc.deposit(2000);

        kathyAcc.withdraw(2000);

        System.out.println("Updated Account Details:\n");

        System.out.println(smithAcc);
        System.out.println();
        System.out.println(kathyAcc);
    }
}
