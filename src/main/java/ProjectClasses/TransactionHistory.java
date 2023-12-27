package ProjectClasses;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    Account account;
    private List<Transaction> transactions;
    private int indexTransaction;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
        indexTransaction = 1;
  }

    void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        indexTransaction++;
    }
    public List<Transaction> getList() {
        return transactions;
    }
}
