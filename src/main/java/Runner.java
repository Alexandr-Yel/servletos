

import java.sql.*;
import java.util.Scanner;

import static java.lang.String.format;

public class Runner {

    public static void main(String[] args) throws SQLException {
        //table format
        final String OUTPUT_FORMAT = "%10s | %15s | %11s | %25s | %13s | %12s";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[32m";

        //connect to DB
        final String dbUrl = "jdbc:mysql://localhost:3306/Users_List";
//        final String dbUrl = "jdbc:mysql://192.168.0.100:3306/lex-db";
        final String user = "root";
        final String password = "root";
//        final String password = "rootR00+";
        try {
            Connection cn = null;
            Statement st = null;
            ResultSet rs = null;
            PreparedStatement ps = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection(dbUrl, user, password);
                System.out.println(cn);
                st = cn.createStatement();
                ps = cn.prepareStatement("SELECT * FROM users");
                rs = ps.executeQuery();
//                System.out.println(format(OUTPUT_FORMAT, ANSI_YELLOW+"First name", "Last name", "Birth date", "Film name", "Release date", "Genre"+ANSI_RESET));
                while (rs.next()) {
                    System.out.println(rs.getString("user_name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}