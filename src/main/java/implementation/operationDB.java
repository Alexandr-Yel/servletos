package implementation;

import DB.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants_JSP.*;
import static Constants.Constants_SQL.*;

public class operationDB {
    Connection cn = new ConnectDB().getConnect();
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement ps = null;

    public operationDB() {
    }

    public List getUsers() {
        List<User> list = new ArrayList<>();
        try {
            ps = cn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setFirstname(rs.getString(FIRSTNAME));
                user.setLastname(rs.getString(LASTNAME));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }


    public void addUser(String firstname, String lastname) {
        try {
            ps = cn.prepareStatement(ADD_USER);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String firstname, String lastname) {
        try {
            ps = cn.prepareStatement(DELETE_USER);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
