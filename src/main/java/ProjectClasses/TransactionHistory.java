package ProjectClasses;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private Account account;
    private List<Transaction> transactions;

    TransactionHistory(Account account) {
        this.account = account;
        this.transactions = new ArrayList<>();
    }

    void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
