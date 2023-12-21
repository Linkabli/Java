package ProjectClasses;

public class Account {
    private Customer owner;
    private double balance;

    Account(Customer owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
    }
    double getBalance() {
        return balance;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

}
