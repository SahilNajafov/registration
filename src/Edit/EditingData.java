package Edit;

import Exceptions.EmailFormatIsNotTrue;
import Exceptions.PasswordCantBeLikeThis;
import util.ConnectionB;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditingData {

    public static void editName(String email, String password, String newName) throws ClassNotFoundException, SQLException {

        Connection connection = ConnectionB.getCon();

        PreparedStatement preparedStatement = connection.prepareStatement("select name from public.users where email='" + email + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            PreparedStatement preparedStatement2 = connection.prepareStatement("update public.users set name='" + newName + "'" + "where name='" + name + "'");
            preparedStatement2.executeUpdate();
            System.out.println("Name changed!");
            preparedStatement2.close();
        }

//        connection.close();
        preparedStatement.close();
    }

    public static void editSurname(String email, String password, String newSurname) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionB.getCon();

        PreparedStatement preparedStatement = connection.prepareStatement("select surname from public.users where email='" + email + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String surname = resultSet.getString("surname");
            PreparedStatement preparedStatement2 = connection.prepareStatement("update public.users set surname='" + newSurname + "'" + "where surname='" + surname + "'");
            preparedStatement2.executeUpdate();
            System.out.println("Surname changed!");
            preparedStatement2.close();
        }

//        connection.close();
        preparedStatement.close();
    }

    public static void editEmail(String email, String password, String newEmail) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionB.getCon();

        PreparedStatement preparedStatement = connection.prepareStatement("select email from public.users where email='" + email + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        String regexForMail = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regexForMail);
        Matcher matcher = pattern.matcher(newEmail);
        if(matcher.matches()){
            while (resultSet.next()) {
                String email1 = resultSet.getString("email");
                PreparedStatement preparedStatement2 = connection.prepareStatement("update public.users set email='" + newEmail + "'" + "where email='" + email1 + "'");
                preparedStatement2.executeUpdate();
                System.out.println("E-mail changed!");
                preparedStatement2.close();
            }
        }
        else{
            throw new EmailFormatIsNotTrue();
        }


        //connection.close();
        preparedStatement.close();
    }

    public static void editPassword(String email, String password, String newPassword) throws ClassNotFoundException, SQLException {
        Connection connection = ConnectionB.getCon();
        String regexForPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
        Pattern pattern2 = Pattern.compile(regexForPassword);
        Matcher matcher2 = pattern2.matcher(newPassword);


        PreparedStatement preparedStatement = connection.prepareStatement("select password from public.users where email='" + email + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        if(matcher2.matches()){
            while (resultSet.next()) {
                String password1 = resultSet.getString("password");
                PreparedStatement preparedStatement2 = connection.prepareStatement("update public.users set password='" + newPassword + "'" + " where password='" + password1 + "'");
                preparedStatement2.executeUpdate();
                System.out.println("Password changed!");
                preparedStatement2.close();
            }
        }
        else {
            throw new PasswordCantBeLikeThis();
        }


        //connection.close();
        preparedStatement.close();
    }
}
