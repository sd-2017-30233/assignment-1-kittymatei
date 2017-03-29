package Business;
import DataAccess.*;
/**
 * Created by Cristina on 3/22/2017.
 */
public class Client
{
    public boolean addClient(String name, String idCardNumber, String numericalCode, String address)
    {
        ClientGateway c=new ClientGateway();
        int id=c.findIdClientByName(name);
        if(id==0)
        {
            c.addClient(name,idCardNumber,numericalCode,address);
            return true;
        }
        return false;
    }


    public boolean updateClientAddress(String name, String newAddress)
    {
        ClientGateway c=new ClientGateway();
        int id=c.findIdClientByName(name);
        if(id!=0)
        {
            c.updateAddress(id,newAddress);
            return true;
        }
        return false;
    }


    public String viewClient(String name)
    {
        ClientGateway c=new ClientGateway();
        int id=c.findIdClientByName(name);
        if(id!=0)
        {
            return c.viewClient(name);
        }
        return null;
    }
}
