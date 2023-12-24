package ProjectClasses;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private Account account;
    private double balance;

    public Customer(String name, String lastname, String login, String password, Double balance) {
        this.firstname = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        if (balance == null) {
            balance = 0.;
        }
        account = new Account(this, balance);
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public Account getAccount() {
        return account;
    }
    public double getBalance() {
        return balance;
    }
    public String getLastname() {
        return lastname;
    }
    public String getFirstname() {
        return firstname;
    }
}
