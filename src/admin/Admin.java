package admin;

import util.ConnectionB;

import java.sql.*;

public class Admin {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try (Connection connection = ConnectionB.getCon()) {
            PreparedStatement stmt = connection.prepareStatement("call select_all_users()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                String password = rs.getString("password");
                Date registration_day = rs.getDate("registration_day");
                System.out.println(id + " " + name + " " + surname + " " + email + " " + birthday + " " + password + " " + registration_day);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}

