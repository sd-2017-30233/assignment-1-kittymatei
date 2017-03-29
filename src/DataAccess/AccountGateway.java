package DataAccess;
import java.sql.*;


/**
 * Created by Cristina on 3/22/2017.
 */
public class AccountGateway extends Gateway
{
    public AccountGateway()
    {
        super();
    }

    public void addAccount(int idClient, String type, float amount, String date)
    {
        try
        {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query = "insert into ACCOUNT (id_client, type, amount, creation_date) values (" + idClient + ",'" + type + "'," + amount + ",'"+date +"');";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public float findAmount(int id)
    {
        float r=-1;
        try
        {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query = "select amount from ACCOUNT where id=" +id +";";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                r=rs.getFloat("amount");
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
        return r;
    }

    public void updateAmount(int id, float newAmount)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="update ACCOUNT set amount="+newAmount+" where id="+id+";";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }


    public void deleteAccount(int id)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="delete from ACCOUNT where id="+id+";";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public String viewAccounts(int clientId)
    {
        String r="";
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select * from ACCOUNT where id_client="+clientId+";";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                r+="Account: "+rs.getInt("id")+"   ";
                r+="Amount: "+rs.getString("amount")+"   ";
                r+="Type: "+rs.getString("type")+"   ";
                r+="Date of creation: "+rs.getString("creation_date")+"\n";
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
        return r;
    }

}
