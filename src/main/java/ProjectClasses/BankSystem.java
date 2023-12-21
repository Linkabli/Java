package ProjectClasses;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {
    private List<Customer> customers;
    private List<Account> accounts;

    BankSystem() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    void addCustomer(Customer customer) {
        customers.add(customer);
    }

    void openAccount(Customer customer, double initialBalance) {
        Account account = new Account(customer, initialBalance);
        accounts.add(account);
        customer.addAccount(account);
    }
}
