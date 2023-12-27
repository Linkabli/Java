package org.example.bank;

import ProjectClasses.Customer;
import ProjectClasses.Transaction;
import ProjectClasses.TransactionHistory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public ResultSet getUser(Customer user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USER_PASS + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public void signUpUser(String firstName, String lastName, String login, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_NAME + ", " + Const.USER_LASTNAME + ", " + Const.USER_LOGIN + ", " + Const.USER_PASS + ")" +
                "VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        prSt.setString(3, login);
        prSt.setString(4, password);

        prSt.executeUpdate();
    }
    public Customer getUserDataByName(String username) {
        Customer user = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, username);
            ResultSet resSet = prSt.executeQuery();

            if (resSet.next()) {
                // Создаем объект Customer и заполняем его данными из ResultSet
                user = new Customer(
                        resSet.getString(Const.USER_NAME),
                        resSet.getString(Const.USER_LASTNAME),
                        resSet.getString(Const.USER_LOGIN),
                        resSet.getString(Const.USER_PASS),
                        resSet.getDouble(Const.USER_BALANCE),
                        resSet.getDouble(Const.USER_CREDIT_LIMIT),
                        resSet.getDouble(Const.USER_CREDIT_BALANCE)
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void updateUserBalance(Customer user, double balance, Transaction transaction) {
        double newBalance = user.getBalance() + balance;
        Date Date1 = Date.valueOf(transaction.getCurrentDate());
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_BALANCE + "=? WHERE " + Const.USER_LOGIN + "=?";
        String insertTransaction = "INSERT INTO " +
                Const.USER_TRANSACTION_TABLE + "("
                + Const.USER_LOGIN + ", "
                + Const.USER_AMOUNT + ", "
                + Const.USER_DATE + ", "
                + Const.USER_TYPE_OF_TRANSANCTION +
                ") VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setDouble(1, newBalance); // Новое значение баланса
            prSt.setString(2, user.getLogin());
            int rowsAffected = prSt.executeUpdate();
            PreparedStatement prStTransaction = getDbConnection().prepareStatement(insertTransaction);
            prStTransaction.setString(1, user.getLogin());
            prStTransaction.setDouble(2, transaction.getAmount());
            prStTransaction.setDate(3, Date1);
            prStTransaction.setInt(4, transaction.getType());

            int rowsAffectedTransaction = prStTransaction.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Баланс пользователя успешно обновлен.");
            } else {
                System.out.println("Пользователь с логином " + user.getLogin() + " не найден.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void TransactionToClient(Customer user, String login, double amount, Transaction transaction) {
        Date Date1 = Date.valueOf(transaction.getCurrentDate());
        double newBalanceUser = -amount;
        Customer Client = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, login);
            ResultSet resSet = prSt.executeQuery();
            if (resSet.next()) {
                // Создаем объект Customer и заполняем его данными из ResultSet
                Client = new Customer(
                        resSet.getString(Const.USER_NAME),
                        resSet.getString(Const.USER_LASTNAME),
                        resSet.getString(Const.USER_LOGIN),
                        resSet.getString(Const.USER_PASS),
                        resSet.getDouble(Const.USER_BALANCE),
                        resSet.getDouble(Const.USER_CREDIT_LIMIT),
                        resSet.getDouble(Const.USER_CREDIT_BALANCE)
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        int typeUser = -transaction.getType();
        Transaction TransactionClient = new Transaction(Client.getAccount(), amount, transaction.getType());
        Transaction TransactionUser = new Transaction(user.getAccount(), amount, typeUser);
        updateUserBalance(user, newBalanceUser, TransactionUser);
        updateUserBalance(Client, amount, TransactionClient);
    }

    public List<TransactionHistory> getTransactionHistoryFromDatabase(ArrayList<TransactionHistory> list, Customer user) throws SQLException {
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, username);
            ResultSet resSet = prSt.executeQuery();

            if (resSet.next()) {

                user = new Customer(
                        resSet.getString(Const.USER_NAME),
                        resSet.getString(Const.USER_LASTNAME),
                        resSet.getString(Const.USER_LOGIN),
                        resSet.getString(Const.USER_PASS),
                        resSet.getDouble(Const.USER_BALANCE),
                        resSet.getDouble(Const.USER_CREDIT_LIMIT),
                        resSet.getDouble(Const.USER_CREDIT_BALANCE)
                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}