package ProjectClasses;

public class Customer {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private Account account;
    private double balance;
    private TransactionHistory transactionHistory;
    private CreditAccount creditAccount;

    public Customer(String name,
                    String lastname,
                    String login,
                    String password,
                    Double balance,
                    Double creditLimit,
                    Double creditBalance) {
        this.firstname = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        if ((balance == null) || (balance == 0)) {
            this.balance = 0.;
        } else this.balance = balance;
        account = new Account(this, balance);
        creditAccount = new CreditAccount(this, creditLimit, creditBalance);
        transactionHistory = new TransactionHistory();
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
    public CreditAccount getCreditAccount() {
        return creditAccount;
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
