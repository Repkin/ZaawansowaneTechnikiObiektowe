package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Scanner scanner = new Scanner(System.in);
        databaseConnector.connect();

        boolean quit = false;

        while (!quit) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Wyświetl wszystkich użytkowników");
            System.out.println("2. Dodaj nowego użytkownika");
            System.out.println("3. Wyświetl użytkownika");
            System.out.println("4. Zaktualizuj użytkownika");
            System.out.println("5. Usuń użytkownka");
            System.out.println("6. Zakończ");
            System.out.print("> ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Person _person = new Person("", "", "", false, (long) -1);
                    _person.readAllUsers(databaseConnector);
                    break;
                case 2:
                    System.out.print("Podaj nazwę użytkownika: ");
                    String username = scanner.nextLine();
                    System.out.print("Podaj adres email: ");
                    String email = scanner.nextLine();
                    System.out.print("Podaj hasło: ");
                    String password = scanner.nextLine();
                    System.out.print("Użytkownik aktywny: (true/false): ");
                    boolean enabled = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("\n");
                    Person person = new Person(username, email, password, enabled, (long) -1);
                    person.createUser(databaseConnector);
                    break;
                case 3:
                    System.out.print("Podaj nazwę użytkownika: ");
                    username = scanner.nextLine();
                    System.out.print("\n");
                    person = new Person(username, "", "", false, (long) -1);
                    person.readUser(databaseConnector);
                    break;
                case 4:
                    System.out.print("Podaj nazwę użytkownika: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Podaj adres email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Podaj hasło: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Użytkownik aktywny: (true/false): ");
                    boolean newEnabled = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("\n");
                    Person newPerson = new Person(newUsername, newEmail, newPassword, newEnabled, (long) -1);
                    newPerson.updateUser(databaseConnector);
                    break;
                case 5:
                    System.out.print("Podaj nazwę użytkownika: ");
                    username = scanner.nextLine();
                    System.out.print("\n");
                    person = new Person(username, "", "", false, (long) -1);
                    person.deleteUser(databaseConnector);
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }
}