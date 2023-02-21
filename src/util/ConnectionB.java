package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionB {
    public static Connection ab () throws SQLException {

         String url = "jdbc:postgresql://localhost:5432/registration";
        return DriverManager.getConnection(url, "postgres", "123SsAaBgcd00!");
    }
}
