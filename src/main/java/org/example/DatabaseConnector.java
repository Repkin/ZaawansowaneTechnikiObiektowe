package org.example;

import java.sql.*;

public class DatabaseConnector {
    public static final String HOST = "jdbc:postgresql://snuffleupagus.db.elephantsql.com/";
    public static final String DATABASE = "ceeolcvc";
    public static final String USERNAME = "ceeolcvc";
    public static final String PASS = "cZG7hZmYk3y4e01bfFneqLZZx1zOZbel";
    public Connection connection;

    public Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(HOST + DATABASE, USERNAME, PASS);
            System.out.println("Poprawnie połączono z bazą danych \n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeInsert(String insert) {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(insert);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeSelect(String select) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeQuery(select);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeSelectAll(String selectAll) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);
            displayPersons(resultSet);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public int executeUpdate(String update) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeUpdate(update);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int executeDelete(String delete) {
        try {
            Statement statement = this.connection.createStatement();
            return statement.executeUpdate(delete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayPersons(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username") + "\t"
                    + resultSet.getString("email") + "\t"
                    + resultSet.getString("password") + "\t"
                    + resultSet.getBoolean("enabled") + "\t"
                    + resultSet.getInt("id"));
        }
        System.out.println("\n");
    }
}
