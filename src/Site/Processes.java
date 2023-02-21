package Registration;

import Exceptions.UserDataIsNotSuitable;
import Registrate.RegistrateUser;
import Users.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Registration {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Surname: ");
        String surname = scanner.next();
        System.out.println("E-mail: ");
        String email = scanner.next();
        System.out.println("Birthday: ");
        System.out.println("Day: ");
        int day = scanner.nextInt();
        System.out.println("Month: ");
        int month = scanner.nextInt();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        System.out.println("Password: ");
        String password = scanner.next();

        User user = new User(name, surname, email, LocalDate.of(year, month, day), password);

        RegistrateUser.registrate(user);

    }

}