package Business;
import DataAccess.*;
/**
 * Created by Cristina on 3/25/2017.
 */
public class AdminService implements User
{
    public int logIn(String username, String password)
    {
        AdminGateway a=new AdminGateway();
        return a.findByUsernameAndPassword(username,password);
    }
}
