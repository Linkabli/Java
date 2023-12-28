package ProjectClasses;

import java.util.ArrayList;

public class TransactionHistory {
    Account account;
    private ArrayList<Transaction> transactions;
    private int indexTransaction;

    public TransactionHistory() {
        this.transactions = new ArrayList<>();
        indexTransaction = 1;
  }
    public ArrayList<Transaction> getList() {
        return transactions;
    }
}
