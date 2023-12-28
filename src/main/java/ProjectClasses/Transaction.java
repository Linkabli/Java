package ProjectClasses;

import java.time.LocalDate;

public class Transaction {
    private Account account;
    private double amount;
    private int type;
    private LocalDate currentDate;
    private TransactionHistory transactionHistory;
    public Transaction(Account account, double amount, int type) {
        this.account = account;
        this.amount = amount;
        this.type = type;
        transactionHistory = new TransactionHistory();
        currentDate = LocalDate.now();
    }
    public double getAmount() {
        return amount;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public int getType() {
        return type;
    }
}