package Registrate;

import Exceptions.UserDataIsNotSuitable;
import Users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrateUser {
    public static void registrate(User user) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/registration";
        Connection connection = DriverManager.getConnection(url, "postgres", "123SsAaBgcd00!");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into public.users values" +
                        "(nextval('user_id'),'"+user.name+"','"+user.surname+"','"+user.email+"','"+
                        user.birthday+"','"+user.password+"')"
        );

        try {
            preparedStatement.executeUpdate();
            System.out.println("Registration completed successfully!");
        }
        catch (Exception e){
            throw new UserDataIsNotSuitable();
        }

        preparedStatement.close();
        connection.close();
    }
}
