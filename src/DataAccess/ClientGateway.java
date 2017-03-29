package DataAccess;
import java.sql.*;

/**
 * Created by Cristina on 3/22/2017.
 */
public class ClientGateway extends Gateway
{
    public ClientGateway() {
        super();
    }

    public void addClient(String name, String idCardNumber, String numericalCode, String address)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query = "insert into CLIENT (name, id_card_number, pers_num_code, address) values ('" + name + "','" + idCardNumber + "','" + numericalCode + "','"+address +"');";
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public int findIdClientByName(String name)
    {
        int id=0;
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select id from CLIENT where name='"+name+"';";
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


    public void updateAddress(int id, String newAddress)
    {
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="update CLIENT set address='"+newAddress+"' where id="+id+";";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
    }

    public String viewClient(String name)
    {
        String r="";
        try {
            Connection con=getConnection();
            Statement stmt = con.createStatement();
            String query="select * from CLIENT where name='"+name+"';";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                r+="ID: "+rs.getInt("id")+"\n";
                r+="Name: "+rs.getString("name")+"\n";
                r+="Identity Card Number: "+rs.getString("id_card_number")+"\n";
                r+="Personal Numerical Code: "+rs.getString("pers_num_code")+"\n";
                r+="Address: "+rs.getString("address");
            }

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
        }
        return r;
    }

}
