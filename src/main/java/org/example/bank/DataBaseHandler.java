package org.example.bank;

import ProjectClasses.Customer;
import java.sql.*;

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
                        resSet.getDouble(Const.USER_BALANCE)

                );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }


}