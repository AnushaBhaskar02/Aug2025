package pack1;
public class Lab2_1 { //Account Class
    private static long nextAccountNumber = 100000; 
    private long accNum;
    private double balance;
    private Person2_1 accHolder;

    // Constructor
    public Lab2_1(Person2_1 accHolder, double initialBalance) {
        this.accHolder = accHolder;
        this.accNum = nextAccountNumber++;
        if (initialBalance >= 500) {
            this.balance = initialBalance;
        } else {
            this.balance = 500; 
            System.out.println("Initial balance too low. Setting to minimum INR 500.");
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if ((balance - amount) >= 500) {
                balance -= amount;
            } else {
                System.out.println("Cannot withdraw. Minimum balance of INR 500 must be maintained.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

   
    public double getBalance() {
        return balance;
    }

   
    public long getAccNum() {
        return accNum;
    }

    public Person2_1 getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(Person2_1 accHolder) {
        this.accHolder = accHolder;
    }

    @Override
    public String toString() {
        return "Account Number: " + accNum +
               "\nAccount Holder: " + accHolder +
               "\nBalance: INR " + balance;
    }
}
