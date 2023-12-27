package ProjectClasses;

public class CreditAccount extends Account {
    private double creditLimit;

    public CreditAccount(Customer owner, double creditLimit, double creditBalance) {
        super(owner, creditBalance);  // Кредитный счет начинается с нулевого баланса
        this.creditLimit = creditLimit;
    }
    @Override
    void withdraw(double amount) {
        if (amount <= getBalance() + creditLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Exceeded credit limit");
        }
    }
    public double getCreditLimit() {
        return creditLimit;
    }
}
