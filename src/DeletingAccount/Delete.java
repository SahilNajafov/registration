package DeletingAccount;

import Exceptions.NoSuchUser;
import util.ConnectionB;

import java.sql.*;

public class Delete {
    public static void delete(String email, String password) throws ClassNotFoundException, SQLException {

        Connection connection = ConnectionB.getCon();


        PreparedStatement preparedStatement = connection.prepareStatement("delete from public.users where email='" + email + "' and password='" + password + "'");

        int i = preparedStatement.executeUpdate();
        if (i >= 1) {
            System.out.println("Account deletion completed successfully!");
        } else
            throw new NoSuchUser();

        preparedStatement.close();
        //connection.close();
    }
}
