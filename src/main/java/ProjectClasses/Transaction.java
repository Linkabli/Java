package ProjectClasses;

import java.util.Date;

public class Transaction {
    private Account account;
    private double amount;
    private Date timestamp;

    Transaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
        this.timestamp = new Date();
    }
}
