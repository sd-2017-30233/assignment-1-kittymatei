package Business;
import DataAccess.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Cristina on 3/24/2017.
 */
public class ActivityService
{
    public void addActivity(int idEmployee, String description)
    {
        ActivityGateway a=new ActivityGateway();
        LocalDate localDate = LocalDate.now();
        a.addActivity(idEmployee,description, DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate));
    }

    public String viewActivity(String employeeName, String start, String stop)
    {
        EmployeeGateway e=new EmployeeGateway();
        ActivityGateway a=new ActivityGateway();
        int id=e.findByName(employeeName);
        if(id!=0)
        {
            return "Employee : "+ employeeName+ "\n\n"+a.viewActivity(id,start,stop);
        }
        return null;
    }
}
