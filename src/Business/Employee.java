package Business;
import DataAccess.*;
/**
 * Created by Cristina on 3/22/2017.
 */
public class Employee implements User
{
    public String addEmployee(String name, String username, String password)
    {
        EmployeeGateway e=new EmployeeGateway();
        int id1=e.findByName(name);
        int id2=e.findByUsername(username);
        if(id1!=0)
            return "The name "+name+" already exists!";
        else
            if(id2!=0)
                return "The username "+username+" already exists!";
            else
            {
                e.addEmployee(name,username,password);
                return "Successful operation!";
            }
    }

    public boolean updatePassword(String username, String newPassword)
    {
        EmployeeGateway e=new EmployeeGateway();
        int id=e.findByUsername(username);
        if(id!=0)
        {
            e.updatePassword(id,newPassword);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(String name)
    {
        EmployeeGateway e=new EmployeeGateway();
        ActivityGateway a=new ActivityGateway();
        int id=e.findByName(name);
        if(id!=0)
        {
            a.deleteActivity(id);
            e.deleteEmployee(id);
            return true;
        }
        return false;
    }

    public String viewEmployee(String name)
    {
        EmployeeGateway e=new EmployeeGateway();
        int id=e.findByName(name);
        if(id!=0)
        {
            return e.viewEmployee(id);
        }
        return null;
    }

    public int logIn(String username, String password)
    {
        EmployeeGateway e=new EmployeeGateway();
        int id=e.findByUsernameAndPassword(username, password);
        if(id!=0)
            return id;
        return 0;
    }
}
