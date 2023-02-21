package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionB {

    private static Connection con;



    public static Connection getCon () throws SQLException, ClassNotFoundException {
        if(con!=null && !con.isClosed())return con;
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/registration";
        con = DriverManager.getConnection(url, "postgres", "123SsAaBgcd00!");
        return con;

    }
}
