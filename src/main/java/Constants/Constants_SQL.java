package Constants;

public class Constants_SQL {
    public final static String URL = "jdbc:postgresql://192.168.0.116:5432/newDB";
    public final static String USER = "postgre";
    public final static String PASSWORD = "123456789";

    public final static String FIND_ALL = "SELECT * FROM users where status='true'";
    public final static String ADD_USER = "INSERT INTO users (firstname, lastname, status) VALUES (?, ?, true)";
    public final static String DELETE_USER = "update users set status='false' where status='true' and firstname=? and lastname=?";

}
