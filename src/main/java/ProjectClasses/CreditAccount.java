package ProjectClasses;

class CreditAccount extends Account {
    private double creditLimit;
    private double interestRate;

    CreditAccount(Customer owner, double creditLimit, double interestRate) {
        super(owner, 0);  // Кредитный счет начинается с нулевого баланса
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }
    @Override
    void withdraw(double amount) {
        if (amount <= getBalance() + creditLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Exceeded credit limit");
        }
    }
    ///////
    void chargeInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
}
