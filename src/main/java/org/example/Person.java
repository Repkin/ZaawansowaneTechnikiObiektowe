package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    String username;
    String email;
    String password;
    Boolean enabled;
    Long id;

    public Person(String username, String email, String password, Boolean enabled, Long id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.id = id;
    }

    public void createUser(DatabaseConnector databaseConnector) {
        String insert = "INSERT INTO person values " + "(" +
                "'" + this.username + "'," +
                "'" + this.email + "'," +
                "'" + this.password + "'," +
                this.enabled + "," +
                this.id + ")";
        databaseConnector.executeInsert(insert);
    }

    public void readUser(DatabaseConnector databaseConnector) throws SQLException {
        String read = "SELECT * FROM person WHERE username = '" + this.username + "'";
        ResultSet rs = databaseConnector.executeSelect(read);

        while (rs.next()) {
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            boolean enabled = rs.getBoolean("enabled");
            id = rs.getLong("id");
            System.out.println("username: " + username + ", email: " + email + ", password: " + password + ", enabled: " + enabled + ", id: " + id + "\n");
        }
    }

    public void readAllUsers(DatabaseConnector databaseConnector) {
        String readAll = "SELECT username,email, password, enabled, id FROM person";
        databaseConnector.executeSelectAll(readAll);
    }

    public void updateUser(DatabaseConnector databaseConnector) {
        String update = "UPDATE person SET email = '" + this.email + "' WHERE username = '" + this.username + "'";
        int count = databaseConnector.executeUpdate(update);
        System.out.println("Zmieniono " + count + " rekordów. \n");
    }

    public void deleteUser(DatabaseConnector databaseConnector) {
        String delete = "DELETE FROM person WHERE username = '" + this.username + "'";
        int count = databaseConnector.executeDelete(delete);
        System.out.println("Usunięto " + count + " rekordów. \n");
    }
}
