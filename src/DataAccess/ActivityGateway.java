package DataAccess;
import java.sql.*;

/**
 * Created by Cristina on 3/24/2017.
 */
public class ActivityGateway extends Gateway
{
    public ActivityGateway()
    {
        super();
    }
    public void addActivity(int idEmployee, String description, String date)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query = "insert into ACTIVITY (id_employee, description, date) values (" + idEmployee + ",'" + description + "','" + date  +"');";
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public void deleteActivity(int idEmployee)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="delete from ACTIVITY where id_employee="+idEmployee+";";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public String viewActivity(int idEmployee, String start, String stop)
    {
        String r="";
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select * from ACTIVITY where id_employee="+idEmployee+" and date <= '"+stop +"' and date >= '"+start+"';";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                r+="Activity ID: "+rs.getInt("id")+"\n";
                r+="Description: "+rs.getString("Description")+"\n";
                r+="Date: "+rs.getString("date")+"\n\n";
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
        return r;
    }
}
