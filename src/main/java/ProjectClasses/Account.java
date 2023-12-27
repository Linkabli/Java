package ProjectClasses;

public class Account {
    private Customer owner;
    private double balance;
    private Transaction newTransaction;
    private double amount;
    private int indexType;
    private CreditAccount creditAccount;

    Account(Customer owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;

    }
    public double getBalance() {
        return balance;
    }
    public void Transaction() {
        newTransaction = new Transaction(this, amount, indexType);
    }
    void withdraw(double amount) { //снятие
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Недостаточно средств.");
        }
    }
}