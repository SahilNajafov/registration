package LogIn;

import Exceptions.NoSuchUser;
import Users.User;
import util.ConnectionB;

import java.sql.*;

public class LogIn {
    public static void logIn(String email, String password) throws ClassNotFoundException, SQLException {

        Connection connection = ConnectionB.getCon();


        PreparedStatement preparedStatement = connection.prepareStatement("select * from public.users where email='" + email + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        // ? qoy
        if (!resultSet.next()) {
            throw new NoSuchUser();
        } else {
            ResultSet resultSet2 = preparedStatement.executeQuery();
            //bunu whilesiz nece vere bilerem?cunki 100 user olsa hamisini bir-bir yoxlayacaq
            while (resultSet2.next()) {
                if (password.equals(resultSet2.getString("password"))) {
                    System.out.println("Welcome to site!");
                    break;
                } else {
                    throw new NoSuchUser();
                }
            }
            // bunu nece try catch la vere bilerem?
        }


        preparedStatement.close();
//        connection.close();
    }
}
