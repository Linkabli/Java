package ProjectClasses;

import java.util.Date;

public class Transaction {
    private Account account;
    private double amount;
    private Date timestamp;
    private String type;
    private TransactionHistory transactionHistory;

    Transaction(Account account, double amount, int type) {
        this.account = account;
        this.amount = amount;
        this.timestamp = new Date();
        transactionHistory = new TransactionHistory();
    }
}