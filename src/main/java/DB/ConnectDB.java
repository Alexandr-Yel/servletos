package DB;

import java.sql.*;

import static Constants.Constants_SQL.*;

public class ConnectDB {
    public ConnectDB() {
    }

    public Connection getConnect() {
        Connection cn = null;
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
}
