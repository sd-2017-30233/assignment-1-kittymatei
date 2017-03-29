package DataAccess;
import java.sql.*;


/**
 * Created by Cristina on 3/23/2017.
 */
public class EmployeeGateway extends Gateway
{
    public EmployeeGateway()
    {
        super();
    }
    public int findByName(String name)
    {
        int id=0;
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select id from EMPLOYEE where name='"+name+"';";
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


    public int findByUsername(String username)
    {
        int id=0;
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select id from EMPLOYEE where username='"+username+"';";
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

    public int findByUsernameAndPassword(String username,String password)
    {
        int id=0;
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select id from EMPLOYEE where password='"+password+"' and username ='" +username+"';";
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

    public void addEmployee(String name, String username, String password)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query = "insert into EMPLOYEE (name, username, password) values ('" + name + "','" + username + "','" + password + "');";
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public void updatePassword(int id, String newPassword)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="update EMPLOYEE set password='"+newPassword+"' where id="+id+";";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public void deleteEmployee(int id)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="delete from EMPLOYEE where id="+id+";";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public String viewEmployee(int id)
    {
        String r="";
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select * from EMPLOYEE where id="+id+";";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                r+="ID: "+rs.getInt("id")+"\n";
                r+="Name: "+rs.getString("name")+"\n";
                r+="Username: "+rs.getString("username")+"\n";
                r+="Password: "+rs.getString("password");
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
        return r;
    }
}
