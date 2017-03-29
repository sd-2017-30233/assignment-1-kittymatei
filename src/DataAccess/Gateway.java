package DataAccess;

import java.sql.*;


/**
 * Created by Cristina on 3/22/2017.
 */
public class Gateway
{
    private String url = "jdbc:mysql://localhost/Bank";
    private String uid = "root";
    private String pw = "podeni";
    private Connection con;

    public Gateway() {
        con = init();
    }

    Connection getConnection()
    {
        return con;
    }

    public Connection init() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e);
        }

        con = null;
        try {
            con = DriverManager.getConnection(url, uid, pw);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
            System.exit(1);
        }
        return con;
    }
}
