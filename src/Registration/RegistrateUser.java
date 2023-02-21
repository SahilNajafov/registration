package Registration;

import Exceptions.EmailFormatIsNotTrue;
import Exceptions.PasswordCantBeLikeThis;
import Exceptions.UserDataIsNotSuitable;
import Users.User;
import util.ConnectionB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrateUser {

    public static void registrate() throws ClassNotFoundException, SQLException {

        Connection connection = ConnectionB.getCon();
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

        String regexForMail = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        String regexForPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

        Pattern pattern = Pattern.compile(regexForMail);
        Matcher matcher = pattern.matcher(user.email);

        Pattern pattern2 = Pattern.compile(regexForPassword);
        Matcher matcher2 = pattern2.matcher(user.password);

        if(matcher.matches() && matcher2.matches()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into public.users values" +
                            "(nextval('user_id'),'" + user.name + "','" + user.surname + "','" + user.email + "','" +
                            user.birthday + "','" + user.password + "')"
            );

            try {
                preparedStatement.executeUpdate();
                System.out.println("Registration completed successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                throw new UserDataIsNotSuitable();
            }

            preparedStatement.close();

        }
        else if(!matcher.matches()){
            throw  new EmailFormatIsNotTrue();
        }
        else{
            throw new PasswordCantBeLikeThis();
        }
//        connection.close();
    }
}
