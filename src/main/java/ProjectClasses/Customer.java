package ProjectClasses;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private List<Account> accounts;

    public Customer(String name, String lastname, String login, String password) {
        this.firstname = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void addAccount(Account account) {
        accounts.add(account);
    }
}
