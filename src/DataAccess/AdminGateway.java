package DataAccess;
import java.sql.*;

/**
 * Created by Cristina on 3/25/2017.
 */
public class AdminGateway extends Gateway
{
    public AdminGateway()
    {
        super();
    }

    public int findByUsernameAndPassword(String username, String password )
    {
        int id=0;
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select id from ADMIN where password='"+password+"' and username ='" +username+"';";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                id=rs.getInt("id");
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
        return id;
    }
}
